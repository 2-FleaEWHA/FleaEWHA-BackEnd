package kr.or.epro.fleaewha.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kr.or.epro.fleaewha.Dao.MainDao;
import kr.or.epro.fleaewha.Dto.MainDto;


@Service
public class MainServiceImpl{

	@Autowired
	MainDao mainDao;
	
	public List<MainDto> getMainData(){
		return mainDao.getMainData();
	}

}

