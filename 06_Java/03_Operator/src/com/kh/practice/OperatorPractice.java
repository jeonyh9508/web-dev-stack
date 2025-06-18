package com.kh.practice;

import java.util.Scanner;

public class OperatorPractice {
	
	Scanner sc = new Scanner(System.in);
    
	public static void main(String[] args) {

		OperatorPractice o = new OperatorPractice();
		o.method1();
		o.method2();
		o.method3();
		o.method4();
		o.method5();
		o.method6();
		o.method7();
		o.method8();
		
	}

	//모든 사람이 연필을 골고루 나눠가지려고 한다. 인원 수와 연필 개수를 입력 받고 
	//1인당 동일하게 나눠가진 연필 개수와 나눠주고 남은 연필의 개수를 출력하세요.
	public void method1() {
		System.out.print("인원 수 입력 > ");
		int person = sc.nextInt();
		
		System.out.print("연필 총 개수 > ");
		int pencil = sc.nextInt();
		
		int divide = pencil / person;
		int remain = pencil % person;
		
		System.out.println("나눠가진 연필 : " + divide + " 남은 연필 : " + remain);
	}
	
	//입력 받은 숫자를 산술 연산자만 사용해서 십의 자리 이하는 버리는 코드를 작성하세요.
	//만약 432이라면 400, 111이라면 100이 출력됩니다.
	public void method2() {
		System.out.print("숫자 입력 > ");
		int num = sc.nextInt();
		
		int hundred = num / 100;
		int result = hundred * 100;
		
		System.out.println(result);
		
	}

	//3개의 수를 입력 받아 입력 받은 수가 모두 같으면 true, 아니면 false를 출력하세요.
	public void method3() {
		System.out.print("숫자1 입력 > ");
		int num1 = sc.nextInt();
		System.out.print("숫자2 입력 > ");
		int num2 = sc.nextInt();
		System.out.print("숫자3 입력 > ");
		int num3 = sc.nextInt();
		
		boolean result = num1 == num2 && num2 == num3;
		
		System.out.println(result);
		
	}

	//입력 받은 하나의 정수가 짝수이면 "짝수다", 짝수가 아니면 "짝수가 아니다"를 출력하세요.
	public void method4() {
		System.out.print("숫자 입력 > ");
		int num = sc.nextInt();
		sc.nextLine();
		
		String result = (num % 2 == 1) ? "짝수가 아니다" : (num == 0) ? "0" : "짝수다.";
		
		System.out.println(result);
	}

	//주민번호(-포함)를 입력받아 남자인지 여자인지 구분하여 출력하세요
	public void method5() {
		
		System.out.println("주민번호 (- 포함) 입력 > ");
		String no = sc.nextLine();
		char ch = no.charAt(7);
		
		switch(ch) {
			case '1','3' : 				
				System.out.println("남"); 
				break;
			case '2','4' : 
				System.out.println("여");
				break;
			default :
				System.out.println("정확한 주민번호를 입력해주세요");
			}
		
	}

	//나이를 입력 받아 어린이(13세 이하)인지, 청소년(13세 초과 ~ 19세 이하)인지, 
	//성인(19세 초과)인지 출력하세요.
	public void method6() {
		System.out.println("나이 입력 > ");
		int age = sc.nextInt();
		if(age < 0) {
			System.out.println("나이를 제대로 입력해주세요");
			return;
		}
		if(age <= 13) {
			System.out.println("어린이");
		}else if (age <= 19) {
			System.out.println("청소년");
		}else if (age > 19)
			System.out.println("성인");
		
	}

	//사과의 개수와 바구니의 크기(바구니 1개의 들어가는 사과의 개수)를 입력받아
	//필요한 바구니의 수를 출력하세요
	public void method7() {
		System.out.println("사과 개수 입력 > ");
		int apple = sc.nextInt();
		
		System.out.println("바구니 개수 입력 > ");
		int basket = sc.nextInt();
		
		int need = (apple / basket);
		
		if (apple % basket == 0) {
			System.out.println("필요한 바구니 개수는 : " + need);
		} else {
			need = (apple / basket) + 1;
			System.out.println("필요한 바구니 개수는 : " + need);}
		

	}
	
	//초 단위 시간을 입력받아 1시간 1분 1초 형식으로 출력
	public void method8() {
		System.out.print("초 단위 시간 입력 > ");
		int time = sc.nextInt();
		
		int sec = time % 60;
		int min = (time / 60) % 60;
		int hour = time / 3600;
		
		System.out.println(hour + "시간 " + min + "분 " + sec+ "초");
	
	}
	
}