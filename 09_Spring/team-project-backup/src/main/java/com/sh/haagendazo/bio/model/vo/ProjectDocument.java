package com.sh.haagendazo.bio.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProjectDocument {
	private int docId; // 문서 ID
	private int projectId; // 프로젝트 ID
	private String docName; // 문서명
	private String docType; // 문서 유형 (계획서, 시험 결과 등)
	private String filePath; // 파일 경로
	private int uploadedBy; // 업로더 ID
	private String uploadedAt; // 업로드 일자
	private int labId; // 연구실 ID
}

/*
CREATE TABLE project_document (
  doc_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '문서 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  doc_name VARCHAR(200) NOT NULL COMMENT '문서명',
  doc_type VARCHAR(50) COMMENT '문서 유형 (계획서, 분석 보고서 등)',
  file_path VARCHAR(255) COMMENT '파일 저장 경로',
  uploaded_by INT COMMENT '업로더 ID',
  uploaded_at DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '업로드 시각'
);
 */
