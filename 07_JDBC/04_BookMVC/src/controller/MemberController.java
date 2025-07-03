package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {

	private MemberDAO md = MemberDAO.getInstance();
	
	// 4. 회원가입 
	public void register(Member member) {
		// id가 primary key 에러 -> 활용
		try {
			md.register(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 5. 로그인
	public Member login (String id , String pwd) {
		return md.login(id, pwd);
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴시 대여중인 책을 모두 기록 삭제
	}
	
}
