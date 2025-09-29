package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.DeptDAO;
import vo.DeptVO;

// 5. Controller 생성 dao을 injection 구조로 받을 준비
@Controller
public class DeptController {
	
	DeptDAO dept_dao;
	
	public DeptController(DeptDAO dept_dao) {
		this.dept_dao = dept_dao;
	}
	
	@RequestMapping("list.do")
	public String list(Model model) {
		List<DeptVO> list = dept_dao.selectList();
		model.addAttribute("list", list); // DB에서 가져온 값을 list에 담아서 바인딩
		
		return "dept_list";
	}
	
	@RequestMapping("delete.do")
	public String delete(int deptno) {
		
		dept_dao.delete(deptno);
		
		return "redirect:list.do";
	}
	
	@RequestMapping("modify.do")
	public String modify_form(Model model, int deptno) {
		
		DeptVO vo = dept_dao.select_one(deptno);
		model.addAttribute("vo", vo);
		
		return "modify_form";
	}
	
	@RequestMapping("modify_fin.do")
	public String modify_fin(int ori_deptno, DeptVO vo) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("ori_deptno", ori_deptno);
		map.put("deptno", vo.getDeptno());
		map.put("dname", vo.getDname());
		map.put("loc", vo.getLoc());
		
		dept_dao.update(map);
		
		return "redirect:list.do";
	}
}
