package com.sh.haagendazo.bio.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder @NoArgsConstructor @AllArgsConstructor
public class BudgetDTO {
	private int budgetId; // 예산 ID
	private int projectId; // 프로젝트 ID
	private String projectName; // 프로젝트 이름
	private String item; // 예산 항목 (시약비, 인건비 등)
	private int amount; // 예산 금액
	private int usedAmount; // 사용된 금액
	private int approvedBy; // 승인자 ID
	private String status; // 승인 상태
	private String comment; // 승인 의견
	private LocalDate approvedAt; // 승인 일자
	private String userName; // 이름
}

