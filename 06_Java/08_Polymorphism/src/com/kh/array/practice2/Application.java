package com.kh.array.practice2;

import java.util.Arrays;
import java.util.Scanner;

import com.kh.array.practice2.model.Member;

public class Application {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*
		 * 회원 수가 3명이 최대 등록 가능 *
		 * 3명 모두 등록되면 "회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다."와 함께 
		 * '1. 새 회원 등록 하지 못하게' 화면상 보이지 않게 처리! // arr[i]가 모두 null이 아니면
		 * 
		 * 최대 등록 가능한 회원 수는 3명입니다.
		 * 현재 등록된 회원 수는 ~명입니다.
		 * 1. 새 회원 등록 - switch 메뉴로
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
		
	Member member = new Member();
	Member[] arr = new Member[3];
	
	/*
	for(Member member : members) {
		System.out.println(member != null && memeber.getId()!=null);}
		*/
	
	System.out.println("최대 등록 가능한 회원 수는 " + arr.length +" 입니다.");
	boolean isTrue = true;
	while(isTrue) {
		if(arr[2] != null) {
			System.out.println("현재 등록된 회원 수는 3명입니다.");
		}else if (arr[1] != null) {
			System.out.println("현재 등록된 회원 수는 2명입니다.");
		}else if (arr[0] != null) {
			System.out.println("현재 등록된 회원 수는 1명입니다.");
		}else 
			System.out.println("현재 등록된 회원 수는 0명입니다.");
		
		if(arr[0] == null || arr[1] == null || arr[2] == null) {
		System.out.println("1. 새 회원 등록");}
		else {System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈합니다.");}
		
		System.out.println("2. 회원 정보 수정");
		System.out.println("3. 전체 회원 정보 출력");
		System.out.println("9. 끝내기");
		System.out.print("메뉴 번호 : ");
		int number = Integer.parseInt(sc.nextLine());
		
	switch (number) {
	case 1 : 	System.out.print("아이디 : ");
				member.setId(sc.nextLine());
				
				if(member.getId() != null) {
				for(int i = 0; i < arr.length; i++) {
					if(arr[i]!=null &&arr[i].getId().equals(member.getId())) {
						System.out.println("아이디 중복");
						continue;
					}
				}
				
				System.out.print("이름 : ");
				member.setName(sc.nextLine());
				System.out.print("비밀번호 : ");
				member.setPwd(sc.nextLine());
				System.out.print("이메일 : ");
				member.setEmail(sc.nextLine());
				System.out.print("성별 (M/F) : ");
				member.setGender(sc.nextLine().charAt(0));
				System.out.print("나이 : ");
				member.setAge(Integer.parseInt(sc.nextLine()));
				}
				
				
				
				if(arr[0] == null) {
					arr[0] = new Member (member.getId(),member.getName(),member.getPwd(),member.getEmail(),member.getGender(),member.getAge());	
				}else if (arr[1] == null) {
					arr[1] = new Member (member.getId(),member.getName(),member.getPwd(),member.getEmail(),member.getGender(),member.getAge());	
				}else if (arr[2] == null) {
					arr[2] = new Member (member.getId(),member.getName(),member.getPwd(),member.getEmail(),member.getGender(),member.getAge());	
				}
				
				break;
	case 2 : 
		System.out.print("수정할 회원의 아이디 : ");
		String id = sc.nextLine();
		System.out.print("수정할 이름 : ");
		String name = sc.nextLine();
		System.out.print("수정할 이메일 : ");
		String email = sc.nextLine();
		System.out.print("수정할 비밀번호 : ");
		String pwd = sc.nextLine();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null && arr[i].getId().equals(id)) {
				arr[i].setName(name);
				arr[i].setEmail(email);
				arr[i].setPwd(pwd);
			}System.out.println("회원 정보가 없습니다.");
			
		}break;
	case 3 : System.out.println("전체 회원 정보");
			for(int i = 0; i < arr.length; i++) {
				System.out.println(arr[i]);
			}
			break;
	case 9 : 
			System.out.println("프로그램 종료");
			isTrue = false;
			break;  
	default : System.out.println("잘못입력");
			}
		}
	}
}
