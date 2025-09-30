package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class LoginController {

	MemberDAO member_dao;
	
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
			
		result ="clear";
		String resultStr = String.format("[{'res':'%s'}]", result);
		return resultStr;
	}
}
