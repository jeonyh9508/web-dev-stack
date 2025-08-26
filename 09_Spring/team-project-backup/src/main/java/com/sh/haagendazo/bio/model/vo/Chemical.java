package com.sh.haagendazo.bio.model.vo;

import lombok.Data;

@Data
public class Chemical {
	private int chemicalId; // 시약 ID
	private String productName; // 제품명
	private String casNo; // CAS 번호
	private String msdsUrl; // MSDS 링크
	private String hazardClass; // 위험물 분류
	private int stockQty; // 현재 보유 수량
}
/*
CREATE TABLE chemical (
  chemical_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '시약 ID',
  product_name VARCHAR(200) NOT NULL COMMENT '제품명',
  cas_no VARCHAR(50) COMMENT 'CAS 번호',
  msds_url VARCHAR(255) COMMENT 'MSDS 문서 링크',
  hazard_class VARCHAR(50) COMMENT '위험물 분류 (지정수량 등)',
  stock_qty INT COMMENT '보유 수량'
);
*/
