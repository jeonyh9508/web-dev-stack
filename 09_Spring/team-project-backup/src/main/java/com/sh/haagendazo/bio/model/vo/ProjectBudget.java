package com.sh.haagendazo.bio.model.vo;

public class ProjectBudget {
	private int budgetId; // 예산 ID
	private int projectId; // 프로젝트 ID
	private String item; // 예산 항목 (시약비, 인건비 등)
	private int amount; // 예산 금액
	private int usedAmount; // 사용된 금액
	private int approvedBy; // 승인자 ID
}

/*
 CREATE TABLE project_budget (
  budget_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '예산 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  item VARCHAR(100) COMMENT '예산 항목 (시약비, 인건비 등)',
  amount INT COMMENT '예산 금액',
  used_amount INT COMMENT '사용된 금액',
  approved_by INT COMMENT '승인자 ID'
);
 */
