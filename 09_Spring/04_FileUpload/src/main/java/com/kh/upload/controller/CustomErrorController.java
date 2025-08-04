package com.kh.upload.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class CustomErrorController implements ErrorController{


	@RequestMapping("/error") // 어떤 메소드로 터질지 모르기 때문에 포괄성 높은 RequestMapping
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
//		System.out.println(status); 오류 코드 (ex. 404, 500 ...자료형 Object)
		if(status != null) {
			int statusCode = Integer.parseInt(status.toString());// Object에서 int로 형변환
			if(statusCode == 404) {
				return "error/404";
			}
		}
		return "error";
	}
}
