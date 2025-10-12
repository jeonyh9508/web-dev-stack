package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.VisitDAO;
import util.PwdBcrypt;
import vo.VisitVO;

@Controller
public class VisitController {

	@Autowired
	HttpServletRequest request;
	
	// 프로젝트의 정보를 가지는 객체
	@Autowired
	ServletContext app;
	
	@Autowired
	SqlSession sqlSession;
	
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
	public String visitInsert(VisitVO vo, MultipartFile file) {

		String webPath = "/resources/upload";
		// 절대 경로
//		String savePath = "C:\\Users\\user1\\Desktop\\upload";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대 경로 : " + savePath);
		
		String filename = "no_file";
		
		// 업로드를 위한 파일이 존재
		if(!file.isEmpty()) {
			// 업로드된 파일의 실제 파일명
			filename = file.getOriginalFilename();
			
			// 저장할 파일경로
			File saveFile = new File(savePath, filename);
			
			// 경로에 이상이 있을 경우
			if( !saveFile.exists() ) {
				saveFile.mkdirs();
			} else {
				// 동일한 파일명이 존재한다면 현재시간을 붙여서 중복 방지
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			try {
				file.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		vo.setFilename(filename);
		
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
	public String updateFin(VisitVO vo, HttpServletRequest requestm, MultipartFile file) {
		
		VisitVO vofile = visit_dao.visitOne(vo.getIdx());
		
		
		String webPath = "/resources/upload";
		// 절대 경로
//		String savePath = "C:\\Users\\user1\\Desktop\\upload";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대 경로 : " + savePath);
		
		// 업로드된 파일의 정보
		String filename = vofile.getFilename();
		

		if (filename != null && !filename.isEmpty()) {
			File beforeS = new File(savePath, filename);
			beforeS.delete();
		}

		// 업로드를 위한 파일이 존재
		if (!file.isEmpty()) {
			// 업로드된 파일의 실제 파일명
			filename = file.getOriginalFilename();

			// 저장할 파일경로
			File saveSimage = new File(savePath, filename);

			// 경로에 이상이 있을 경우
			if (!saveSimage.exists()) {
				saveSimage.mkdirs();
			} else {
				// 동일한 파일명이 존재한다면 현재시간을 붙여서 중복 방지
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);

				saveSimage = new File(savePath, filename);
			}

			try {
				file.transferTo(saveSimage);
			} catch (IllegalStateException e) {    
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		vo.setFilename(filename);
		
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

		return result;
	}
}
