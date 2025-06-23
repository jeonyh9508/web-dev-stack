package com.kh.overriding;

import java.util.Scanner;

import com.kh.inheritance.model.parent.Product;
import com.kh.overriding.model.Customer;
import com.kh.overriding.model.VipCustomer;

public class Application {
	
	/*
		SOLID 의 O
		Open / Closed Principle (개방 - 폐쇄 원칙)
		
		- 기존 코드를 변경하지 않고 확장 가능하다.
	*/

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 이름
		System.out.print("이름 입력 : ");
		String name = sc.nextLine();
		// 일반회원 , VIP
		System.out.print("일반회원 or VIP 둘 중 하나 선택 : ");
		String grade = sc.nextLine();
		// 가격
		System.out.print("가격 입력 : ");
		int price = sc.nextInt();
		
		Customer customer5 = null;
		
		if(grade.equals("VIP")) {
			customer5 = new VipCustomer(name);
			
		} else {
			customer5 = new Customer(name);
		}
		customer5.calc(price);
		System.out.println(customer5);		
		
		
		Product product = new Product();
		product.setBrand("LG");
		customer5.setProduct(product);
		System.out.println(customer5.getProduct().getBrand());
		
		
//		int price = 100000;
		
		Customer customer1 = new Customer("서지은");
		customer1.calc(price);
		System.out.println(customer1);
		
		VipCustomer customer2 = new VipCustomer("김은진");
		customer2.calc(price);
		System.out.println(customer2);
		
		// 동명이인은 없다고 가정
		Customer customer3 = new Customer("서지은");
		VipCustomer customer4 = new VipCustomer("김은진");
		
		System.out.println(customer1.equals(customer3)); 
		System.out.println(customer2.equals(customer4)); 

		
		// 금액 -> 100000
		// ~~님/name 의 등급/grade 은 ~~이며, 지불해야 하는 금액은 ~원/saleRatio이며,
		// 적립된 포인트/bonusRatio는 ~~ /bonusPoint점입니다.
		/*
		
		
		customer1.setBonusPoint((int) (price * customer1.getBonusRatio()));
		
		String result1 = customer1.getName() + "님의 등급은 " + customer1.getGrade() +
				" 이며, 지불해야하는 금액은 " + price + " 원이며, 적립된 포인트는 " + customer1.getBonusPoint() + "점입니다." ;
		
		System.out.println(result1);
		
		int discount = (int) (price * customer2.getSaleRatio());
		
		customer2.setBonusPoint((int) (price * customer2.getBonusRatio()));
		
		String result2 = customer2.getName() + "님의 등급은 " + customer2.getGrade() +
				" 이며, 지불해야하는 금액은 " + (price - discount) + " 원이며, 적립된 포인트는 " + customer2.getBonusPoint() + "점입니다."; 
		
		System.out.println(result2);
		*/
		
		
	}
	
}
