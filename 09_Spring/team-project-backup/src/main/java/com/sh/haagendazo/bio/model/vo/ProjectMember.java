package com.sh.haagendazo.bio.model.vo;

public class ProjectMember {
    private int projectId;    // 프로젝트 ID
    private int userId;       // 사용자(참여자) ID
    private String role;       // 역할 (예: 책임자, 연구원 등)
}

/*CREATE TABLE project_member (
	member_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '프로젝트 멤버 고유 ID',
	project_id INT NOT NULL COMMENT '프로젝트 ID',
	user_id INT NOT NULL COMMENT '사용자(참여자) ID',
	role VARCHAR(50) COMMENT '역할 (책임자, 연구원 등)'
);*/