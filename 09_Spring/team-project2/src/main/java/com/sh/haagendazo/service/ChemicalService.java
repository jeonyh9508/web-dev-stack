package com.sh.haagendazo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.mapper.ChemicalMapper;
import com.sh.haagendazo.model.dto.Approval;
import com.sh.haagendazo.model.dto.Chemical;
import com.sh.haagendazo.model.dto.Paging;
import com.sh.haagendazo.model.dto.Project;
import com.sh.haagendazo.model.dto.Storage;
import com.sh.haagendazo.model.dto.User;

@Service
public class ChemicalService {
	
	@Autowired
	private ChemicalMapper mapper;

	public List<Chemical> viewChemical(@Param("paging") Paging paging) {
		paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		return mapper.viewChemical(paging);
	}

	public int total(@Param("paging") Paging paging) {
		return mapper.total(paging);
	}

	public void modifyChemical(Chemical vo) {
		mapper.modifyChemical(vo);
	}

	public void addChemical(Chemical vo) {
		mapper.addChemical(vo);
	}

	public void deleteChemical(List<Integer> chemList) {
		mapper.deleteChemical(chemList);
	}

	public String viewStorageName(int storageId) {
		return mapper.viewStorageName(storageId);
	}

	public List<String> viewAllStorageName() {
		return mapper.viewAllStorageName();
	}

	public int selectStorageId(String storageName) {
		return mapper.selectStorageId(storageName);
	}

	public List<Storage> viewStorage() {
		return mapper.viewStorage();
	}

	public List<Chemical> viewStockChem(int chemicalId) {
		return mapper.viewStockChem(chemicalId);
	}

	public List<Project> projectListOfUser(User user) {
		return mapper.projectListOfUser(user);
	}

	public List<Project> chemicalListOfProject(int projectId) {
		return mapper.chemicalListOfProject(projectId);
	}

	public Project stockOfchemical(int chemicalId) {
		return mapper.stockOfchemical(chemicalId);
	}

	public void requestUsageChemical(Approval vo) {
		mapper.requestUsageChemical(vo);
	}
	
	public List<Chemical> getChemicalChartData() {
		return mapper.getChemicalChartData();
	}

}
