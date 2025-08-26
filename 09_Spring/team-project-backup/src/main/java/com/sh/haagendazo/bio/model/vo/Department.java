package com.sh.haagendazo.bio.model.vo;

import lombok.Data;

@Data
public class Department {
	private int deptNo; // 부서 ID
	private String deptName; // 부서명
	private String deptColor; // 부서별 색상
}

/*
CREATE TABLE department (
  dept_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '부서 ID',
  dept_name VARCHAR(100) NOT NULL COMMENT '부서명'
);
 */
