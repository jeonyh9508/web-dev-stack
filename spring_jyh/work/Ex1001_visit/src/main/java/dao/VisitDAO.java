package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.VisitVO;

public class VisitDAO {
	
	SqlSession sqlSession;
	
	public VisitDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public List<VisitVO> selectList(){
		List<VisitVO> list = sqlSession.selectList("v.visit_list");
		return list;
	}
	
	public int visitInsert(VisitVO vo) {
		int res = sqlSession.insert("v.visit_insert", vo);
		return res;
	}
	
	public int visitUpdate(VisitVO vo) {
		int res = sqlSession.update("v.visit_update",vo);
		return res;
	}
	
	public VisitVO visitOne(int idx) {
		VisitVO vo = sqlSession.selectOne("v.visit_one", idx);
		return vo;
	}
	
	public int visitDel(int idx) {
		int res = sqlSession.delete("visit_del", idx);
		return res;
	}
}
