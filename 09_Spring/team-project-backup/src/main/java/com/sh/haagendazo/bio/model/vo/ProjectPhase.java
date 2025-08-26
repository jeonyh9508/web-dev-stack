package com.sh.haagendazo.bio.model.vo;

public class ProjectPhase {
	private int phaseId; // 프로젝트 단계 고유 ID
	private int projectId; // 연결된 프로젝트 ID
	private String phaseName; // 단계명 (예: 기획, 임상1상)
	private String responsibleDept; // 담당 부서 또는 팀
	private String startDate; // 단계 시작일
	private String endDate; // 단계 종료일
	private int progress; // 진행률 (%)
	private String notes; // 비고
}

/*
 CREATE TABLE project_phase (
  phase_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '프로젝트 단계 고유 ID',
  project_id INT NOT NULL COMMENT '연결된 프로젝트 ID',
  phase_name VARCHAR(100) NOT NULL COMMENT '단계명 (기획, 임상1상 등)',
  responsible_team VARCHAR(100) COMMENT '담당 부서 또는 팀',
  start_date DATE COMMENT '단계 시작일',
  end_date DATE COMMENT '단계 종료일',
  progress INT COMMENT '진행률 (%)',
  notes TEXT COMMENT '비고'
);
 */
