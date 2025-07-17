package com.project.erp.finance.vo;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Salary {
	private int salaryNo; // 급여번호
	private LocalDate salaryDate; //지급일
	private int baseSalaey;  // 기본급
	private int bonus; // 보너스
	private int overTime; //초과근무 수당
	private int deduction; // 공제금액
	private int tax;  // 세금
	private int userNo;  //사용자 번호
// TIMESTAMP CURRENT_TIMESTAMP 시간 세분화
}
