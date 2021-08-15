package kr.or.epro.fleaewha.Dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.or.epro.fleaewha.Dto.MemberDto;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqlSession;
	
	public MemberDto getMember(MemberDto dto) {
		return sqlSession.selectOne("Member.getMember", dto);
	}
	
	public int insertMember(MemberDto dto) {
		int result=sqlSession.insert("Member.insertMember",dto);
		return result;
	}
}
