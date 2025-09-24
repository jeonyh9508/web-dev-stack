package dao;

import java.util.List;

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
	
	// 전체 회원 조회
	public List<MemberVO> memberList(){
		SqlSession sql = factory.openSession();
		List<MemberVO> list = sql.selectList("m.member_list");
		sql.close();
		
		return list;
	}
	
	// 회원 가입
	public int memberInsert(MemberVO vo) {
		SqlSession sql = factory.openSession(true);
		int res = sql.insert("m.member_regi", vo);
		sql.close();
		
		return res;
	}
	
	// 회원 삭제
	public int memberDel(int idx) {
		SqlSession sql =factory.openSession(true);
		int res = sql.delete("member_del", idx);
		sql.close();
		
		return res;
	}
	
	// 회원 한명 조회
	public MemberVO member(int idx) {
		SqlSession sql = factory.openSession();
		MemberVO vo = sql.selectOne("member", idx);
		sql.close();
		
		return vo;
	}
	
	// 조회된 한명의 회원 정보 수정
	public int modify(MemberVO vo) {
		SqlSession sql = factory.openSession(true);
		int res = sql.update("member_modify",vo);
		sql.close();
		
		return res;
	}
	
	// id 중복체크
	public MemberVO selectOne(String id) {
		SqlSession sql = factory.openSession();
		MemberVO vo = sql.selectOne("m.selectOne", id);
		sql.close();
		
		return vo;
	}
}
