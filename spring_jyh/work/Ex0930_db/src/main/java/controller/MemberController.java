package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.MemberDAO;
import util.PwdBcrypt;
import vo.MemberVO;

@Controller
public class MemberController {
	
	MemberDAO member_dao;

	public void setMember_dao(MemberDAO member_dao) {
		this.member_dao = member_dao;
	}

	@RequestMapping("/list.do")
	public String list(Model model) {
		List<MemberVO> list = member_dao.selectList();
		
		model.addAttribute("list",list);
		
		return "member/member_list";
	}
	
	@RequestMapping("/member_regi_form.do")
	public String memberForm() {
		return "member/regi_form";
	}
	
	@RequestMapping("/member_insert.do")
	public String memberInsert( MemberVO vo) {
		// member_insert.do?name1=(?)&id=(?)&pwd=(?)
		// @RequestParam("name1") String name -> 파라미터 값과 vo 값을 맞추기 위해 가져와서 주입
		
		// security 클래스
		PwdBcrypt pbc = new PwdBcrypt();
		// pwd 암호화
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		// 암호화한 값으로 입력
		vo.setPwd(encodePwd);
		
		int res = member_dao.memberInsert(vo);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("member_delete.do")
	@ResponseBody
	public String memberDelete(int idx) {
		int result = member_dao.delete(idx);
		
		String res = "fail";
// 값이 한 개 일 경우 json 구조로 보낼 필요 없음.
//		if(result < 1) {
//			res = "fail";
//			String resultStr = String.format("[{'res':'%s'}]", res);
//			return resultStr;
//		}
//		
//		res = "success";
//		String resultStr = String.format("[{'res':'%s'}]", res);
		if( result == 1) {
			res = "yes";
		}
		
		return res;
	}
	
	@RequestMapping("/member_modify_form.do")
	public String modifyForm(Model model ,int idx) {
		MemberVO vo = member_dao.selectOne(idx);
		
		model.addAttribute("vo", vo);
		
		return "member/modify_form";
	}
	
	@RequestMapping("/modify_fin.do")
	public String modifyFin(MemberVO vo) {
		PwdBcrypt pbc = new PwdBcrypt();
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		vo.setPwd(encodePwd);
		
		member_dao.modify(vo);
		return "redirect:list.do";
	}
}
