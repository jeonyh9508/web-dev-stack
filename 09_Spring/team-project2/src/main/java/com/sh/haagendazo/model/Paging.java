package com.sh.haagendazo.model;

import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class Paging {

	private int offset = 0; // 시작 위치
	private int limit = 10; // 개수
	
	private int page = 1; // 현재 페이지
	private int pageSize = 10; // 한 페이지 당 페이지 개수
	private int endPage = this.pageSize; // 한 페이지의 마지막 페이지 수
	private int startPage = this.endPage - this.pageSize + 1; // 한 페이지의 첫 페이지 수
	
	/*
	 * page : 1 ~ 10 -> endPage : 10
	 * page : 11 ~ 20 -> endPage : 20
	 * */
	private boolean prev;
	private boolean next;
	
	private int total;  // 전체 항목 수
	
	public Paging(int page, int total) {
		this.page = page;
		this.total = total;
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
	
	private String search; // 검색 키워드
	private String select; // 검색 타입
	private String keyword;
	
	private String name;
	private String email;
	private String password;
	private String gradeName;
	private String deptName;
	private Date createdAt;
	private int deptId;
	private int gradeId;
	private int uploadedBy;
	private int userId;
	
	private String orderBy; // 정렬 기준 : 컬럼
	private String orderDirection; // ASC or DESC : 정렬 방향
	
	private int storageId;
	
	
}