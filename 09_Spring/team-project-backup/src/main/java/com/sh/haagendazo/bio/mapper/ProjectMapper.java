package com.sh.haagendazo.bio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.bio.model.dto.ProjectDTO;

@Mapper
public interface ProjectMapper {
	List<ProjectDTO> allProject();
	List<ProjectDTO> allProject(ProjectDTO dto);
	ProjectDTO projectDetail(Integer projectId);
	void deleteProject(Integer projectId);
	void insertProject(ProjectDTO dto);
	void updateProject(ProjectDTO dto);
}
