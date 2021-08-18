package kr.or.epro.fleaewha.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.Response;
import com.sun.beans.introspect.PropertyInfo.Name;

import kr.or.epro.fleaewha.Dao.MainDao;
import kr.or.epro.fleaewha.Dto.MainDto;
import kr.or.epro.fleaewha.Dto.MemberDto;
import kr.or.epro.fleaewha.Dto.MypageDto;


@RestController
public class MainController {

	@Autowired
	private MainDao mainDao;
	
	@GetMapping("/main")
	public List<MainDto> main(){
		return mainDao.getMainData();
	}
	

	@GetMapping("/mypage")
	public List<MypageDto> mypage(){
		return mainDao.getMyData();
	}
	
	@PostMapping("/login")
	public String login(
		@RequestParam(value="id")String id,
		@RequestParam(value="name")String name,
		@RequestParam(value="email")String email){
		
		MemberDto dto=new MemberDto();
		dto.setId(id);
		dto.setName(name);
		dto.setEmail(email);
		
		mainDao.insertUser(dto);
		if(mainDao.checkUser(id))	
			return "success";
		else
			return "faile";
		}
	}

