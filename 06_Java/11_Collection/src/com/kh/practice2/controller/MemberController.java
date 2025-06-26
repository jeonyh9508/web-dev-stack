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
	public int registerAndLogin(String name, int age) {
		
		if(this.members == null) {
			Member member = new Member();
			this.member.setName(name);
			this.member.setAge(age);
			this.members.add(member);
		}	
		//동일 이름 존재하면 가입 불가 처리
		for(int i = 0; i < this.members.size(); i++) {
			if(this.members.get(i).getName().equals(name)) {
				if(this.members.get(i).getAge() != age) {
				System.out.println("이미 존재하는 이름입니다. 다시 입력해주실래요?");} return 2;
			}else if (this.members.get(i).getName().equals(name) && this.members.get(i).getAge() == age) {
				System.out.println("로그인 성공 !");
			}
		}
		return 1;
	}
	public void logout() {
		
	}
	
	public Member getMember() {
		return this.member;
	}
	
	
	}
