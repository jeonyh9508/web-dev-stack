package com.kh.operator;

public class C_Arithmetic {

	/*
		산술 연산자
		- + : 더하기
		- - : 빼기
		- * : 곱하기
		- / : 나누기
		- % : 나머지		
	*/
	public static void main(String[] args) {

		C_Arithmetic c = new C_Arithmetic();
//		c.method1();
		c.method2();
	}

	public void method1() {
		
		int num1 = 10;
		int num2 = 3;
		
		System.out.println(" + : " + (num1 + num2)); // 13
		System.out.println(" - : " + (num1 - num2)); // 7 
		System.out.println(" * : " + (num1 * num2)); // 30
		System.out.println(" / : " + (num1 / num2)); // 3 - 나누기 몫
		System.out.println(" % : " + (num1 % num2)); // 1 
		// 문자열과 있으면 산술 연산자는 괄호
	}
	
	public void method2() {
		
		int a = 5;
		int b = 10;
		
		int c = (++a) + b++; // 16, a= 6 b = 11 c= 16
		int d = c / a ; // 16 / 6 = 2, a = 6, c= 16 d = 2
		int e= c % a; // 4 
		int f = e++; // 4, a = 6 b= 11, c= 16 d = 2 e = 5, f = 4
		int g = (--b) + (d--); // 10 + 2 = 12 , a = 6  b= 10, c = 16 d = 1 e = 5, f = 4 g = 12
		int h = c-- * b; // 16 * 10 = 160 , a = 6  b= 10, c = 15 d = 1 e = 5, f = 4 g = 12 h = 160
		int i = (a++) + b / (--c / f) * (g-- - d) % (++e + h); 
			// 6 + 10 / (14 / 4) * (12 - 1) % (6 + 160)  
			// 6+10/(3)*(11)%(166)
			// 6 + 33 % 166
			// 6 + 33
			// 39
		System.out.println(a+","+b+","+c+","+d+","+e+","+f+","+g+","+h+","+i);
	}
}
