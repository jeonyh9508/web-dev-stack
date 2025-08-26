package com.sh.haagendazo.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {
	
	private int customerId;
	private String name;
	private String department;
	private int assignId; // user.userId
	private String phone;
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	
	private int logId;
	private int projectId;
	private String projectName;
	private String description;
	private String clDescription;
	private String userName;
	private int userId;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date logDate;
	private String content;
}