package com.kh._abstract.step2;

public class PotatoPizza extends Pizza {

	public PotatoPizza(int price, String brand) {
		super(price, brand);
		
	}
/*
	@Override
	public String brand() {
		return "반올림피자";
	}

	@Override
	public int price() {
		return 27000;
	}
	
	@Override
	public String topping() {
		return "포테이토" ;
	}
*/

	@Override
	public void info() {
		System.out.println(this.brand + " 의 포테이토 피자 가격은 " + this.price + " 원");
	}

	@Override
	public void topping() {
		System.out.println("토핑은 감자 포함한다.");
	}

}
