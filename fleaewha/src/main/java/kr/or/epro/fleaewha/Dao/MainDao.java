package kr.or.epro.fleaewha.Dao;

import java.util.List;
import java.util.Map;

import kr.or.epro.fleaewha.Dto.MainDto;
import kr.or.epro.fleaewha.Dto.MemberDto;
import kr.or.epro.fleaewha.Dto.MypageDto;

public interface MainDao {
	List<MainDto> getMainData();
	List<MypageDto> getMyData();
	public void insertUser(MemberDto dto);
	boolean checkUser(String id);
}
