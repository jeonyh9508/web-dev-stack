package com.sh.haagendazo.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.mapper.ChemicalMapper;
import com.sh.haagendazo.model.Chemical;
import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.Project;
import com.sh.haagendazo.model.Storage;

@Service
public class ChemicalService implements ChemicalMapper {
	
	@Autowired
	private ChemicalMapper mapper;

	@Override
	public List<Chemical> viewChemical(@Param("paging") Paging paging) {
		paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		return mapper.viewChemical(paging);
	}

	@Override
	public int total(@Param("paging") Paging paging) {
		return mapper.total(paging);
	}

	@Override
	public void modifyChemical(Chemical vo) {
		mapper.modifyChemical(vo);
	}

	@Override
	public void addChemical(Chemical vo) {
		mapper.addChemical(vo);
	}

	@Override
	public void deleteChemical(List<Integer> chemList) {
		mapper.deleteChemical(chemList);
	}

	@Override
	public String viewStorageName(int storageId) {
		return mapper.viewStorageName(storageId);
	}

	@Override
	public List<String> viewAllStorageName() {
		return mapper.viewAllStorageName();
	}

	@Override
	public int selectStorageId(String storageName) {
		return mapper.selectStorageId(storageName);
	}

	@Override
	public List<Storage> viewStorage() {
		return mapper.viewStorage();
	}

	@Override
	public List<Chemical> viewStockChem(int chemicalId) {
		return mapper.viewStockChem(chemicalId);
	}

	@Override
	public List<Project> projectListOfUser(int userId) {
		return mapper.projectListOfUser(userId);
	}

	@Override
	public List<Project> chemicalListOfProject(int projectId) {
		return mapper.chemicalListOfProject(projectId);
	}

	@Override
	public Chemical stockOfchemical(int chemicalId) {
		return mapper.stockOfchemical(chemicalId);
	}

}
