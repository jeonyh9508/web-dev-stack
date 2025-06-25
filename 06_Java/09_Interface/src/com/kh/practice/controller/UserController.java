package com.kh.practice.controller;

import java.time.LocalDate;

import com.kh.practice.model.Department;
import com.kh.practice.model.Department_A;
import com.kh.practice.model.DeptType;
import com.kh.practice.model.UserInfo_A;

public class UserController {
	
	private UserInfo_A[] userList = {new UserInfo_A(),
									 new UserInfo_A(),
									 new UserInfo_A()};
	private int count = 0;
	
	// 로그인 -> 유저 정보 클라이언트
	public UserInfo_A login(String id, String password) {
		for(UserInfo_A user : userList) {
			if(id.equals(user.getId()) && password.equals(user.getPassword())) {
				return user;
			}
		}
		return null;
	}
	
	
	// 오버로딩
	public void addUser(int userNo, String id, String password, String email, String name) {
		userList[count].setUserNo(userNo);
		userList[count].setId(id);
		userList[count].setPassword(password);
		userList[count].setEmail(email);
		userList[count].setName(name);
		count++;
	}
	
	public void addUser(String phone, String addr, String gender, LocalDate birthDate, int deptNo) {
		userList[count].setPhone(phone);
		userList[count].setAddr(addr);
		userList[count].setGender(gender);
		userList[count].setBirthDate(birthDate);
		userList[count].setDeptNo(deptNo);
		
		// 테이블이 없는 상태 
		Department_A dept = new Department_A(deptNo, DeptType.findDeptName(deptNo));
		userList[count].setDepartment(dept);
	}
	
	// 메서드 1개
	public void updateUser(UserInfo_A user) {
		for(UserInfo_A info : userList) {
			if(user.getUserNo() == info.getUserNo()) {
				info = user;
			}
		}
	}
	
}
