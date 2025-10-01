package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.VisitDAO;
import util.PwdBcrypt;
import vo.VisitVO;

@Controller
public class VisitController {

	VisitDAO visit_dao;

	public VisitController(VisitDAO visit_dao) {
		this.visit_dao = visit_dao;
	}

	@RequestMapping(value = { "/", "/list.do" })
	public String index(Model model) {

		List<VisitVO> list = visit_dao.selectList();

		model.addAttribute("list", list);

		return "/visit";
	}

	@RequestMapping("/visit_insert_form.do")
	public String insertForm() {
		return "insert_form";
	}

	@RequestMapping("/visit_insert.do")
	public String visitInsert(VisitVO vo, HttpServletRequest request) {

		PwdBcrypt pbc = new PwdBcrypt();
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		vo.setPwd(encodePwd);

		String ip = request.getRemoteAddr();
		vo.setIp(ip);
		visit_dao.visitInsert(vo);

		return "redirect:/list.do";
	}

	@RequestMapping("/update_pwd_check.do")
	@ResponseBody
	public String updateCheck(int idx, String pwd) {
		VisitVO vo = visit_dao.visitOne(idx);
		
		String result = "no";

		PwdBcrypt pbc = new PwdBcrypt();
		boolean isValid = pbc.validPwd(pwd, vo.getPwd());
		
		if (isValid) {
			result = "yes";
		}

		String resStr = String.format("[{'res' : '%s', 'idx' : '%s'}]", result, idx);

		return resStr;
	}

	@RequestMapping("/visit_update_form.do")
	public String updateForm(int idx, Model model) {
		VisitVO vo = visit_dao.visitOne(idx);
		model.addAttribute("vo", vo);
		return "update_form";
	}

	@RequestMapping("/update_fin.do")
	public String updateFin(VisitVO vo, HttpServletRequest request) {

		
		

		PwdBcrypt pbc = new PwdBcrypt();
		String encodePwd = pbc.encodingPwd(vo.getPwd());
		vo.setPwd(encodePwd);
		
//		String ip = request.getRemoteAddr();
		String ip = "192.168.0.30";
		vo.setIp(ip);
		
		visit_dao.visitUpdate(vo);

		return "redirect:/list.do";
	}

	@RequestMapping("/del_pwd_check.do")
	@ResponseBody
	public String delCheck(int idx, String pwd) {

		VisitVO vo = visit_dao.visitOne(idx);
		String result = "no";

		PwdBcrypt pbc = new PwdBcrypt();
		boolean isValid = pbc.validPwd(pwd, vo.getPwd());
		
		if (isValid) {
			result = "yes";
			visit_dao.visitDel(idx);
		}

		String resStr = String.format("[{'res' : '%s'}]", result);

		return resStr;
	}
}
