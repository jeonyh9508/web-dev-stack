package view;

import java.lang.Enum.EnumDesc;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체
	private Member member = new Member();

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
	}

	public void menu() {
		try {
			// 1. 전체 책 조회 - 로그인 X
			// 2. 회원가입 - 로그인 X
			// 3. 로그인 - 로그인 X
			boolean set = true;
			while (set) {
				System.out.println("안녕하세요");
				System.out.println("1. 회원 가입");
				System.out.println("2. 로그인");
				System.out.println("3. 책 조회");
				System.out.println("9. 프로그램 종료");
				System.out.print("메뉴 번호 선택 : ");
				int select = Integer.parseInt(sc.nextLine());
				switch (select) {
				case 1:
					register();
					login();
					break;
				case 2:
					login();
					break;
				case 3:
					for (Book b : bc.printBookAll()) {
						System.out.println(b);
					}
					menu();
					break;
				case 9:
					set = false;

				}
			}
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
			menu();
		}
	}

	public void adminMenu() {
		// 관리자로 로그인 했을 때
		// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
		// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
		// 3. 로그아웃 - 로그인 O
		try {
			boolean set = true;
			while (set) {
				System.out.println("관리자 하이");
				System.out.println("1. 책 등록");
				System.out.println("2. 책 삭제");
				System.out.println("3. 로그아웃");
				System.out.println("9. 프로그램 종료");
				System.out.print("메뉴 번호 선택 : ");
				int select = Integer.parseInt(sc.nextLine());
				switch (select) {
				case 1:
					try {
						System.out.println("제목 입력 >");
						String title = sc.nextLine();
						System.out.println("저자 입력 >");
						String author = sc.nextLine();
						System.out.println("나이 제한 >");
						int acessAge = Integer.parseInt(sc.nextLine());
						bc.registerBook(title, author, acessAge);
						System.out.println("성공적으로 등록되었습니다.");
						adminMenu();
						break;
					} catch (Exception e) {
						System.out.println("등록 실패");
						break;
					}
				case 2:
					for (Book b : bc.printBookAll()) {
						System.out.println(b);
					}
					System.out.println("삭제할 책번호 입력 > ");
					int bookNo = Integer.parseInt(sc.nextLine());
					bc.sellBook(bookNo);
					adminMenu();
					break;
				case 3:
					menu();
				case 9:
					set = false;
				}
			}
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
		}
	}

	public void basicMenu() {
		try {
			// 1. 회원탈퇴 - 로그인 O (관리자 X)
			// 2. 로그아웃 - 로그인 O
			// 3. 책 대여 - 로그인 O
			// 4. 내가 대여한 책 조회 - 로그인 O
			// 5. 대여 취소 - 로그인 O
			boolean set = true;
			while (set) {
				System.out.println("회원님 하이");
				System.out.println("1. 회원 탈퇴");
				System.out.println("2. 로그아웃");
				System.out.println("3. 책 대여");
				System.out.println("4. 대여한 책 조회");
				System.out.println("5. 대여 취소");
				System.out.println("9. 프로그램 종료");
				System.out.print("메뉴 번호 선택 : ");
				int select = Integer.parseInt(sc.nextLine());
				switch (select) {
				case 1:
					System.out.println("탈퇴하시려면 아이디를 다시 입력해주세요 > ");
					String id = sc.nextLine();
					delete(id);
					menu();
					break;
				case 2:
					menu();
					break;
				case 3:
					for (Book b : bc.printBookAll()) {
						System.out.println(b);
					}
					System.out.println("아이디 입력 > ");
					id = sc.nextLine();
					System.out.println("책번호 입력 > ");
					int bookNo = Integer.parseInt(sc.nextLine());
					rc.rentBook(id, bookNo);
					break;

				case 4:
					System.out.println("아이디 입력 > ");
					id = sc.nextLine();
					System.out.println(rc.printRentBook(id));

					break;
				case 5:
					basicMenu();
					break;
				case 9:
					set = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("다시 입력해주세요");
		}
	}

	public void register() {
		try {
			System.out.println("회원가입 ");
			System.out.print("아이디입력 ");
			String id = sc.nextLine();
			System.out.print("이름입력 ");
			String name = sc.nextLine();
			System.out.print("패스워드입력 ");
			String pwd = sc.nextLine();
			System.out.print("나이입력 ");
			int age = Integer.parseInt(sc.nextLine());

			Member member = new Member(id, name, pwd, age);

			mc.register(member);
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
		}
	}

	public void login() {
		System.out.println("로그인");
		try {
			System.out.print("아이디 입력 > ");
			String id = sc.nextLine();
			System.out.print("비밀번호 입력 > ");
			String pwd = sc.nextLine();

			if (mc.login(id, pwd) != null) {
				basicMenu();
			} else if (id.equals("admin") && pwd.equals("1234")) {
				adminMenu();
			} else {
				menu();
			}
		} catch (Exception e) {
			System.out.println("다시 입력해주세요");
		}
	}

	public void delete(String id) {
		System.out.println("성공적으로 회원탈퇴되었습니다.");
		mc.delete(id);
	}
}
