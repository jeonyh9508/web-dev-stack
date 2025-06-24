package com.kh.practice.model;

import java.time.LocalDate;

public class UserInfo {
	private int userNo;
	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String addr;
	private String gender;
	private LocalDate birthDate;
	private Department department;
	
	public UserInfo(int userNo, String id, String password, String email, String name, String phone, String addr,
			String gender, LocalDate birthDate, Department dept) {
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.addr = addr;
		this.gender = gender;
		this.birthDate = birthDate;
		this.department = dept;
	}

	public UserInfo(int userNo, String id, String password, String email, String name) {
		this.userNo = userNo;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
	}
	public UserInfo() {
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "UserInfo [직원번호 = " + userNo + ", 직원 아이디 = " + id + ",직원 비밀번호 = " + password + ", 직원 이메일 = " + email + ", 직원이름 = "
				+ name + ", 직원 전화번호 = " + phone + ", 직원 주소 = " + addr + ", 직원 성별 = " + gender + ", 직원 생일 = " + birthDate 	+ ", 부서 = " + department + "]";
	}
	
	
		
}
