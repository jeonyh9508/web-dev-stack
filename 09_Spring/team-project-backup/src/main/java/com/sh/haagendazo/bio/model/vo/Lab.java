package com.sh.haagendazo.bio.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Lab {
	private int labId; // 연구실 ID
	private String labName; // 연구실명
	private String location; // 위치
	private String contact; // 연락처
}

/*
 CREATE TABLE lab (
  lab_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '연구실 ID',
  lab_name VARCHAR(100) NOT NULL COMMENT '연구실명',
  location VARCHAR(255) COMMENT '위치',
  contact VARCHAR(100) COMMENT '연락처'
);
 */
