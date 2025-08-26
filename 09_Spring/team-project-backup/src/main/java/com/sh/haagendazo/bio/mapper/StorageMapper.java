package com.sh.haagendazo.bio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.bio.model.dto.RndDTO;

@Mapper
public interface StorageMapper {
	List<RndDTO> allRnd();
	void deleteRnd(String projectId);
}
