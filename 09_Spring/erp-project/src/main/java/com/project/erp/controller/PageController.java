package com.project.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("component", "../component/main.jsp");
		return "/component/login";
	}

	@PostMapping("/main")
	public String main(Model model) {
		model.addAttribute("component", "../component/main.jsp");
		return "/common/layout";
	}

	@GetMapping("/example")
	public String example(Model model) {
		model.addAttribute("component", "../component/example.jsp");
		return "/common/layout";
	}
	@PostMapping("/login")
	public String login(Model model) {
		model.addAttribute("component", "../component/example.jsp");
		return "/common/layout";
	}
	@GetMapping("/layout")
	public String layout(Model model) {
		model.addAttribute("component", "../component/example.jsp");
		return "/common/layout";
	}
	
}
