package com.sh.haagendazo.bio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.mapper.ProjectDocumentMapper;
import com.sh.haagendazo.bio.model.dto.RndDTO;


@Service
public class ProjectDocumentService implements ProjectDocumentMapper{

	@Autowired
	private ProjectDocumentMapper mapper;

	@Override
	public List<RndDTO> allRnd() {
		return mapper.allRnd();
	}

	@Override
	public List<RndDTO> searchRnd() {
		return mapper.searchRnd();
	}

	@Override
	public void deleteRnd(String projectId) {
		mapper.deleteRnd(projectId);
	}
	
//	@Override
//	public void deleteRnd(String projectId) {
//		
//	}

}
