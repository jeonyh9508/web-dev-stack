package com.sh.haagendazo.bio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.bio.model.dto.PagingDTO;
import com.sh.haagendazo.bio.model.vo.Chemical;

@Mapper
public interface ChemicalMapper {
	List<Chemical> viewChemical(PagingDTO paging);
	void modifyChemical(int chemicalId, int stockQty);
	void deleteChemical(List<Integer> chemList);
	int total();
}
