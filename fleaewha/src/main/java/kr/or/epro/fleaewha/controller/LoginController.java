package kr.or.epro.fleaewha.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;

import kr.or.epro.fleaewha.Dto.GoogleOAuthRequest;
import kr.or.epro.fleaewha.Dto.GoogleOAuthResponse;
import kr.or.epro.fleaewha.Dto.MemberDto;
import kr.or.epro.fleaewha.Service.MemberServiceImpl;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	MemberServiceImpl service;
	final static String GOOGLE_AUTH_BASE_URL = "https://accounts.google.com/o/oauth2/v2/auth";
	final static String GOOGLE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/token";
	final static String GOOGLE_REVOKE_TOKEN_BASE_URL = "https://oauth2.googleapis.com/revoke";

	@RequestMapping(value="/oauth2callback",method=RequestMethod.GET)
	public String googleAuth(Model model,@RequestParam(value="code") String authCode,HttpServletRequest request,
			HttpSession session, MemberDto vo, RedirectAttributes redirectAttributes) throws Exception {
		
		RestTemplate restTemplate=new RestTemplate();
		
		GoogleOAuthRequest googleOAuthRequestParam=new GoogleOAuthRequest();
		googleOAuthRequestParam.setClientId("484953697760-8hkan2k427jqimf9ssdsfrqpk692l08d.apps.googleusercontent.com");
		googleOAuthRequestParam.setClientSecret("vH7lu7FYErJGsr1DvSCkfyjk");
		googleOAuthRequestParam.setCode(authCode);
		googleOAuthRequestParam.setRedirectUri("http://localhost:8080/login/oauth2callback");
		googleOAuthRequestParam.setGrantType("authorization_code");
		
		ObjectMapper mapper=new ObjectMapper();
		mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
		mapper.setSerializationInclusion(Include.NON_NULL);

		// AccessToken 발급 요청
		ResponseEntity<String> resultEntity = restTemplate.postForEntity(GOOGLE_TOKEN_BASE_URL, googleOAuthRequestParam,
				String.class);
		
		// Token Request
				GoogleOAuthResponse result = mapper.readValue(resultEntity.getBody(), new TypeReference<GoogleOAuthResponse>() {
				});
				
				// ID Token만 추출 (사용자의 정보는 jwt로 인코딩 되어있다)
				String jwtToken = result.getIdToken();
				String requestUrl = UriComponentsBuilder.fromHttpUrl("https://oauth2.googleapis.com/tokeninfo")
						.queryParam("id_token", jwtToken).toUriString();

				String resultJson = restTemplate.getForObject(requestUrl, String.class);

				Map<String, String> userInfo = mapper.readValue(resultJson, new TypeReference<Map<String, String>>() {
				});
				model.addAllAttributes(userInfo);
				model.addAttribute("token", result.getAccessToken()); //토큰 token에 저장!!

				MemberDto checkvo=new MemberDto();
				checkvo.setAccountID(userInfo.get("email"));
				
				String returnURL = "";
				MemberDto loginvo = service.getMember(checkvo);//login check
				
				if (session.getAttribute("login") != null) { // 이미 로그인 되어있는지
					session.removeAttribute("login");
				}
				
				if (loginvo != null) { // 로그인 성공. 이미 구글 id로 db에 저장됨
					System.out.println("구글 ID로 로그인 성공!");
					session.setAttribute("login", loginvo);
					returnURL = "redirect:/main/";
				} else { // 로그인 실패
					System.out.println("구글 정보가 DB에 저장 안되어있음!");
					if (service.insertMember(checkvo) == 0) {
						System.out.println("구글 정보로 회원가입 실패!");
						returnURL = "fail";
					}
					else {
						System.out.println("회원가입 성공!!!");
						session.setAttribute("login", checkvo);
						returnURL = "redirect:/main/";
					}
				}
				return returnURL;
			}
	}

