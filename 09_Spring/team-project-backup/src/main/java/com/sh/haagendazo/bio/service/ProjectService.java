package com.sh.haagendazo.bio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.mapper.ProjectMapper;
import com.sh.haagendazo.bio.model.dto.ProjectDTO;



@Service
public class ProjectService {

	@Autowired
	private ProjectMapper mapper;
	
	public List<ProjectDTO> allProject(){
		List<ProjectDTO> list = mapper.allProject();
		 for (ProjectDTO project : list) {
			 if(project.getManagerId() == null || project.getManagerId() == 0) {
				 project.setUserName("미배정");
			 }

	     }
		return list;
	}
	
	public void deleteProject(Integer projectId){
		mapper.deleteProject(projectId);
	}
	
	public List<ProjectDTO> searchProject(ProjectDTO dto){
		List<ProjectDTO> list = mapper.allProject(dto);
		 for (ProjectDTO project : list) {
	            if (project.getManagerId() == null || project.getManagerId() == 0) {
	                project.setUserName("미배정"); // 미배정 처리
	          }
	     }
		return list;
	}
	
	public ProjectDTO projectDetail(Integer projectId) {
		return mapper.projectDetail(projectId);
	}
	
	public void insertProject(ProjectDTO dto) {
		mapper.insertProject(dto);
	}
	
	public void updateProject(ProjectDTO dto) {
		mapper.updateProject(dto);
	}
}
