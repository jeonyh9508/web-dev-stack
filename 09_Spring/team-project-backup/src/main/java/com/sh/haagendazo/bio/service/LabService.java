package com.sh.haagendazo.bio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.mapper.LabMapper;
import com.sh.haagendazo.bio.model.dto.RndDTO;


@Service
public class LabService implements LabMapper{
	
	@Autowired
	private LabMapper mapper;

	@Override
	public List<RndDTO> allRnd() {
		return mapper.allRnd();
	}

	@Override
	public void deleteRnd(String projectId) {
		
	}

}
