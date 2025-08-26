package com.sh.haagendazo.bio.model.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ApprovalHistory {
	private int approvalId; // 승인 ID
	private int projectId; // 프로젝트 ID
	private int approverId; // 승인자 ID
	private String status; // 승인 상태
	private String comment; // 승인 의견
	private LocalDate approvedAt; // 승인 일자
}

/*
 CREATE TABLE approval_history (
  approval_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '승인 이력 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  approver_id INT NOT NULL COMMENT '승인자 ID',
  status VARCHAR(20) COMMENT '승인 상태 (대기, 승인, 반려)',
  comment TEXT COMMENT '승인 의견',
  approved_at DATETIME COMMENT '승인 일자'
);*/
