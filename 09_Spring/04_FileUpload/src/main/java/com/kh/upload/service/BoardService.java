package com.kh.upload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.upload.mapper.BoardMapper;

@Service
public class BoardService implements BoardMapper{

	@Autowired
	private BoardMapper mapper;
	
	public void fileUpload() {
		mapper.fileUpload();
	}

	@Override
	public void fileAll() {
		mapper.fileAll();
	}

	@Override
	public void fileSearch() {
		mapper.fileSearch();
	}

	@Override
	public void fileDelete() {
		mapper.fileDelete();
	}
	
	@Override
	public void fileUpdate() {
		mapper.fileUpdate();
	}
}
