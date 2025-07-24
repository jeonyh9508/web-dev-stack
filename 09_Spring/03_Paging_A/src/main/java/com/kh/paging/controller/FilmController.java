package com.kh.paging.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.paging.dto.PagingDTO;
import com.kh.paging.service.FilmService;
import com.kh.paging.vo.Film;

@Controller // 역할 부여 Controller -> 응답과 요청
public class FilmController {

	@Autowired
	private FilmService service;
	
	// localhost:8080/list -> GET 방식 호출
	
	@GetMapping("/list")
	public String list(Model model, PagingDTO paging) {
		System.out.println(paging);
		List<Film> list = service.showFilm(paging);
		model.addAttribute("list",list);
		model.addAttribute("paging",new PagingDTO(paging.getPage(), service.total()));
		
		return "list";
	}
	// session 과 model의 차이
	// session -> 서버 종료 전까지 
	// model -> request

}
