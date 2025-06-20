package com.kh.practice2;

import java.util.Scanner;

import com.kh.practice2.controller.SnackController;
import com.kh.practice2.model.Snack;

public class Application {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Snack s = new Snack();
		SnackController save = new SnackController();
		
		System.out.println("스낵류를 입력하세요.");
		
		System.out.print("종류 : ");
		s.setKind(sc.nextLine());
		
		System.out.print("이름 : ");
		s.setName(sc.nextLine());
		
		System.out.print("맛 : ");
		s.setFlavor(sc.nextLine());
		
		System.out.print("개수 : ");
		s.setNumOf(Integer.parseInt(sc.nextLine()));
		
		System.out.print("가격 : ");
		s.setPrice(Integer.parseInt(sc.nextLine()));
		
		String result = 
		save.saveData(s.getKind(), s.getName(), s.getFlavor(),s.getNumOf(),s.getPrice());
		
		
		System.out.println(result);
		System.out.println(save.confirmData());	
		
	}

}
