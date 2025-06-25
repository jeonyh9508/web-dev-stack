package com.kh.exception.practice2;

import java.util.Scanner;

import com.kh.exception.practice2.controller.MemberController;
import com.kh.exception.practice2.model.Member;

public class Application_A {
	
	Scanner sc = new Scanner(System.in);
	MemberController mc = new MemberController();
	
	
	public static void main(String[] args) {
		
		Application_A app = new Application_A();
		app.mainMenu();
		
		/*
		 * 회원 수가 3명이 최대 등록 가능
		 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다."와 함께
		 * '1. 새 회원 등록 하지 못하게' 화면상 보이지 않게 처리!
		 * 
		 * 최대 등록 가능한 회원 수는 3명입니다.
		 * 현재 등록된 회원 수는 ~명입니다.
		 * 1. 새 회원 등록
		 * 		 -> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
		 * 			"중복된 아이디입니다. 다시 입력해주세요." 출력 후
		 * 			다시 아이디 입력부터 나올 수 있게 처리
		 * 
		 *          아이디 : 
		 *          이름 : 
		 *          비밀번호 : 
		 *          이메일 : 
		 *          성별(M/F) : 
		 *          나이 : 
		 * 2. 회원 정보 수정
		 * 		-> 아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
		 * 			"회원 정보가 없습니다." 출력 후 다시 메인 화면으로
		 * 			
		 * 		   수정할 회원의 아이디 : 
		 * 		   수정할 이름 : 
		 *         수정할 이메일 : 
		 *         수정할 비밀번호 :
		 * 3. 전체 회원 정보 출력
		 * 		-> 반복문 사용해서 끝!
		 * 9. 끝내기 -> 프로그램 종료
		 * 그 외의 번호 -> 잘못 입력하셨습니다. 다시 입력해주세요
		 * 
		 * 메뉴 번호 : 
		 * */
		
	}
	
	// 전체 메뉴
	public void mainMenu() {
		
		boolean check = true;
		while(check) {
			System.out.println("최대 등록 가능한 회원 수는 3명입니다.");
			System.out.println("현재 등록된 회원 수는 " + mc.count + "명입니다.");
			// 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다."와 함께
			// '1. 새 회원 등록 하지 못하게' 화면상 보이지 않게 처리!
			if(mc.count < 3) {
				System.out.println("1. 새 회원 등록");
			} else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");
			}

			System.out.println("2. 회원 정보 수정");
			System.out.println("3. 전체 회원 정보 출력");
			System.out.println("9. 끝내기");
			System.out.print("메뉴 번호 : ");
			try {
				int num = Integer.parseInt(sc.nextLine());
				switch(num) {
				case 1:
					insertMember();
					break;
				case 2:
					updateMember();
					break;
				case 3:
					printAll();
					break;
				case 9:
					System.out.println("프로그램 종료");
					check = false;
					break;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				}
			} catch(Exception e) {
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
			
		}
		
	}
	
	// 메뉴 번호 1번
	public void insertMember() {
		//아이디를 입력 받았는데 기존 멤버 배열에 아이디가 있는 경우
		// "중복된 아이디입니다. 다시 입력해주세요." 출력 후
		// 다시 아이디 입력부터 나올 수 있게 처리
		Member m = new Member();
		System.out.print("아이디 : ");
		m.setId(sc.nextLine());
		try {
		// 아이디 체크 부분
		boolean idCheck = mc.idCheck(m.getId()) == -1; // 아이디가 없는 경우
		// 아이디 이외에 내용이 아이디가 하나라도 있는 경우 안나오게 처리
		if(idCheck) {
			System.out.print("이름 : ");
			m.setName(sc.nextLine());
			System.out.print("비밀번호 : ");
			m.setPwd(sc.nextLine());
			System.out.print("이메일 : ");
			m.setEmail(sc.nextLine());
			System.out.print("성별(M/F) : ");
			m.setGender(sc.nextLine().charAt(0));
			System.out.print("나이 : ");
			m.setAge(Integer.parseInt(sc.nextLine()));
			// 추가 로직
			mc.addInfo(m);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			insertMember();
		}
		
	}
	
	// 메뉴 번호 2번
	public void updateMember() {
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		//아이디를 입력 받았는데 기존 멤버 배열에 아이디가 없는 경우
		//"회원 정보가 없습니다." 출력 후 다시 메인 화면으로
		
		// 아이디 체크 부분
		try {
			boolean idUpdate = mc.updateCheck(id) == -1;
			if(!idUpdate)  {
				System.out.print("수정할 이름 : ");
				String name = sc.nextLine();
				System.out.print("수정할 이메일 : ");
				String email = sc.nextLine();
				System.out.print("수정할 비밀번호 : ");  
				String pwd = sc.nextLine();
				
				// 수정하는 로직
				mc.updateInfo(id, name, email, pwd);
			}
		} catch(Exception e) {
			System.out.println("잘못 입력하셨습니다.");
			updateMember();
		}
		
	}
	
	// 메뉴 번호 3번
	public void printAll() {	
		for(Member member : mc.getMembers()) {
			if(member!=null) {
				System.out.println(member);
			}
		}
	}
	
	
	}
	
	
