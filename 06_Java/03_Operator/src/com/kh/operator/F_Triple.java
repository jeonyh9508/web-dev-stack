package com.kh.operator;

import java.util.Scanner;

public class F_Triple { // 클래스 명 A ~ 연산 우선 순위

	/*
		삼항 연산자
		
		조건식 ? 값1 : 값2;
		
		- 조건식에는 주로 비교, 논리 연산자가 사용된다.
		- 조건식의 결과가 true 이면 값1 을 반환한다.
		- 조건식의 결과가 false 이면 값2 를 반환한다.
	*/
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		F_Triple f = new F_Triple();
//		f.method1();
		f.practice1();
		f.practice2();
	}

	public void method1() {
		
		// 입력받은 수가 양수인지 음수인지 판단
		System.out.print("정수값 >> ");
		int number = sc.nextInt();
		
//		String result = number > 0 ? "양수" : "음수";
		
//		System.out.println(result);
		
		// +) 0인 경우는 0 입니다.
		String result = number > 0 ? "양수" : number == 0 ? "0 입니다" : "음수";
		
		System.out.println(result);
			
	}

	public void practice1() {
	/*
		사용자한테 두 개의 정수값을 입력받아서 두 정수의 곱셈 결과가 100보다 크거나 같은경우
		"결과가 100 이상입니다" 아닌 경우 "결과가 100보다 작습니다" 출력	
	*/
		System.out.print("첫 번째 정수 입력 > ");
		int num1 = sc.nextInt();
		sc.nextLine();
		System.out.print("두 번째 정수 입력 > ");
		int num2 = sc.nextInt();
		sc.nextLine();
		String result = (num1 * num2) >= 100 ? "결과가 100 이상입니다." : "결과가 100보다 작습니다.";
		
		System.out.println(result);
	}
	public void practice2() {
	/*
		사용자한테 문자를 하나 입력받아서 입력한 문자가 대문자이면 "알파벳 대문자입니다."
		소문자이면 "알파벳 소문자입니다.", 둘 다 아니라면 "알파벳이 아니네요"
	*/
		System.out.print("문자를 입력해주세요 : ");
		char ch = sc.nextLine().charAt(0);
		
		String result = ('A' <= ch && ch <= 'Z') ? "알파벳 대문자 입니다." 
						: ('a' <= ch && ch <= 'z') ? "알파벳 소문자 입니다." : "알파벳이 아니네요";
		System.out.println(result);
	}
}
