package com.sh.haagendazo.common.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sh.haagendazo.bio.model.vo.Chemical;
import com.sh.haagendazo.bio.model.vo.Project;
import com.sh.haagendazo.bio.service.ChemicalService;


@Controller
public class PageController {
	
	@Autowired
	private ChemicalService service;
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("component", "../component/main.jsp");
		model.addAttribute("summary1", "../summary/chart.jsp");
		model.addAttribute("summary2", "../summary/chart2.jsp");
		model.addAttribute("summary3", "../summary/chart3.jsp");
		model.addAttribute("summary4", "../summary/chart4.jsp");
		return "/common/layout";
	}
	
	@PostMapping("/")
	public String index(Model model) {
		model.addAttribute("component", "../component/main.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/mypage")
	public String myPage(Model model) {
		model.addAttribute("component", "../component/mypage.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/calendar")
	public String calendar(Model model) {
		model.addAttribute("component", "../component/calendar.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/schedule")
	public String schedule(Model model) {
		model.addAttribute("component", "../component/schedule.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/customer")
	public String customer(Model model) {
		model.addAttribute("component", "../component/customer.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "/page/login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "/page/register";
	}
	

	
}
