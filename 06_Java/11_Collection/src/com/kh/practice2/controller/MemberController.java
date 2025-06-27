package com.kh.practice2.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.kh.practice2.model.Book;
import com.kh.practice2.model.Member;

public class MemberController {
	// 전체 회원 목록
	private List<Member> members = new ArrayList<>();
	
	// 현재 로그인 된 회원 (여러명인 경우가 힘들다면)
	private Member member = null;
	
	// 회원가입 및 로그인 처리
	public boolean registerAndLogin(String name, int age) {
		// 회원 가입 -> 회원 목록에 추가
//		members.add(new Member(name, age));
		
		
		

		for(Member member : members) {
			// 이름 나이 동일 로그인
			if(member.getName().equals(name) && member.getAge() == age) {
				// 로그인
				this.member = member;
				return true;
			}
			// 동일 이름 존재 -> 가입 불가
			if(member.getName().equals(name)) {
				return false;
				
		}
	}
		// 회원 가입 처리
			Member m = new Member();
			m.setName(name);
			m.setAge(age);
			members.add(m);
			this.member = m;
			return true;
	
//		// 로그인
//		member = new Member();
//		member.setName(name);
//		member.setAge(age);
		
	
		// 동일 이름 존재하면 가입 불가 처리
		// 이름 나이가 동일하면 로그인
		// 기존에 이름이 없으면 가입후 로그인
	}
	public void logout() {
		member = null;
	}
	
	public Member getMember() {
		return member;
	}
	// 대여 후 멤버 정보 새로 저장
	public void setMember(Member member) {
		for(int i = 0; i < members.size(); i++) {
			Member m = members.get(i);
			if(m.getName().equals(member.getName())) {
			members.set(i, member);
			}
		}
	}
}
