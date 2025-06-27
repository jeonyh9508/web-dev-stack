package com.kh.practice2.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {
	private String title;
	private boolean coupon;
	private int accessAge;
	private int count; // 각 책 당 대여된 수 (이렇게 하진 않지만 제일 쉬운 방법)

	public Book(String title, boolean coupon, int accessAge) {
		this.title = title;
		this.coupon = coupon;
		this.accessAge = accessAge;
	}
}
