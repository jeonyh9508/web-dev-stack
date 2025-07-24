package com.kh.paging.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.vo.Film;

@Mapper // 역할 부여 Mapper -> DB 접속 .xml 과 연동 (DAO 역할)
public interface FilmMapper {
	List<Film> showFilm(PagingDTO paging);
	int total();
}
