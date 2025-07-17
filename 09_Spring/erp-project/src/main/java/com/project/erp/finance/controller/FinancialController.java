package com.project.erp.finance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/finance")
@Controller
public class FinancialController {
	@GetMapping("/salary")
	public String salary(Model model) {
		model.addAttribute("component","../component/finance/salary.jsp");
		return "/common/layout";
	}
}
