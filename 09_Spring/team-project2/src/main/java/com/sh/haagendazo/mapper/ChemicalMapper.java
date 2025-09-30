package com.sh.haagendazo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sh.haagendazo.model.dto.Approval;
import com.sh.haagendazo.model.dto.Chemical;
import com.sh.haagendazo.model.dto.Paging;
import com.sh.haagendazo.model.dto.Project;
import com.sh.haagendazo.model.dto.Storage;
import com.sh.haagendazo.model.dto.User;

@Mapper
public interface ChemicalMapper {
	
	List<Chemical> viewChemical(@Param("paging") Paging paging);
	int total(@Param("paging") Paging paging);
	void modifyChemical(Chemical vo);
	void addChemical(Chemical chemical);
	void deleteChemical(List<Integer> chemList);
	String viewStorageName(int storageId);
	List<String> viewAllStorageName();
	int selectStorageId(String storageName);
	
	List<Storage> viewStorage();
	List<Chemical> viewStockChem(int chemicalId);
	
	List<Project> projectListOfUser(User user);
	List<Project> chemicalListOfProject(int projectId);
	Project stockOfchemical(int chemicalId);
	void requestUsageChemical(Approval vo);
	void approvalRequestUsageChemical(Approval vo);
	
	List<Chemical> getChemicalChartData();
}
