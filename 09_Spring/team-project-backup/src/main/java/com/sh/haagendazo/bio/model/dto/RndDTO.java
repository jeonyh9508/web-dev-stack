package com.sh.haagendazo.bio.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder @Data @AllArgsConstructor @NoArgsConstructor
public class RndDTO {
	private int userNo; // 사용자 ID
	private String userName; // 이름
	
	private int projectId; // 프로젝트 고유 ID
	private String projectName; // 프로젝트명
	
	private String docName; // 문서명
	private String docType; // 문서 유형 (계획서, 시험 결과 등)
	private String filePath; // 파일 경로
	private int uploadedBy; // 업로더 ID
	private String uploadedAt; // 업로드 일자
	
	private int labId; // 연구실 ID
	private String labName; // 연구실명
	private String location; // 위치
	private String contact; // 연락처
	
	private String type; // 보관 종류 (냉장, 상온 등)
}
