package kr.or.epro.fleaewha.dao;

import java.util.List;
import java.util.Map;

import kr.or.epro.fleaewha.dto.MainDto;
import kr.or.epro.fleaewha.dto.MemberDto;
import kr.or.epro.fleaewha.dto.MypageDto;

public interface MainDao {
	List<MainDto> getMainData();
	List<MypageDto> getMyData();
	public void insertUser(MemberDto dto);
	boolean checkUser(String id);
}
