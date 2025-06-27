package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class BookController {
	MemberController mc = new MemberController();
	// 선택사항
	private Map<String, Integer> bookCount = new HashMap<>();
	
	// 책 대여
	public Object rentBook(Book book, Member member) {
		
		// 내 책 리스트
		ArrayList<Book> list = member.getBookList();
		
		// 1. 한 사람당 대여할 수 있는 책은 총 3권 "더 이상 대여할 수 없습니다."
		if(list.size() > 2) {
			return "더 이상 대여할 수 없습니다.";
		};
		
		// 2. 해당 사람이 대여한 책은 대여 불가 "이미 대여한 책입니다."
		// 기존 list에 해당 책이 있는 경우 대여 못하게 return
		if(list.contains(book)) {
			return "이미 대여한 책입니다.";
		}
		
		 // 3. 나이 제한에 걸리는 책들 대여 불가능 "나이 제한으로 대여 불가능합니다." (쿠폰이 없는 경우)
		if(member.getCoupon() == 0 && book.getAccessAge() > member.getAge()) {
			return "나이 제한으로 대여 불가능합니다.";
		} 
		
		// 각 책들마다 가능한 대여가 3권까지 (사람이 여러명인 경우)
		if(book.getCount() > 2) {
			return "더 이상 이 책은 대여할 수 없습니다.";}
		 // 대여가능
		
		// Book 객체에 count 추가한 방법
		
		book.setCount(book.getCount()+1);
		
		// 책에 쿠폰이 있는 경우 -> 쿠폰 + 1
		if(book.isCoupon()) {
			member.setCoupon(member.getCoupon() + 1);
		}
		
		
		 // 4. 쿠폰이 있는 경우 나이 제한 걸려도 대여 가능
		if(book.getAccessAge() > member.getAge()) {
			member.setCoupon(member.getCoupon() - 1);
			}
	
		list.add(book); // 실질적으로 유일하게 대여 성공
		member.setBookList(list);
		return member;
	}
	// 책 대여
	
	
}
