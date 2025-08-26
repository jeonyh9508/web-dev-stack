package com.sh.haagendazo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.mapper.ProjectChemicalMapper;
import com.sh.haagendazo.model.Project;

@Service
public class ProjectChemicalService {

	@Autowired
	private ProjectChemicalMapper projectChemicalMapper;
	
	public List<Project> projectChemicalList(int projectId) {
		return projectChemicalMapper.projectChemicalList(projectId);
	}
	
	public List<Project> chemicalList(){
		return projectChemicalMapper.chemicalList();
	}
	
	public void pcAdd(Project project) {
		projectChemicalMapper.pcAdd(project);
	}

}
