package com.kh.condition;

import java.util.Scanner;

public class B_Switch {

	Scanner sc = new Scanner(System.in);
	
	/*
		switch문
		
		switch(조건식) {
			case 값 1 : 
				조건식의 결과가 값 1과 같은 경우 실행
				break;
			case 값 2 :
				조건식의 결과가 값 2과 같은 경우 실행
				break;
			default :
				조건식의 결과가 일치하는 case문이 없을 때 실행
		}
		
		- case 문의 수는 제한이 없다.
		- 조건식 결과는 정수, 문자, 문자열이어야 한다.
		- 조건문을 빠져나가려면 break 가 필요하다.
		- default 문은 생략 가능하다. (else 와 유사)
	*/
	public void method1() {
		/*
			숫자를 입력 받아 1일 경우 "빨간색", 2일 경우 "파란색", 3일 경우 "초록색" 잘못 입력했을 경우 "잘못입력"
		*/
		System.out.print("숫자를 입력 > ");
	
		switch (sc.nextInt()) {
			case 1 :
				System.out.println("빨간색");
				break;
			case 2 :
				System.out.println("파란색");
				break;
			case 3 :
				System.out.println("초록색");
				break;
			default :
				System.out.println("잘못 입력");
		}
	}
	
	public void method2() {
		/*
			주민번호를 입력받아 "남","여" 출력 (그 외 -> "사람이 아님")
			주민번호 입력 = 000000-0000000
			남자
		*/
		System.out.print("주민번호 입력 > ");
		String no = sc.nextLine();
		/*
		char ch = no.charAt(7);
		
		switch(ch) {
			case '1','3' : 				-> 구버전 case(값, 값) 처리 안됨
				System.out.println("남"); 
				break;
			case '2','4' : 
				System.out.println("여");
				break;
			default :
				System.out.println("사람 아님");
			}
		*/
		String noStr = no.substring(7,8);
		
		switch(Integer.parseInt(noStr)) {
			case 1 : 
			case 3 : 
				System.out.println("남");
				break;
			case 2, 4 : 
				System.out.println("여");
				break;
			default :
				System.out.println("사람 아님");
		}
			
	}
	public static void main(String[] args) {

		B_Switch b = new B_Switch();
//		b.method1();
		b.method2();
	}

}
