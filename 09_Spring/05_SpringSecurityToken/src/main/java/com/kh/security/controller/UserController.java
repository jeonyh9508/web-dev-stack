package com.kh.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.security.config.TokenProvider;
import com.kh.security.service.UserService;
import com.kh.security.vo.User;


@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TokenProvider tokenProvider;
	
	@PostMapping("/register")
	public String register(User vo) {
		userService.register(vo);
		return "redirect:/login";
	}
	
	@ResponseBody
	@PostMapping("/login")
	public String login(User vo) {
		User user = userService.login(vo);
		if(user != null) {
			// 로그인 성공 -> 서버는 토큰 생성, 클라이언트는 보유
			String token = tokenProvider.create(user);
			return token;
		}
		return null;
	}
	
}
