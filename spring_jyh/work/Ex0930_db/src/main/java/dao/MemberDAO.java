package dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.MemberVO;

public class MemberDAO {

	SqlSession sqlSession;

	public MemberDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public List<MemberVO> selectList (){
		List<MemberVO> list = sqlSession.selectList("m.select_list");
		
		return list;
	}
	
	public int memberInsert(MemberVO vo) {
		int res = sqlSession.insert("m.member_insert", vo);
		
		return res;
	}
	
	public MemberVO selectIdCheck(String id) {
		MemberVO vo = sqlSession.selectOne("m.id_check", id);
		
		return vo;
	}

	
	public MemberVO selectOne(int idx) {
		MemberVO vo = sqlSession.selectOne("m.select_one", idx);
		
		return vo;
	}
	
	public int modify(MemberVO vo) {
		int res = sqlSession.update("m.member_modify", vo);
		
		return res;
	}
	
	public int delete(int idx) {
		int res = sqlSession.delete("m.member_del", idx);
		
		return res;
	}
}
