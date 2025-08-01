package com.kh.operator;

import java.util.Scanner;

public class D_Comparison {
	
	/*
		비교 연산자
		- a > b : a 가 b 보다 작은가?
		- a < b : a 가 b 보다 큰가?
		- a <= b : a 가 b 보다 작거나 같은가?
		- a >= b : a 가 b 보다 크거가 같은가?
		- a == b : a 가 b 보다 같은가?
		- a != b : a 가 b 보다 같지 않은가?
		
		- 비교 연산의 조건을 만족하면 true , 만족하지 않으면 false
	*/
	public static void main(String[] args) {
		
		D_Comparison d = new D_Comparison();
//		d.method1();
		d.method2();
	}

	public void method1() {
		
		int a = 10;
		int b = 25;
		
		System.out.println(a == b); // a 와 b 가 같은가? false
		System.out.println(a <= b); // a 가 b 보다 작거나 같은가? true
		
		boolean result = a > b; // 결과가 boolean 값 -> 변수 선언 가능
		System.out.println(result);
		
		System.out.println((a * 2) > (b / 5)); // true (20 > 5)
		
//		짝수, 홀수
//		2로 나눴을 때 나머지가 0 인 경우 == 짝수
//				   나머지가 1 인 경우 == 홀수 == 나머지가 0 이 아닌 경우
		
		System.out.println("a가 짝수인가? : " + (a % 2 == 0));
		System.out.println("b가 홀수인가? : " + (b % 2 == 1));
		System.out.println("b가 홀수인가? : " + (b % 2 != 0));
		System.out.println("b가 홀수인가? : " + !(b % 2 == 0));
		
	}

	public void method2() {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫번째 정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.println("두번째 정수 입력 : ");
		int num2 = sc.nextInt();
		
		// 첫번째 수보다 두번째 수보다 큽니까?
		System.out.println(num1 > num2);
		// 첫번째 수가 짝수입니까 ?
		System.out.println(num1 % 2 == 0);
		// 두번째 수가 'A'보다 큽니까?
		System.out.println(num2 > 'A');
		System.out.println((int)'A'); // A ~ Z : 65 ~ 90 , a ~ z : 97 ~122

	}
}