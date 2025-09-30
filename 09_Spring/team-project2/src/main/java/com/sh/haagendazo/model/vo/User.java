package com.sh.haagendazo.model.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class User{
	
	private int userId;			// Primary Key
	private String email;		// 로그인 아이디로 활용
	private String password;	// 암호화로 저장
	private String name;
	private int gradeId;
	private int deptId;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	private int managerId;		// 관리자 id (상위)

}
