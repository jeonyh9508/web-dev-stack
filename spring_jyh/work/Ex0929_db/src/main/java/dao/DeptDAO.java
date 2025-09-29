package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import vo.DeptVO;

// 2. DAO 객체 생성  sqlSession을 injection 구조로 받을 준비
public class DeptDAO {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 부서 목록
	public List<DeptVO> selectList(){
		List<DeptVO> list = sqlSession.selectList("d.dept_list");
		
		return list;
	}
	
	// 부서 삭제
	public int delete(int deptno) {
		int res = sqlSession.delete("dept_delete", deptno);
		
		return res;
	}
	
	// 부서 조회
	public DeptVO select_one(int deptno) {
		DeptVO vo = sqlSession.selectOne("dept_one", deptno);
		
		return vo;
	}
	
	public int update(Map<String, Object> map) {
		
		int res = sqlSession.update("modify", map);
		
		return res;
	}
	
}
