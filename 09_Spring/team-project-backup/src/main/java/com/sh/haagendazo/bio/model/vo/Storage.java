package com.sh.haagendazo.bio.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Storage {
	private int storageId; // 보관함 ID
	private int labId; // 연구실 위치
	private String type; // 보관 종류 (냉장, 상온 등)
}
/*
CREATE TABLE storage (
  storage_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '보관함 ID',
  lab_id INT NOT NULL COMMENT '연구실 위치',
  type VARCHAR(50) COMMENT '보관 종류 (냉장, 상온 등)'
);
 */
