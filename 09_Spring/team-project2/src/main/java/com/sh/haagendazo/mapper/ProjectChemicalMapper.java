package com.sh.haagendazo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.model.Project;

@Mapper
public interface ProjectChemicalMapper {

	List<Project> projectChemicalList (int projectId);
	List<Project> chemicalList ();
	void pcAdd(Project project);
}
