package com.sh.haagendazo.model.vo;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Approval {
	
	private int approvalId; // 승인 요청 ID
	private int projectId; // 관련 프로젝트 ID
	private int requestedBy; // 요청자 ID (연구원 ID -> user_id)
	private String approvalType; // 요청 유형 (문서, 예산, 시약 등)
	private String approvalContent; // 요청 내용 (추가, 사용, 결제 등)
	private int targetId; // 대상 항목 ID (문서 ID 등) ----> (target)
	private String status; // 상태 (대기, 승인, 반려)
	private String comment; // 관리자 코멘트
	private int approvedBy; // 승인자 ID (관리자 ID -> user_id)
	private LocalDateTime approvedAt; // 승인 일시
	

}
