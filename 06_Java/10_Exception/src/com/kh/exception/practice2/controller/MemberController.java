package com.kh.exception.practice2.controller;

import com.kh.exception.practice2.exception.DuplicateIdException;
import com.kh.exception.practice2.exception.RecordNotFoundException;
import com.kh.exception.practice2.model.Member;

public class MemberController {

	private Member[] members = new Member[3];
	public int count = 0;
	
	// members - getter 
	public Member[] getMembers() {
		return members;
	}
	
	// 추가 로직!
	public void addInfo(Member m) {
		members[count++] = m;
	}
	
	// 메서드 분리
	// 아이디 체크 <- 등록, 수정을 할 때 필요
	public int idCheck(String id) throws DuplicateIdException {

		for (int i = 0; i < members.length; i++) {
			if (members[i] != null && members[i].getId().equals(id)) {
				// 기존 배열에서 아이디가 있는 경우
				throw new DuplicateIdException();
			
			}
		}

		// 아이디가 없는 경우 > 반복문을 빠져나옴
		return -1;
	}
	
	public int updateCheck(String id) throws RecordNotFoundException {

		for (int i = 0; i < members.length; i++) {
			if (members[i] != null && members[i].getId().equals(id)) {
				// 기존 배열에서 아이디가 있는 경우
				return i;
			}
		}

		// 아이디가 없는 경우 > 반복문을 빠져나옴
		throw new RecordNotFoundException();
	}

	public void updateInfo(String id, String name, String email, String pwd) throws RecordNotFoundException {
		int index = updateCheck(id);
		members[index].setName(name);
		members[index].setEmail(email);
		members[index].setPwd(pwd);
	}

}