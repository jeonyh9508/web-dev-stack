package com.sh.haagendazo.user.model.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @AllArgsConstructor @Data
public class UserInfo {
	
	private int userNo;
	private String userName;
	private String email;
	private String id;
	private String pwd;
	private String phone;
	private String addr;
	private String gender;
	private LocalDate hireDate;
	private LocalDate quitDate;
	private LocalDate birthDate;
	private int deptNo;
	private int gradeNo;
}
