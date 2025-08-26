package com.sh.haagendazo.bio.model.dto;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Builder;
import lombok.Data;

@Builder @Data
public class ProjectDTO {
	private Integer projectId; // 프로젝트 고유 ID
	private String projectCode; // 프로젝트 코드 (예: PJT-2025-001)
	private String projectName; // 프로젝트명
	private String projectType; // 프로젝트 유형 (예: 신약개발, 제네릭 등)
	private Integer managerId; // 프로젝트 책임자 ID
	private String status; // 상태 (계획중, 진행중, 완료 등)
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate; // 시작일
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate; // 종료일
	private Date createdAt; // 생성일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt; // 수정일
	private String userName; // 이름
	private String role;
	
	private String select;
	private String search;
	
}