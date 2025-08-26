package com.sh.haagendazo.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.servlet.http.HttpSession;
import com.sh.haagendazo.user.model.vo.UserInfo;
import com.sh.haagendazo.user.service.UserInfoService;


@Controller
public class UserInfoController {
	
	@Autowired
	private UserInfoService service;
	
	@PostMapping("/login")
	public String login(String id, String pwd, HttpSession session) {
		UserInfo user = service.login(id, pwd);
		if(user!=null) {
			session.setAttribute("UserInfo", user);
			return "redirect:/";
		}
		return "redirect:/login";
	}
	
	@PostMapping("/register")
	public String register(UserInfo userInfo) {
		service.register(userInfo);
		return "/page/login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("UserInfo") !=null) {
			session.invalidate();
			return "/page/login";
		}
		return "/page/login";
	}
	
}
