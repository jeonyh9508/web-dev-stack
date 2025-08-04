package com.kh.upload.model.vo;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Board {
	// vo -> 테이블과 1대1 매칭
	// 불변성을 갖는게 원칙이지만, 필요에 따라 변경 가능
	private int no;
	private String title;
	private String content;
	private String url;
	private LocalDateTime createdAt;
}
