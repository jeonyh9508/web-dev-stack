package com.sh.haagendazo.bio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.haagendazo.bio.model.dto.PagingDTO;
import com.sh.haagendazo.bio.model.dto.BudgetDTO;
import com.sh.haagendazo.bio.service.ProjectBudgetService;

@Controller
public class ProjectBudgetController {

	@Autowired
	private ProjectBudgetService service;
	
//	@GetMapping("/budget")
//	public String budget(Model model) {
//	List<BudgetDTO> list = service.allBudget();
//		model.addAttribute("list", list);
//		model.addAttribute("component", "../component/budget.jsp");
//		return "/common/layout";
//		}
	
	@PostMapping("/budget")
	public String selectBudget(Model model, BudgetDTO dto) {
	List<BudgetDTO> list = service.selectBudget(dto);
		model.addAttribute("list", list);
		model.addAttribute("component", "../component/budget.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/budget")
	public String showBudget(Model model, PagingDTO paging) {
		List<BudgetDTO> list = service.showBudget(paging);
		for(BudgetDTO dto : list) {
			System.out.println(dto);
		}
		model.addAttribute("list", list);
		model.addAttribute("paging", new PagingDTO(paging.getPage(), service.total()));
		model.addAttribute("component", "../component/budget.jsp");
		return "/common/layout";
	}
	
	@PostMapping("/deleteBudget")
	public String deleteBudget(@RequestParam(name="idList", required=false) List<Integer> idList) {
		System.out.println(idList);
		if(idList!=null) service.deleteBudget(idList);
		return "redirect:/budget";
}

}
