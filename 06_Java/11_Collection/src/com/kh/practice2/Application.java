package com.kh.practice2;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.practice2.controller.BookController;
import com.kh.practice2.controller.MemberController;
import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	BookController bc = new BookController();
	// 대여 가능한 책 목록
    ArrayList<Book> books = new ArrayList<>();

    {
        books.add(new Book("디스 이즈 이탈리아", false, 0));
        books.add(new Book("리얼 런던", true, 0));
        books.add(new Book("집에서 즐기는 스페인 요리 여행", false, 0));
        books.add(new Book("사퀴트리 샌드위치", false, 0));
        books.add(new Book("원피스 111", true, 15));
        books.add(new Book("귀멸의 칼날 23", false, 19));
        books.add(new Book("진격의 거인 Before the fall 16", false, 19));
    }

	public static void main(String[] args) {
		Application app = new Application();
		
		try {
			app.menu();
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다! 다시 입력해주세요ㅠㅠ");
			app.menu();
		}
		
	}
	
	/*
	 * --> 너무 어렵다면 멤버 1명! 대여하기부터!
	 * 이름 : 
	 * 나이 : 
	 * -> 회원가입/로그인 -> 조건 : 이름과 나이가 일치한 경우!
	 * -> 기존에 회원 중 이름이 있으면 "이미 존재하는 이름입니다. 다시 입력해주실래요?"
	 * 
	 * ==== 메뉴 ====
	 * 1. 마이페이지 -> 본인 정보
	 * 2. 도서 대여하기
	 * 3. 로그아웃
	 * 4. 프로그램 종료
	 * */
	
	
	public void menu()  {
		try {
			System.out.print("이름 : ");
			String name = sc.nextLine();
			System.out.print("나이 : ");
			int age = Integer.parseInt(sc.nextLine());
			boolean result = mc.registerAndLogin(name, age);
			if(!result) {
				System.out.println("이미 존재하는 이름입니다. 다시 입력해주실래요?");
				menu();
			}
			
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다! 다시 입력해주세요ㅠㅠ");
			menu();
		}
		
		boolean check = true;
		while(check) {
			System.out.println("==== 메뉴 ====");
			System.out.println("1. 마이페이지");
			System.out.println("2. 도서 대여하기");
			System.out.println("3. 로그아웃");
			System.out.println("9. 프로그램 종료");
			System.out.print("번호 : ");
			
			int select = Integer.parseInt(sc.nextLine());
			switch(select) {
				case 1:
					System.out.println(mc.getMember());
					break;
				case 2:
					rent();
					break;
				case 3:
					mc.logout();
					menu();
					break;
				case 9:
					check = false;
					break;
				default : 
					System.out.println("다시 입력");
					menu();
			}
		}
		
		
	}
	// 2. 도서 대여하기
	public void rent() {
		// 향상된 for문 : 값만 가지고 올 때 간단하게!
		// 인덱스까지 필요하시다면 일반 for문!
		for(int i = 0; i < books.size(); i++) {
			System.out.println(i + "번째 " + books.get(i));
		}
		System.out.print("대여할 책 번호 선택 : ");
		int select = Integer.parseInt(sc.nextLine());
		
		// 내가 대여할 책 Book 객체 하나
//		System.out.println(books.get(select));
		// Member 객체에 bookList 여기에 추가
//		System.out.println(member.getBookList().add(books.get(select)));
		Object result = bc.rentBook(books.get(select), mc.getMember());
		if(result instanceof Member) {
			System.out.println("성공적으로 대여되었습니다.");
			mc.setMember((Member) result);
		} else {
			System.out.println(result);
		}
		
	}
	
}




