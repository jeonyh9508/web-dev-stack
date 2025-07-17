package com.kh.mybatis.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

// DTO(Data Transfer Object) : 데이터 전송 객체
@Setter @Getter
public class SearchDTO {
	
	private String select;
	private String keyword;

}
