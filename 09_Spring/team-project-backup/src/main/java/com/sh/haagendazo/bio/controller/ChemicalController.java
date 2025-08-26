package com.sh.haagendazo.bio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.haagendazo.bio.model.dto.PagingDTO;
import com.sh.haagendazo.bio.model.vo.Chemical;
import com.sh.haagendazo.bio.service.ChemicalService;

@Controller
public class ChemicalController {
	
	@Autowired
	private ChemicalService service;
	
	@GetMapping("/chem")
	public String test(Model model, PagingDTO paging) {
		model.addAttribute("component", "../component/chem.jsp");
		List<Chemical> list = service.viewChemical(paging);
		model.addAttribute("chemList", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
		return "/common/layout";
	}
	
	@PostMapping("/deleteChem")
	public String test(@RequestParam(name="chemList", required = false) List<Integer> chemList, Model model, PagingDTO paging) {
		if(chemList != null) service.deleteChemical(chemList);
		
		model.addAttribute("component", "../component/chem.jsp");
		List<Chemical> list = service.viewChemical(paging);
		model.addAttribute("chemList", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
		return "/common/layout";
	}
	
	@GetMapping("/search")
	public String search(Model model, PagingDTO paging) {
		model.addAttribute("component", "../component/chem.jsp");
		List<Chemical> list = service.viewChemical(paging);
		model.addAttribute("chemList", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
		return "/common/layout";
	}

}
