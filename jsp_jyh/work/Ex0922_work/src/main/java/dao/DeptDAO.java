package dao;

import java.util.List;

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
		//생성되지 않았으면 생성
		if (single == null)
			single = new DeptDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public DeptDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	public List<DeptVO> select() {
		SqlSession sql =  factory.openSession();
		List<DeptVO> dept = sql.selectList("d.dept_list");
		System.out.println(dept.size());
		sql.close();
		return dept;
	}
	
	public int insert(DeptVO vo) {
		SqlSession sql = factory.openSession();
		int res = sql.insert("d.dept_insert", vo);
		sql.commit();
		sql.close();
		System.out.println(res);
		return res;
	}
}
