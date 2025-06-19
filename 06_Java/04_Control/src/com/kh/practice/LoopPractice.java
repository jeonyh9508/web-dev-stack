package com.kh.practice;

import java.util.Arrays;
import java.util.Scanner;

class LoopPractice {
	
	Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {

		LoopPractice l = new LoopPractice();
//		l.method1();
//		l.method2();
//		l.method3();
//		l.method4();
//		l.method5();
		l.method6();
		
	}
 
    /*
        사용자로부터 숫자(1~100) 1개가 입력되었을 때 카운트다운 출력하시오.
        사용자 입력 : 5
        5
        4
        3
        2
        1
     */
    public void method1() {
    	System.out.print("숫자 입력 : ");
    	int num = Integer.parseInt(sc.nextLine());
    	for(int i = num; 100 > i && i >=1; i--) {
    		System.out.println(i);
    	}
    }

    // 1+(-2)+3+(-4)+...과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상 되는지 출력하시오.
    public void method2() {
    	//짝수는 -
    	//홀수는 +
    	int i = 0; // 1이 증가할때마다 부호가 바뀜.
    	int sum = 0; // sum >= 100 까지 루프 
    	int x = 1; // 1 = 양수, -1 = 음수
  
    	while (sum < 100) {
    		sum += ++i * x; // sum += 첫 loop 1 * 1 = 1 , 두번째 loop 2 *- 1 = -2, ...
    		x *= -1; // 루프가 돌 때마다 부호 변경
    	}System.out.println(i + " 까지");
    }

    /*
        사용자로부터 문자열을 입력 받고 문자열에서 검색될 문자를 입력 받아 해당 문자열에 그 문자가 몇 개 있는지 개수를 출력하세요. 

        문자열 : banana
        문자 : a
        banana 안에 포함된 a 개수 : 3

    */
    public void method3() {
    	System.out.print("문자열 : ");
    	String str = sc.next();
    	System.out.print("문자 : ");
    	char ch = sc.next().charAt(0);
    	int sum = 0;
    	
    	for(int i = 0; i < str.length(); i++) {
    		char spell = str.charAt(i);
    		if(spell == ch) {
    			sum += 1;
    		}
    	}System.out.println(str + " 안에 포함된 " + ch + " 개수 : " + sum);
 
    		
    	

    }

    /*
        0이 나올 때까지 숫자를 출력하시오. (random 사용! 0 ~ 10)
        7
        3
        4
        2
        3
        4
        0
     */
    public void method4() {
    	int random = (int)(Math.random()*11); // 0 <= random < 10 
//    	System.out.println(random);
    
    	for(int i = random; i >= 0; i--) {
    		System.out.println(i);}
    }
    

    /*
        주사위를 10번 굴렸을 때 각 눈의 수가 몇 번 나왔는지 출력하세요. (random 사용!)

        1 : 3
        2 : 2
        3 : 1
        4 : 0
        5 : 4
        6 : 0

     */
    public void method5() {
    	
    	int num = 0;
    	while(num < 10) {
    		num++;
    		int random = (int)(Math.random()* 6 + 1);
    	    System.out.println(num + "번째, 주사위 숫자는 : " + random);
    	}
    	
    }

    /*
        사용자의 이름을 입력하고 컴퓨터와 가위바위보를 하세요. 
        컴퓨터가 가위인지 보인지 주먹인지는 랜덤한 수를 통해서 결정하도록 하고, 사용자에게는 직접 가위바위보를 받으세요.
        사용자가 이겼을 때 반복을 멈추고 몇 번 이기고 몇 번 비기고 몇 번 졌는지 출력하세요.

        당신의 이름을 입력해주세요 : 김미경
        가위바위보 : 가위
        컴퓨터 : 가위
        김미경 : 가위
        비겼습니다.

        가위바위보 : 가위 
        컴퓨터 : 바위
        김미경 : 가위
        졌습니다 ㅠㅠ

        가위바위보 : 보
        컴퓨터  바위
        김미경 : 보
        이겼습니다 !
	    비긴 횟수 : 1, 진 횟수 : 1, 이긴 횟수 : 1
    */
    public void method6() {
    	System.out.print("이름을 입력하세요 > ");
    	String name = sc.next();
    	
    	int win = 0;
    	int lose = 0;
    	int draw = 0;
    	
    	boolean rsp = true;
    	
    	while(rsp) {
    		
    	System.out.print("가위 바위 보 : ");
    	String hand = sc.next();
    	//System.out.print(name + " : ");
    	
    	
    	int random = (int)(Math.random()* 3 + 1);
    	
    	switch(random) {
    		case 1 : System.out.println("컴퓨터 : 가위");
    		break;
    		case 2 : System.out.println("컴퓨터 : 바위");
			break;
    		case 3 : System.out.println("컴퓨터 : 보");
			break;
    	}
    	
    	System.out.println(name + " : " + hand);
    	
    	int hand2 = 0;
    	switch(hand) {
	    	case "가위" : hand2 = 1;
			break;
			case "바위" : hand2 = 2;
			break;
			case "보" :hand2 = 3;
			break;	
			default : System.out.println("다시"); continue;
    	}
    	 	
    	    
    	if(random == hand2) {
    		System.out.println("비겼습니다.");
    		draw += 1;
    	} else if (random == 1 && hand2 == 2 ||
    			   random == 2 && hand2 == 3 ||
    			   random == 3 && hand2 == 1) {
    		System.out.println("이겼습니다 !");
    		win += 1;
    	} else {
    		System.out.println("졌습니다.. ");
    		lose += 1;}
    	
    	if(win == 1) {
    		System.out.println("이긴 횟수 : " + win + " 진 횟수 : " + lose + " 비긴 횟수 : " + draw);
    		rsp = false;}
    	}
    }

}


