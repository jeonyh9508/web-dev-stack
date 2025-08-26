package com.sh.haagendazo.bio.model.vo;

import java.time.LocalDate;

public class ProjectChemical {
	private int chemUseId; // 고유 ID
	private int projectId; // 프로젝트 ID
	private int chemicalId; // 시약 ID (CAS No 등 연결)
	private int quantityUsed;// 사용량
	private String unit; // 단위 (mg, g 등)
	private LocalDate usedAt; // 사용일자
}

/*
CREATE TABLE project_chemical (
  chem_use_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '시약 사용 기록 고유 ID',
  project_id INT NOT NULL COMMENT '프로젝트 ID',
  chemical_id INT NOT NULL COMMENT '시약 ID (CAS 번호)',
  quantity_used INT COMMENT '사용량',
  unit VARCHAR(10) COMMENT '단위 (mg, g 등)',
  used_at DATE COMMENT '사용 일자'
);
 */
