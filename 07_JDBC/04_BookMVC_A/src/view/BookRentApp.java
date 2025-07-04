package view;

import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Member;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member member = null;

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
	}

	public void menu() {
		while (true) {
			if(member==null) { // 로그인 X
				menu1();
			} else if(member.getId().equals("admin") && member.getPwd().equals("1234")) {
				// 관리자 들어온 경우
				menu2();
			} else {
				// 일반 회원인 경우
				menu3();
			}
		}

	}
	
	public void menu1() {
		System.out.println("1. 전체 책 조회");
		System.out.println("2. 회원가입");
		System.out.println("3. 로그인");
		System.out.print("선택 > ");
		switch (Integer.parseInt(sc.nextLine())) {
		case 1:
			printBookAll();
			break;
		case 2:
			register();
			break;
		case 3:
			login();
			break;
		}
	}
	
	// 1. 전체 책 조회
	public void printBookAll() {
		
	}
	
	// 2. 회원가입
	public void register() {
		Member member = new Member();
		System.out.print("아이디 > ");
		member.setId(sc.nextLine());
		System.out.print("이름 > ");
		member.setName(sc.nextLine());
		System.out.print("비밀번호 > ");
		member.setPwd(sc.nextLine());
		System.out.print("나이 > ");
		member.setAge(Integer.parseInt(sc.nextLine()));
		System.out.println(mc.register(member));
	}
	
	// 3. 로그인
	public void login() {
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("비밀번호 > ");
		String pwd = sc.nextLine();
		Member member = mc.login(id, pwd);
		if(member!=null) {
			this.member = member;
			System.out.println(member.getName() + "님이 로그인 하셨습니다!");
		} else {
			System.out.println("로그인 실패..! 아이디와 비밀번호를 다시 입력해주세요");
		}
	}
	
	// 관리자로 로그인 했을 때
	public void menu2() {
		System.out.println("1. 책 등록");
		System.out.println("2. 책 삭제");
		System.out.println("3. 로그아웃");
		System.out.print("선택 > ");
		switch (Integer.parseInt(sc.nextLine())) {
		case 1:
			registerBook();
			break;
		case 2:
			sellBook();
			break;
		case 3:
			this.member = null;
			break;
		}
	}
	
	// 1. 책 등록
	public void registerBook() {
		
	}
	
	// 2. 책 삭제
	public void sellBook() {
		
	}
	
	// 일반 회원인 경우
	public void menu3() {
	
		System.out.println("1. 회원탈퇴");
		System.out.println("2. 로그아웃");
		System.out.println("3. 책 대여");
		System.out.println("4. 내가 대여한 책 조회");
		System.out.println("5. 대여 취소");
		System.out.print("선택 > ");
		switch (Integer.parseInt(sc.nextLine())) {
		case 1:
			delete();
			break;
		case 2:
			this.member = null;
			break;
		case 3:
			rentBook();
			break;
		case 4:
			printRentBook();
			break;
		case 5:
			deleteRent();
			break;
		}
	}
	
	// 1. 회원탈퇴
	public void delete() {
		
	}
	
	// 3. 책 대여
	public void rentBook() {
		
	}

	// 4. 내가 대여한 책 조회
	public void printRentBook() {
		
	}
	
	// 5. 대여 취소
	public void deleteRent() {
		
	}
	
}