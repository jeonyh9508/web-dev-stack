package com.sh.haagendazo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.model.dto.Approval;
import com.sh.haagendazo.model.dto.Project;

@Mapper
public interface ProjectChemicalMapper {

	List<Project> projectChemicalList (int projectId);
	List<Project> chemicalList ();
	void additionNotApprovedChemical(Approval vo);
	void pcAdd(Approval vo);
}
