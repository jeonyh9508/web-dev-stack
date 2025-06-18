package com.kh.loop;

import java.util.Scanner;

public class D_While {

	Scanner sc = new Scanner(System.in);
	
	
	/*
		while 문
		
		while(조건식) {
			조건이 true일 경우 계속 실행
		}
	*/
	public void method1() {
	// 1~5 출력
		int i = 1;
		
		while(i <= 5) {
			System.out.println(i);
			i++;
		}
	}
	
	public void method2() {
		/*
			무한루프 & break 문
			- switch, 반복문의 실행을 중지하고 빠져나갈 때 사용
			- 반복문이 중첩되는 경우 break 문이 포함되어 있는 반복문에서만 빠져나간다.
		*/
		while(true) {
			System.out.print("숫자 입력 > ");
			int num = sc.nextInt();
			System.out.println(num);
			// 숫자가 0인 경우 중지!
			if (num == 0) break;
		}
	}
	
	public void method3() {
		/*
		do{
			실행 코드
		}while(조건식);
		- 조건과 상관없이 무조건 한 번은 실행
		*/
	
		int number = 1;
		
		while(number == 0) {
			System.out.println("while");
		}
		
		do {
			System.out.println("do-while");
		} while (number == 0);
	}
	public void method4() {
		/*
			숫자 맞히기 게임
			1과 100 사이의 값 중에 정답을 저희가 정하고,
			컴퓨터(random)가 맞히도록! 몇 번 만에 끝내는지 출력
			해당 숫자보다 정답이 높으면 up 낮으면 down
		*/
		System.out.print("숫자 입력 > ");
		int number = sc.nextInt();
		int min = 1;
		int max = 100;
		
		int count = 0;
		while (true) {
			++count;
			int random = (int)(Math.random() * (max-min+1) + min);
			if(number > random) {
				System.out.println(random + ", Up"); 
				min = random + 1;
			}
			else if(number < random) {
				System.out.println(random + ", Down");
				max = random - 1;
			}
			else {
				System.out.println(random + ", 정답 " + count + "회 만에 맞쳤습니다.");
			break;
			}
		}	
	}
public void method5() {
	/*
	숫자 맞히기 게임 2
	1과 100 사이의 값이 랜덤이고,
	내가 맞히도록 몇 번 만에 끝내는지 출력
	해당 숫자보다 정답이 높으면 up 낮으면 down
	 */
	int random = (int)(Math.random() * 100 + 1);
	
	int count = 0;
	while(true) {
	++count;
	System.out.print("숫자 입력 > ");
	int number = sc.nextInt();
	
	if(random > number) {System.out.println("Up");}
	else if (random < number) {System.out.println("Down");}
	else {System.out.println("정답 " + count + "회 시도"); break;}
	
	}
}

	public void method6() {
		/*
		 --------------------------------
		 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 --------------------------------
		 선택 > 1
		 예금액 > 10000
		 --------------------------------
		 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 --------------------------------
		 선택 > 2
		 출금액 > 5000
		 --------------------------------
		 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 --------------------------------
		 선택 > 3
		 잔고 > 5000
		 --------------------------------
		 1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료
		 --------------------------------
		 선택 > 4
		 프로그램 종료
		*/
	int sum = 0; // 잔고
	boolean check = true;
	
	while(check) {
		System.out.println("--------------------------------");
		System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
		System.out.println("--------------------------------");
		System.out.print("선택 > ");
		int number = sc.nextInt();
	switch (number) {	
		case 1 : System.out.print("예금액 > ");
					sum += sc.nextInt();
					break;
		case 2 : System.out.print("출금액 > ");
					sum -= sc.nextInt();
					break;
		case 3 : System.out.println("잔고 > " + sum);
					break;
		case 4 : System.out.print("프로그램 종료");
				 check = false;
					break;
		default : System.out.println("숫자를 다시 입력"); continue;
		}
//		if(number == 4) {break;}
	}
		
		/*
		int balance = 0;
		while (true) {
			System.out.println("--------------------------------");
			System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
			System.out.println("--------------------------------");
			System.out.print("선택 > ");
		int select = sc.nextInt();
		if(select == 1) {
			System.out.print("예금액 > ");
			balance += sc.nextInt();
		} else if(select == 2) {
			System.out.print("출금액 > ");
			balance -= sc.nextInt();
		} else if(select == 3) {
			System.out.println("잔고 > " + balance);
		} else if(select == 4) {
			System.out.println("프로그램 종료");
			break;
		}
		}
		*/
	}
	
	public static void main(String[] args) {
		D_While d = new D_While();
//		d.method1();
//		d.method2();
//		d.method3();
//		d.method4();
//		d.method5();
		d.method6();
	}

}
