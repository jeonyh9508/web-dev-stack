package com.project.erp.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinancialPageController {
	
	
	@GetMapping("/salary")
	public String salary(Model model) {
		model.addAttribute("component","../component/finance/salary.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/sale")
	public String sale(Model model) {
		model.addAttribute("component","../component/finance/sale.jsp");
		return "/common/layout";
	}
}
