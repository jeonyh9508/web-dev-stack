package com.kh.condition;

import java.util.Scanner;

public class A_If {
	
	Scanner sc = new Scanner(System.in);
	
	/*
		if문
		
		if(조건식) {
			조건식이 참(true)일 때 실행
		} else {
		조건식이 거짓(false) 일 때 실행 
		}
		
		- 보통 조건식에는 비교연산자, 논리연산자를 주로 사용
	*/
	
	public void method1() {
		// 입력받은 성적이 60점 이상이면 "합격입니다" 출력
		// 아니면 "불합격입니다" 출력
		System.out.print("점수를 입력해주세요 > ");
		int score = sc.nextInt();
		
		/*
		if(score >= 60) {
			System.out.println("합격");
		} else System.out.println("불합격");
		*/
		/*
		if(score >= 60) System.out.println("합격"); // 한 줄일 경우만 중괄호({}) 생략 가능
		*/
	
		// 삼항연산자
		System.out.println(score >= 60 ? "합격" : "불합격");
	}
	
	public void method2() {
		// 본인의 이름을 입력했을 때 본인이라면 "본인", 아니면 "본인 아님" 출력
		
		System.out.print("이름 입력 > ");
		String name = sc.next();
		
		System.out.println("name : " + System.identityHashCode(name));
		System.out.println("전영현 : " + System.identityHashCode("전영현"));
		
		if (name.equals("전영현")) {
			System.out.println("본인");
		} else {System.out.println("본인 아님");}
	}
	/*
		if - else if -else 문
		
		if(조건식 1) {
			조건식 1이 참(true)일 때 실행
		} else if (조건식 2) {
			조건식 1이 거짓(false)이고, 조건식 2이 참(true)일 때 실행
		} else {
			조건식 1, 2 가 모두 거짓 (false)일 때 실행
		}
		
		- else if 는 수가 제한이 없다.
	*/
	public void method3() {
	/*
		사용자에게 점수(0~100)를 입력받아서 점수별로 등급 출력
		- 90점 이상 A
		- 90점 미만 80점 이상 B
		- 80점 미만 70점 이상 C
		- 70점 미만 60점 이상 D
		- 60점 미만 F
	*/
		System.out.print("점수를 입력하세요 > ");
		int score = sc.nextInt();
		char grade = '\u0000'; // char 초기화 / String grade = "";
		
	/*
		if (90 <= score && score <= 100) {
			System.out.println("A");
		} else if (80 <= score && score < 90) {
			System.out.println("B");
		} else if (70 <= score && score < 80) {
			System.out.println("C");
		} else if (60 <= score && score < 70) {
			System.out.println("D");
		} else if (0 <= score && score < 60){
			System.out.println("F");
		} else {System.out.println("점수가 이상합니다");}
	*/
		if(score < 0 || score > 100) {
			System.out.println("잘못 입력");
			return; 	// return : 종료
		}
		else if (score >= 90) grade = 'A';
		else if (score >= 80) grade = 'B';
		else if (score >= 70) grade = 'C';
		else if (score >= 60) grade = 'D';
		else grade = 'F';
		System.out.print(grade + " 등급");
	}
	
	public void method4() {
	/*
		세 정수를 입력했을 때 짝수 만 출력
		num1 : 3
		num2 : 4
		num3 : 8	
		4
		8
	*/
		
		System.out.print("첫 번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("두 번째 정수 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("세 번째 정수 입력 : ");
		int num3 = sc.nextInt();

		if(num1 % 2 == 0) System.out.println(num1);
		if(num2 % 2 == 0) System.out.println(num2);
		if(num3 % 2 == 0) System.out.println(num3);
		
	}
	
	public static void main(String[] args) {
		
		A_If a = new A_If();
//		a.method1();
//		a.method2();
//		a.method3();
		a.method4();
	}

}
