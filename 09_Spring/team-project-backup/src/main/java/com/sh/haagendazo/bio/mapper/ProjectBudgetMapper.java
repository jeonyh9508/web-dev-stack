package com.sh.haagendazo.bio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.bio.model.dto.PagingDTO;
import com.sh.haagendazo.bio.model.dto.BudgetDTO;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ProjectBudgetMapper {
//	List<BudgetDTO> allBudget();
	List<BudgetDTO> allBudget(BudgetDTO dto);
	List<BudgetDTO> selectBudget(BudgetDTO dto);
	List<BudgetDTO> showBudget(PagingDTO paging);
	int total();
	void deleteBudget(@Param("idList") List<Integer> idList);
}
