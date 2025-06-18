package com.kh.practice;

import java.util.Scanner;

public class Practice_A {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		Practice_A v = new Practice_A();
//		v.method1();
//		v.method2(); 
//		v.method3();
//		v.method4();
//		v.method5();
//		v.method6();
		v.method7();
	}
	
	/*
	 * 영화관의 요금표는 다음과 같다.
	 *  - 성인 : 10000원
	 *  - 청소년 : 7000원
	 * 
	 * 성인 2명과 청소년 3명이 영화를 보려고 할 때 지불해야 할 금액을 계산 후 출력하세요.
	 * */

	public void method1() {
		
		int adultPrice = 10000;
		int teenPrice = 7000;

		int adultCount = 2;
		int teenCount = 3;
		System.out.println(adultPrice * adultCount + teenPrice * teenCount);
	}

	/*
	 * x=5, y=7, z=9의 값을 직접 변경하지 않고 변수를 사용하여
	 * 
	 * x=7
	 * y=9
	 * z=5
	 * 
	 * 로 출력하세요.
	 * */

	public void method2() {
		int x = 5;
		int y = 7;
		int z = 9;
		
		// 코드 적어주세요!
		int temp = x;
			x = y;
			y = z;
			z = temp;
			
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("z = " + z);
			
	}



	/*
	 * 정수 두 개를 입력 받아 두 수의 합(+), 차(-), 곱(*), 나누기(/)한 몫을 출력하세요.
	 * 
	 * 첫 번째 정수 : 23
	 * 두 번째 정수 : 7
	 * 더하기 : 30
	 * 빼기 : 16
	 * 곱하기 : 161
	 * 나누기 몫 : 3
	 * */

	public void method3() {
		// 코드 정렬 : 내가 정렬하고자 하는 부분 선택하고 Ctrl + Shift + F
		System.out.print("첫 번째 정수 : ");
		int num1 = Integer.parseInt(sc.nextLine());
		
		System.out.print("두 번째 정수 : ");
		int num2 = Integer.parseInt(sc.nextLine());
		
		System.out.println("더하기 : " + (num1 + num2));
		System.out.println("빼기 : " + (num1 - num2));
		System.out.println("곱하기 : " + (num1 * num2));
		System.out.println("나누기 몫 : " +(num1 / num2));
	
	}

	/*
	 * 가로, 세로 값을 입력 받아 사각형의 면적과 둘레를 계산하여 출력하세요.
	 * 공식) 면적 : 가로 * 세로
	 *       둘레 : (가로 + 세로) * 2
	 * 
	 * 가로 : 13.5
	 * 세로 : 41.7
	 * 면적 : 562.95
	 * 둘레 : 110.4
	 * */

	public void method4() {
		System.out.print("가로 : ");
		double num1 = Double.parseDouble(sc.nextLine());
		 
		System.out.print("세로 : ");
		double num2 = Double.parseDouble(sc.nextLine());
		
		double area = num1 * num2;
		double size = (num1 + num2) * 2;
		System.out.printf("면적 : %.2f\n", area);
		System.out.println("둘레 : " + String.format("%.1f", size));
	}

	/*
	 * 영어 문자열 값을 입력 받아 문자에서 첫번째, 두번째, 마지막 글자(문자열.length())를 출력하세요.
	 * 
	 * 문자열을 입력하세요 : apple
	 * 첫번째 문자 : a
	 * 두번째 문자 : p
	 * 마지막 문자 : e
	 * */
	public void method5() {
		System.out.print("문자열을 입력하세요 : ");
		String word = sc.nextLine();
		System.out.println("첫번째 문자 : " + word.charAt(0));
		System.out.println("두번째 문자 : " + word.charAt(1));
		System.out.println("마지막 문자 : " + word.charAt(word.length() - 1));
	
	}

	/*
	 * 문자 하나를 입력 받아 그 문자와 다음 문자의 유니코드를 출력하세요.
	 * 
	 * 문자 : A
	 * A unicode : 65
	 * B unicode : 66
	 * */
	public void method6() {
		
		System.out.print("문자 : ");
		char word = sc.nextLine().charAt(0);
		int num = word;
		System.out.println(word + " unicode : " + num);
		System.out.println((char)(num + 1) + " unicode : " + (num + 1));

	}
	
	/*
	 * 국어, 영어, 수학 세 과목의 점수를 입력 받아 총점과 평균을 출력하세요.
	 * 
	 * 국어 : 75
	 * 영어 : 63
	 * 수학 : 80
	 * 총점 : 218
	 * 평균 : 72.67
	 * */
	
	public void method7() {
		System.out.print("국어 : ");
		int kor = Integer.parseInt(sc.nextLine());
		
		System.out.print("영어 : ");
		int eng = Integer.parseInt(sc.nextLine());
		
		System.out.print("수학 : ");
		int math = Integer.parseInt(sc.nextLine());
		
		int sum = kor + eng + math;
		
		
		System.out.println("총점 : " + sum);
			
//		System.out.printf("평균 : %.2f", (sum / 3.0));
		System.out.printf("평균 : %.2f", ((double)sum / 3.0));
		
		
	}

}