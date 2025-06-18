package com.kh.loop;

import java.util.Random;
import java.util.Scanner;

public class C_For {

	Scanner sc = new Scanner(System.in);
	
	/*
		for 문
		
		for(초기식; 조건식; 증강식) {
			실행 코드
		}
		
		- 주어진 횟수만큼 코드를 반복 실행하는 구문
		- 초기식 : 반복문이 수행될 때 단 한 번만 실행, 반복문 안에서 사용할 변수를 선언하고 초기값 대입
		- 조건식 : 결과가 true 이면 실행 코드를 실행, false 이면 실행하지 않고 반복문을 빠져나감
		- 증감식 : 반복문에서 사용하는 변수의 값을 증감, 주로 증감 연산자 사용
	*/
	public void method1() {
		
		// 1 ~ 5 출력
		for(int i = 1; i <= 5; i++) {
			System.out.println(i);
		}
	}
	public void method2() {
		
		// 1 ~ 5 반대로 출력
		for(int i = 5; i >= 1; i--) {
			System.out.println(i);
		}
	}
	
	public void method3() {
		// 1 부터 10 까지 홀수만
		System.out.println("1번");
		for(int i = 1; i <= 10; i += 2) {
			System.out.println(i);
		}
		System.out.println("2번 조건문");
		for(int i = 1; i <= 10; i++) {
			if(i % 2 != 0) System.out.println(i);
		}
		/*
			continue 문
			
			- continue 문은 반복문 안에서 사용
			- 반복문 안에서 continue 를 만나면 "현재 구문" 종료
			- 반복문을 빠져나가는 건 아님, 다음 반복 계속 수행		
		*/
		System.out.println("3번 continue");
		for(int i = 1; i <= 10 ; i++) {
			if(i % 2 == 0) continue;
			System.out.println(i);
			
		}
	}
	public void method4() {
		// 1 ~ 10 합계
		int sum = 0;
		
		for(int i = 1; i <= 10; i++) {
			sum += i;
			}
		System.out.println(sum);

	}
	public void method5() {
		// 1 ~ 사용자가 입력한 수 까지 합계
		int sum = 0;
		
		System.out.print("숫자입력 : ");
		int num = Integer.parseInt(sc.nextLine());
		
		for(int i = 1; i <= num; i++) {
			sum += i;
			}
		
		System.out.println(sum);
	}
	
	public void method6() {
		// 1부터 랜덤값(2~10)까지의 합계
		int random = (int) (Math.random() * 9 + 2); // 0.0 <= random < 1.0
		
		Random random2 = new Random();
		int random3 = random2.nextInt(9) + 2; // Random() = 0 ~ 9 까지
		int random4 = random2.nextInt(2,11);
		
		System.out.println("랜덤 값 : " + random4);
		
		int sum = 0;
		for(int i = 1; i <= random3; i++) {
			sum += i;
			}
		System.out.println(sum);
	}
	public void method7() {
		/*
			사용자한테 입력받은 문자열을 세로로 출력
		*/
		System.out.print("문자열 입력 : ");
		String word = sc.nextLine();
	/*
		for(int i = 0; i < word.length(); i++) {
			System.out.println(word.charAt(i));
			}
	*/	
		/*
			향상된 for 문
			for(데이터타입 변수 : 배열){
				변수 : 배열의 값을 하나씩 가지고 옴
			}
			문자열 : 문자의 배열, 여러 개의 문자가 배열을 이룬 것이 문자열
			- toCharArray() : 모든 문자가 들어 있는 char[] 형식의 데이터 반환
			- charAt(int index) : 인덱스에 있는 문자를 char 형식으로 반환 
		*/
		char[] arr = word.toCharArray();
		for(char ch : arr) {
			System.out.println(ch);
		}
	}
	
	public void method8() {
		/*
			중첩 for문
			
			*****
			*****
			*****
			*****
			
		*/
		for(int i = 0; i < 4; i++) {
			System.out.print('*');
			for(int j = 0; j < 4; j++) {
				System.out.print('1');
				}
			System.out.println();
		}
		System.out.println();
		for(int j = 0; j < 4; j++ ) {
			for(int i = 0; i < 5; i ++) {
				System.out.print('*');
			}System.out.println();
		}
	}
	public void method9() {
		/*
			1****
			*2***
			**3**
			***4*
			****5
		*/
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
//				System.out.print("("+ i +","+ j +")");
				if (i == j) {
					System.out.print(i+1);
				} else System.out.print('*');
			
				
			}System.out.println();
		}
	}
	public void method10() {
	/*
		*
		**
		***
		****
		*****	
	*/
		/*
		for(int i = 0; i < 5 ; i++) {
			for(int j = 0; j <= i;  j ++) {
				System.out.print('*');
			}System.out.println();
		}
		*/
		for(int i = 0; i < 5 ; i++) {
			for(int j = 0; j < 5;  j ++) {
				if(i >= j) {
				System.out.print('*');
				}else System.out.print("");
			}System.out.println();
			}
	}
	public void method11() {
		/*
		     * 
		    ** 
		   *** 
		  ****
		 ***** 
		*/
		for(int i = 0; i < 5 ; i++) {
			for(int j = 4; j >= 0; j--) {
				if(i < j) System.out.print(' ');
				else System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		C_For c = new C_For();
//		c.method1();
//		c.method2();
//		c.method3();
//		c.method4();
//		c.method5();
//		c.method6();
//		c.method7();
//		c.method8();
//		c.method9();
//		c.method10();
		c.method11();
	}

}
