package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.SjVO;

public class SjDAO {
 
	SqlSessionFactory factory;

	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static SjDAO single = null;

	public static SjDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new SjDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public SjDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 학생목록 가져오기
	public List<SjVO> select(){
		//mapper로 접근하기 위한 Sqlsession객체 준비
		SqlSession sqlSession = factory.openSession();
		List<SjVO> list = sqlSession.selectList("s.sj_list");
		// Session 조회종료 -> .close()
		sqlSession.close();
		
		return list;
	}
	
	// 학생 정보 등록
	public int register(SjVO vo) {
		SqlSession sqlSession = factory.openSession();
		int res = sqlSession.insert("s.sj_insert", vo);
		sqlSession.commit();
		sqlSession.close();
		return res;
	}
	
	public int del(int no) {
		SqlSession sqlSession = factory.openSession(true);
		int res = sqlSession.delete("s.sj_del",no);
		sqlSession.close();

		return res;
	}
}
