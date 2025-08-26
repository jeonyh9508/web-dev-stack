package com.sh.haagendazo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.Project;

@Mapper
public interface ProjectMapper {
	
	List<Project> selectAll(@Param("paging") Paging paging);
	int total(@Param("paging") Paging paging);
	List<Project> selectAll(String select, String projectSearch);
	int status(String status);
	void projectInsert(Project project);
	int duplicate(String projectCode);
	List<Project> searchBar(@Param("paging") Paging paging);
	void projectSelectDelete(List<String> idList);
	int searchBarTotal(Paging paging);
	
}
