package com.sh.haagendazo.bio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.model.dto.PagingDTO;
import com.sh.haagendazo.bio.mapper.ProjectBudgetMapper;
import com.sh.haagendazo.bio.model.dto.BudgetDTO;


@Service
public class ProjectBudgetService {

	@Autowired
	private ProjectBudgetMapper mapper;

//	public List<BudgetDTO> allBudget() {
//		return mapper.allBudget();
//	}

	public List<BudgetDTO> selectBudget(BudgetDTO dto) {
		return mapper.allBudget(dto) ;
	}
	
	public List<BudgetDTO> showBudget(PagingDTO paging) {
		/*
		 * 만약에 limit가 10인 경우
		 * page = 1 -> offset=0
		 * page = 2 -> offset=10
		 * page = 3 -> offset=20
		 * 
		 * offset = limit * (page-1)
		 * */
		paging.setOffset(paging.getLimit() * (paging.getPage()-1));
		return mapper.showBudget(paging);
	}
	
	public int total() {
		return mapper.total();
	}
	
	public void deleteBudget(List<Integer> idList) {
		mapper.deleteBudget(idList);
	}
}
