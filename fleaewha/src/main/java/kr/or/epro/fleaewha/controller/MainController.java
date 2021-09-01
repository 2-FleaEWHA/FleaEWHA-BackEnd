package kr.or.epro.fleaewha.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.Response;
//import com.sun.beans.introspect.PropertyInfo.Name;

import kr.or.epro.fleaewha.dao.MainDao;
import kr.or.epro.fleaewha.dto.MainDto;
import kr.or.epro.fleaewha.dto.MemberDto;
import kr.or.epro.fleaewha.dto.MypageDto;


@RestController
public class MainController {

	@Autowired
	private MainDao mainDao;
	
	@GetMapping("/main")
	public List<MainDto> main(){
		return mainDao.getMainData();
	}
	

	@GetMapping("/mypage")
	public Map<String,Object> mypage(HttpSession session){
		
		Map<String,Object> list=new HashMap<String,Object>();
		if(session.getAttribute("id")==null)
			{
				list.put("data",mainDao.getMyData(null));
				return list;
			}
		else {
			if(mainDao.idcheck((String)session.getAttribute("id")))
				{
				list.put("data",mainDao.getMyData((String)session.getAttribute("id")));
				return list;
				}
			else 
			{
				list.put("data",mainDao.getUserData((String)session.getAttribute("id")));
				return list;
			}
			
		}
	}
	
	@PostMapping("/login")
	public HashMap login(
		@RequestParam(value="id")String id,
		@RequestParam(value="name")String name,
		@RequestParam(value="email")String email,
		HttpSession session){
		
		session.setAttribute("id", id);
		
		MemberDto dto=new MemberDto();
		dto.setId(id);
		dto.setName(name);
		dto.setEmail(email);
		HashMap<String,String> list=new HashMap<String,String>();
		mainDao.insertUser(dto);
		if(mainDao.checkUser(id))	
			{
			list.put("msg", "success");
			return list;
			}
		else
		{
			list.put("msg", "fail");
			return list;
		}
	
	}
	
	@RequestMapping(value="/logout")
	public void logout(HttpSession session)throws IOException{
		session.invalidate();
		
	}
}

