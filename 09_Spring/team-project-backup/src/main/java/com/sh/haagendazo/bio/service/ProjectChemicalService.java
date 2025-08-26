package com.sh.haagendazo.bio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.mapper.ProjectMapper;
import com.sh.haagendazo.bio.model.dto.ProjectDTO;
import com.sh.haagendazo.bio.model.vo.Project;



@Service
public class ProjectChemicalService {

	@Autowired
	private ProjectMapper mapper;
	
}
