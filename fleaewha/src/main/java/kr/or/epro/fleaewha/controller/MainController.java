package kr.or.epro.fleaewha.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import kr.or.epro.fleaewha.Dao.MainDao;
import kr.or.epro.fleaewha.Dto.MainDto;


@RestController
public class MainController {

	@Autowired
	private MainDao mainDao;
	
	@GetMapping("/main")
	public List<MainDto> main(){
		List<MainDto> main=mainDao.selectAll();
		return main;
	}
	
	public void setMainDao(MainDao mainDao)
	{
		this.mainDao=mainDao;
	}
	/*
	@RequestMapping(path="/main",method=RequestMethod.GET)
	@ResponseBody()
	public Map<String,String> main() {
		Map<String,String> list=new HashMap<String,String>();
		
		list.put("title", "과잠");
		list.put("price", "30000");
		list.put("creatTime", "2021.07.21");
		
		return list;
	}*/
}
