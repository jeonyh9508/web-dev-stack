package com.sh.haagendazo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.User;
import com.sh.haagendazo.service.UserService;


@Controller
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/user")
	public String index(Model model, Paging paging, @RequestParam(defaultValue = "1") int page, User vo, @RequestParam(required = false) String order) {
		 if (paging.getPage() < 1) {
		        paging.setPage(1);
		    }
		    paging.setOffset(paging.getLimit() * (paging.getPage() - 1));

		    if ("asc".equalsIgnoreCase(order)) {
		        paging.setOrderDirection("ASC");
		    } else if ("desc".equalsIgnoreCase(order)) {
		        paging.setOrderDirection("DESC");
		    }
		    
	    List<User> list = service.selectAll(paging);
	    model.addAttribute("list", list);
//	    List<User> search = service.search(vo);
//	    model.addAttribute("list", search);
	    model.addAttribute("paging", new Paging(paging.getPage(), service.total(paging)));
	    
	    int count1 = service.count("ROLE_RESEARCHER");
	    int count2 = service.count("ROLE_MANAGER");
	    model.addAttribute("count1", count1);
	    model.addAttribute("count2", count2);
	    
	    return "/user/user";
	}
	
	@GetMapping("/register")
	public String register(Model model) {
		List<User> grade = service.userGrade();
		List<User> dept = service.userDept();
		
		model.addAttribute("grade", grade);
		model.addAttribute("dept", dept);
		return "/user/register";
	}
	
	@PostMapping("/register")
	public String register(User vo, Model model) {
		service.register(vo);
		return "redirect:/user";
	}
	
	@GetMapping("/checkEmail")
	@ResponseBody
	public String checkEmail(@RequestParam("email") String email) {
	    // service.isEmailDuplicate(email) 메서드는 DB에서 이메일이 존재하는지 확인하고 true/false를 반환한다고 가정
	    if (service.isEmailDuplicate(email)) {
	        return "duplicate";
	    } else {
	        return "available";
	    }
	}
	
//	@PostMapping("/")
//	public String search(User vo, Model model) {
//		List<User> search = service.search(vo);
//		model.addAttribute("list", search);
//		return "user";
//	}
	
	@PostMapping("/user/update")
	public String updateUser(User vo) {
		//HttpSession session = request.getSession();
		//User user = (User) session.getAttribute("user");
		//vo.setUserId(user.getUserId());
		service.updateUser(vo);
		System.out.println(vo);
		return "redirect:/user";
	}
//	@PostMapping("/update")
//	public String update(User vo, HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user");
//		vo.setUserId(user.getUserId());
//		service.update(vo);
//		return "redirect:/";
//	}
	
	
	@PostMapping("/user/delete")
	public String deleteUser(User vo) {
		service.deleteUser(vo);
		System.out.println(vo);
		return "redirect:/user";
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "/user/login";
	}
	
	@GetMapping("/mypage")
	public String mypage() {
		return "/user/mypage";
	}
	
	@GetMapping("/admin")
	public String admin() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = (User) auth.getPrincipal();
		System.out.println(user);
		return "/user/admin";
	}
}
