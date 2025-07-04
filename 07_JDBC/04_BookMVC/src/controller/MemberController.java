package controller;

import java.sql.SQLException;

import dao.MemberDAO;
import vo.Member;

public class MemberController {

	private MemberDAO md = MemberDAO.getInstance();

	// 4. 회원가입
	public void register(Member member) {
		try {
			md.register(member);
			System.out.println(member.getName() + "님이 회원가입하였습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("회원가입 실패");
		}
	}

	// 5. 로그인
	public Member login(String id, String pwd) {
		try {
			return md.login(id, pwd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// 6. 회원탈퇴
	public void delete(String id) {
		// 회원탈퇴시 대여중인 책을 모두 기록 삭제
		md.delete(id);
	}

}
