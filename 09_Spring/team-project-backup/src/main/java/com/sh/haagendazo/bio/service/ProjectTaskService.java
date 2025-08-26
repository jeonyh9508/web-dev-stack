package com.sh.haagendazo.bio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.mapper.ProjectTaskMapper;
import com.sh.haagendazo.bio.model.vo.ProjectTask;


@Service
public class ProjectTaskService implements ProjectTaskMapper{

	@Autowired
	private ProjectTaskMapper mapper;
	
	public List<ProjectTask> allProjectTask(){
		return mapper.allProjectTask();
	}
}
