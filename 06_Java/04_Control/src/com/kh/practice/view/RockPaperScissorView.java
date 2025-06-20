package com.kh.practice.view;

import java.util.Scanner;

import com.kh.practice.controller.RockPaperScissorController;
import com.kh.practice.model.RockPaperScissor;

public class RockPaperScissorView {

	public void gameStart() {
		Scanner sc = new Scanner(System.in);
		
		RockPaperScissor rpsModel = new RockPaperScissor();
    	RockPaperScissorController controller = new RockPaperScissorController();
    	
    	System.out.print("당신의 이름을 입력해주세요 : ");
    	String name = sc.nextLine();
    	
    	while(true) {
    		System.out.print("가위바위보 : ");
    		String input = sc.nextLine();
    		    		
    		// 컴퓨터는 인덱스로 값을 찾음!
    		System.out.println("컴퓨터 : " + controller.randomComputer());   		
    		System.out.println(name + " : " + input);
    		
    		// 사용자는 값으로 인덱스를 찾으면 어떨까?
    		// 배열에서 값으로 인덱스 찾기 -> 사용자가 입력한 값을 숫자로!
 		
    		int result = controller.rpsGame(input);
    		
    		if(result == 1) { // 비겼을 경우
    			System.out.println("비겼습니다.");
    		
    		} else if(result ==2) { // 이겼을 경우
    			System.out.println("이겼습니다!!");
    			break;
    			
    		} else if(result == 3){ // 졌을 경우
    			System.out.println("졌습니다 ㅠㅠ");
    			
    		}
    	}
	}
}
