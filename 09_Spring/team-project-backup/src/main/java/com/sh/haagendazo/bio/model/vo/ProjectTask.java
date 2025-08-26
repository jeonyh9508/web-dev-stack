package com.sh.haagendazo.bio.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectTask {
	private int taskId; // 업무 고유 ID
	private int projectId; // 프로젝트 ID
	private String taskName; // 업무 이름
	private int assigneeId; // 담당자 ID
	private String dueDate; // 마감일
	private String status; // 상태 (대기, 진행, 완료)
	private String priority; // 우선순위 (상, 중, 하)
	private String notes; // 상세 설명
}

/*
CREATE TABLE project_task (
  task_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '업무 고유 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  task_name VARCHAR(200) NOT NULL COMMENT '업무 이름',
  assignee_id INT COMMENT '담당자 ID',
  due_date DATE COMMENT '마감일',
  status VARCHAR(20) COMMENT '업무 상태 (대기, 진행, 완료)',
  priority VARCHAR(10) COMMENT '우선순위 (상, 중, 하)',
  notes TEXT COMMENT '업무 상세 설명'
); 
 */
