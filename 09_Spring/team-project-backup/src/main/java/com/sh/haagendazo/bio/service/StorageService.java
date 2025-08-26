package com.sh.haagendazo.bio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.mapper.StorageMapper;
import com.sh.haagendazo.bio.model.dto.RndDTO;


@Service
public class StorageService implements StorageMapper {
	
	@Autowired
	private StorageMapper mapper;

	@Override
	public List<RndDTO> allRnd() {
		return mapper.allRnd();
	}

	@Override
	public void deleteRnd(String projectId) {
		
	}
}


