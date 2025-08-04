package com.kh.upload.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor
public class PagingDTO {
	
	private String keyword;
	
	private int offset = 0;
	private int limit = 5;
	
	private int page = 1;
	private int pageSize = 5;
	private int endPage = this.pageSize;
	private int startPage = this.endPage - this.pageSize + 1;
	
	private boolean prev;
	private boolean next;
	
	public PagingDTO(int page, int total) {
		this.page = page;
		this.endPage = (int)(Math.ceil((double)page/this.pageSize)) * this.pageSize;
		this.startPage = this.endPage - this.pageSize + 1;
		
		int lastPage = (int) Math.ceil((double)total/this.limit);
		
		if(lastPage < this.endPage) {
			this.endPage = lastPage;
		}
		
		this.prev = this.startPage > 1;
		this.next = this.endPage < lastPage;
	}
	

}
