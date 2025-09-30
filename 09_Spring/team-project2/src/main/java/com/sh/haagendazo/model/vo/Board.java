package com.sh.haagendazo.model.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class Board {

	private int boardNo;
	private String title;
	private String content;
	private String url;
	private String type;
	private String uploaderType; // User or Customer
	private int uploadedBy;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date uploadedAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	
}
