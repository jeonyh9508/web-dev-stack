package com.sh.haagendazo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sh.haagendazo.model.Board;
import com.sh.haagendazo.model.User;
import com.sh.haagendazo.service.BoardService;
import com.sh.haagendazo.service.ProjectService;

@Controller
public class PageController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/")
	public String getProjectDashboard(Model model) {
		int countPlan = projectService.status("계획중");
		int countIng = projectService.status("진행중");
		int countDone = projectService.status("완료");
		
		List<Board> list = boardService.showNotice();
		model.addAttribute("list", list);
		
		model.addAttribute("countPlan",countPlan);
		model.addAttribute("countIng",countIng);
		model.addAttribute("countDone",countDone);

	    return "/index";
	}
	
//	@PostMapping("/login")
//	public String login(String id, HttpServletRequest request) {
//		User user = service.login(id);
//		HttpSession session = request.getSession();
//		session.setAttribute("user", user);
//		return "redirect:/user";
//	}
	
//	@GetMapping("/logout")
//	public String logout(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return "redirect:/user";
//	}

	/*
	 * 임시로 페이지 컨트롤러 내 a태그에 해당하는 getMapping 값 등록해둘 예정 
	 * */
	
	
	@GetMapping("/today")
	public String today() {
		return "/schedule/today";
	}
	
}
