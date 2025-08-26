package com.sh.haagendazo.bio.model.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
	private int projectId; // 프로젝트 고유 ID
	private String projectCode; // 프로젝트 코드 (예: PJT-2025-001)
	private String projectName; // 프로젝트명
	private String projectType; // 프로젝트 유형 (예: 신약개발, 제네릭 등)
	private int managerId; // 프로젝트 책임자 ID
	private String status; // 상태 (계획중, 진행중, 완료 등)
	private Date startDate; // 시작일
	private Date endDate; // 종료일
	private Date createdAt; // 생성일
	private Date updatedAt; // 수정일
}

/*
 * -- 프로젝트 기본 정보 테이블 
  CREATE TABLE project (
  project_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '프로젝트 고유 ID',
  project_code VARCHAR(50) NOT NULL COMMENT '프로젝트 코드 (예: PJT-2025-001)',
  project_name VARCHAR(200) NOT NULL COMMENT '프로젝트명',
  project_type VARCHAR(50) COMMENT '프로젝트 유형 (신약개발, 제네릭 등)',
  manager_id INT COMMENT '프로젝트 책임자 ID',
  status VARCHAR(20) COMMENT '상태 (계획중, 진행중, 완료 등)',
  start_date DATE COMMENT '프로젝트 시작일',
  end_date DATE COMMENT '프로젝트 종료일',
  created_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
  updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정일시'
);
 */

/*
 * 프로젝트 기본 정보 등록 - Project 단계(비임상, 임상 등 설정) - ProjectPhase 초기 예산 계획 설정 -
 * ProjectBudget 책임자 및 참여자 지정 - ProjectMember 소속 조직 정의 - Institution, Team,
 * Department
 * 
 * 처리 과정 : - 프로젝트 목적과 일정, 연구개발 범위를 설정 - R&D 계획서 작성
 * 
 * 
 * 업무 할당 및 실행 ProjectTask - 개별 업무(Task) 등록 및 담당자 배정 User - 참여자 정보 Lab - 수행 위치
 * (연구실 등) Chemical - 시약 및 물질 투입 계획 Storage - 시약/장비 보관 위치 지정
 * 
 * 처리 과정 : 업무 할당 (Gantt Chart 기반 UI 구성 가능) - 실험 준비 및 자원(시약, 장비 등) 배정 - 문서화 및 진행
 * 상태 기록
 * 
 * 
 * 
 * 3단계 : 실험/테스트 및 시약 사용 기록 ProjectChemical - 사용된 시약 기록 (CAS No, 수량 등) Chemical,
 * Storage - 보관 위치와 재고 차감 연동 Lab - 테스트 수행 위치 - 처리 과정 : 실험 수행 수 시약 소모 기록 - 안전관리
 * 문서(MSDS 등) 추적 - 관련 Task 완료 처리
 * 
 * 4단계 : 문서화 및 보고 ProjectDocument - 시험 결과, 계획서, 분석자료 등 업로드 User - 업로더 추적 처리 과정 -
 * 시험 성적서, 프로토콜, 품질 관리 보고서 등록 - 버전 관리 및 승인자 지정 가능
 * 
 * 5단계 : 승인 및 피드백 ApprovalHistory - 승인 이력 저장 User - 승인자 정보 - 처리 과정 - 각 단계별 결과에
 * 대한 승인 처리 (예 : 분석 결과 승인) - 반려 사유 기록 및 피드백 공유
 * 
 * 6단계 : 성과 분석 및 종료 Project - status - 종료 상태 ProjectResult - 특허, 논문 등 처리 과정 : -
 * 프로젝트 종료 보고서 작성 - 예산 대비 실사용 분석 - 특허 등록 정보 저장
 */