package kr.or.epro.fleaewha.dao;

import java.util.List;
import java.util.Map;

import kr.or.epro.fleaewha.dto.MainDto;
import kr.or.epro.fleaewha.dto.MemberDto;
import kr.or.epro.fleaewha.dto.MypageDto;
import kr.or.epro.fleaewha.dto.UserDto;


public interface MainDao {
	List<MainDto> getMainData();
	List<MypageDto> getMyData(String id);
	public void insertUser(MemberDto dto);
	boolean checkUser(String id);
	boolean idcheck(String id);
	List<UserDto> getUserData(String id);
}
