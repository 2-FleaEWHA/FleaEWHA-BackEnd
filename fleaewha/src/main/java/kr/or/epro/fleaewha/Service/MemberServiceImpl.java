package kr.or.epro.fleaewha.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.or.epro.fleaewha.Dao.MemberDao;
import kr.or.epro.fleaewha.Dto.MemberDto;

@Service
public class MemberServiceImpl {

	@Autowired
	MemberDao memberDao;
	
	public MemberDto getMember(MemberDto dto) {
		return memberDao.getMember(dto);
	}
	
	public int insertMember(MemberDto dto) {
		return memberDao.insertMember(dto);
	}
}
