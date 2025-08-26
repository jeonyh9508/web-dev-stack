package com.sh.haagendazo.bio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.mapper.ChemicalMapper;
import com.sh.haagendazo.bio.mapper.ProjectMemberMapper;
import com.sh.haagendazo.bio.model.dto.PagingDTO;
import com.sh.haagendazo.bio.model.vo.Chemical;


@Service
public class ChemicalService implements ChemicalMapper {

	@Autowired
	private ChemicalMapper mapper;
	private ProjectMemberMapper PMmapper;
	
	@Override
	public List<Chemical> viewChemical(PagingDTO paging) {
		paging.setOffset(paging.getLimit() * (paging.getPage() - 1));
		return mapper.viewChemical(paging);
	}

	@Override
	public void modifyChemical(int chemicalId, int stockQty) {
		mapper.modifyChemical(chemicalId, stockQty);
	}

	@Override
	public void deleteChemical(List<Integer> chemList) {
		mapper.deleteChemical(chemList);
	}

	@Override
	public int total() {
		return mapper.total();
	}
	
	
}
