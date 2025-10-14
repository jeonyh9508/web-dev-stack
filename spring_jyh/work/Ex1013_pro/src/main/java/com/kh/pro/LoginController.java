package com.kh.pro;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class LoginController {

	MemberDAO member_dao;

	@Autowired
	HttpServletRequest request;
	
	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}
	
	// 경로가 없거나, login로 접근했을 때
	@RequestMapping( value={"/", "login.do"} )
	public String login() {
		
		return "login/login_form";
	}
	
	@RequestMapping("check_login.do")
	@ResponseBody
	public String login(MemberVO vo) {
		
	// @ResponseBody 가 있어야 jsp 로 보내지 않고 콜백 함수로
		MemberVO baseVO = member_dao.selectIdCheck(vo.getId());
		
		String result = "";
		
		// DB에 아이디가 존재하지 않는 경우
		if(baseVO == null) {
			result ="no_id";
			String resultStr = String.format("[{'res':'%s'}]", result);
			
			return resultStr;
		}
		
		PwdBcrypt pbc = new PwdBcrypt();
		boolean isValid = pbc.validPwd(vo.getPwd(), baseVO.getPwd());
		
		if(!isValid) {
			result ="no_pwd";
			String resultStr = String.format("[{'res':'%s'}]", result);
			
			return resultStr;
		}
			
		HttpSession session = request.getSession();
		session.setAttribute("member_idx", baseVO.getIdx());
		
		
		result ="clear";
		String resultStr = String.format("[{'res':'%s'}]", result);
		return resultStr;
	}
	@RequestMapping("logout.do")
	public String logout() {
		HttpSession session = request.getSession();
		session.removeAttribute("member_idx");
		
		return "redirect:login.do";
	}
}
