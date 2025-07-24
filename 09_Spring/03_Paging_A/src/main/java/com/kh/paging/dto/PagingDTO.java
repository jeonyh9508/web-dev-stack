package com.kh.paging.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class PagingDTO {
	// DB에 값 설정
	private int offset = 0; // 시작위치
	private int limit = 10; // 개수
	
	
	private int page = 1; // 현재 페이지 첫 화면
	private int pageSize = 10; // 한 페이지 당 페이지 개수
	private int endPage = this.pageSize; // 한 페이지의 마지막 페이지 수
	private int startPage = this.endPage - this.pageSize + 1; // 한 페이지의 첫 페이지 수
	/*
	 *  page : 1 ~ 10 -> startPage : 1 / endPage : 10
	 *  page : 11 ~ 20 -> startPage : 11 / endPage : 20
	 *  page : 21 ~ 30 -> startPage : 21 / endPage : 30
	 */
	private boolean prev;
	private boolean next;
	
	public PagingDTO(int page, int total) {
		this.page = page;
		this.endPage = (int)(Math.ceil((double)page / this.pageSize)) * this.pageSize;
		this.startPage = this.endPage - this.pageSize + 1;
		
		// 전체 개수를 통해서 마지막 페이지
		int lastPage = (int) Math.ceil((double)total/this.limit);
		
		if(lastPage < this.endPage) {
			this.endPage = lastPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
		
		System.out.println("page = " + page);
		System.out.println("pageSize = " + pageSize);
		System.out.println("endPage = " + endPage);
		System.out.println("startPage = " + startPage);
		System.out.println("prev = " + prev);
		System.out.println("next = " + next);
		System.out.println("this.page = " + this.page);
		System.out.println("this.pageSize = " + this.pageSize);
		System.out.println("this.endPage = " + this.endPage);
		System.out.println("this.startPage = " + this.startPage);
	};


}
