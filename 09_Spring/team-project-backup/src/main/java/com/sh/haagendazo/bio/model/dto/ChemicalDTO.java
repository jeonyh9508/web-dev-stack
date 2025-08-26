package com.sh.haagendazo.bio.model.dto;

public class ChemicalDTO extends PagingDTO {
	private int chemicalId; // 시약 ID
	private String productName; // 제품명
	private String casNo; // CAS 번호
	private String msdsUrl; // MSDS 링크
	private String hazardClass; // 위험물 분류
	private int stockQty; // 현재 보유 수량
}
