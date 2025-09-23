package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.DeptVO;

public class DeptDAO {

	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static DeptDAO single = null;

	public static DeptDAO getInstance() {
		// 생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		//생성된 객체정보를 반환
		// 메모리에 한 개 만 생성 (재활용성)
		return single;
	}
	
	public DeptDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 부서 목록
	public List<DeptVO> select() {
		SqlSession sql =  factory.openSession();
		List<DeptVO> dept = sql.selectList("d.dept_list");
		sql.close();
		
		return dept;
	}
	
	// 부서 추가
	public int insert(DeptVO vo) {
		SqlSession sql = factory.openSession();
		int res = sql.insert("d.dept_insert", vo);
		sql.commit();
		sql.close();
		
		return res;
	}
	
	// 부서 삭제
	public int del(int deptno) {
		// .openSession(true) -> commit
		SqlSession sql = factory.openSession(true);
		int res = sql.delete("d.dept_delete", deptno);
		sql.close();
		
		return res;
	}
	
	// 수정할 부서정보 조회
	public DeptVO modifyDept(int deptno) {
		SqlSession sql = factory.openSession();
		DeptVO vo = sql.selectOne("d.modify_one",deptno);
		sql.close();
		
		return vo;
	}
	
	// 부서 정보 수정
	public int deptUpdate(Map<String, Object> map) {
		SqlSession sql = factory.openSession(true);
		int res = sql.update("d.dept_update", map);
		sql.close();
		
		return res;
	}
}
