package kr.or.epro.fleaewha.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.epro.fleaewha.Dao.MainDao;
import kr.or.epro.fleaewha.Dto.MainDto;


@Service
public class MainServiceImpl implements MainService {

	@Autowired
	MainDao mainDao;
	
	@Override
	@Transactional
	public List<MainDto> selectAll() {
		// TODO Auto-generated method stub
		List<MainDto> list=mainDao.selectAll();
		return list;
	}

}
