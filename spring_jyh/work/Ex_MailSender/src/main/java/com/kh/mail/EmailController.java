package com.kh.mail;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.MailSendService;

@Controller
public class EmailController {

	MailSendService mss;
	
	// 생성자 인젝션
	public EmailController(MailSendService mss) {
		this.mss = mss;
	}
	
	@RequestMapping(value={"/", "/start.do"})
	public String start() {
		return "email_sender";
	}
	
	@RequestMapping("/mailCheck.do")
	@ResponseBody
	public String mailCheck(String email) {
		// MailSendService 에서 받아 온 인증번호를 ajax로 처리해서 jsp 에서 대조
		String res = mss.joinEmail(email);
		
		return res;
	}
}
