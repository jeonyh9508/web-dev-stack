package dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.MemberVO;

public class MemberDAO {

	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static MemberDAO single = null;

	public static MemberDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new MemberDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public MemberDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	
	// 로그인 여부를 확인하는 메서드
	public MemberVO selectOne(String id) {
		
		SqlSession sql = factory.openSession();
		MemberVO vo = sql.selectOne("m.select_id", id);
		sql.close();
		
		return vo;
	}
}
