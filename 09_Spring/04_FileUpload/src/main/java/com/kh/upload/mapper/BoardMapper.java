package com.kh.upload.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	
	void fileUpload();
	void fileAll();
	void fileSearch();
	void fileDelete();
	void fileUpdate();
}
