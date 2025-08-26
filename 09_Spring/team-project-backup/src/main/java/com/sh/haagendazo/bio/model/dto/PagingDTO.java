package com.sh.haagendazo.bio.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class PagingDTO {
	
	private String keyword;
	private String select;
	
	private int offset = 0; // 시작위치
	private int limit = 10; // 개수
	
	private int page = 1; // 현재 페이지
	private int pageSize = 10; // 한 페이지 당 페이지 개수
	private int endPage = this.pageSize; // 한 페이지의 마지막 페이지 숫자 (해당 시점의 페이지 사이즈 값 추출) 
	private int startPage = this.endPage - this.pageSize + 1; // 한 페이지의 첫 페이지 숫자
	
	/*
	 * page_size : 10
	 * page1 : 1 ~ 10 -> end:10
	 * page2 : 11 ~ 20 -> end:20
	 * page3 : 21 ~ 30 -> end:30
	 * 
	 * */
	
	private boolean prev;
	private boolean next;
	
	public PagingDTO(int page, int total) {
		this.page = page;
		this.endPage = (int)(Math.ceil((double)page / this.pageSize)) * this.pageSize;
		this.startPage = this.endPage - this.pageSize + 1;
		
		// 전체 개수를 통해서 마지막 페이지 찾기
		int lastPage = (int) Math.ceil((double)total / this.limit);
		
		if(lastPage < this.endPage) {
			this.endPage = lastPage;
		}
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
	}
	
}
