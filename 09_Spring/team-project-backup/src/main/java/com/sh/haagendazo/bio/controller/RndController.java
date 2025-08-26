package com.sh.haagendazo.bio.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sh.haagendazo.bio.model.dto.RndDTO;
import com.sh.haagendazo.bio.service.ProjectDocumentService;
import com.sh.haagendazo.user.service.UserInfoService;

@Controller
public class RndController {

	@Autowired
	private ProjectDocumentService pdService;
//	private UserInfoService uiService;
	
	@GetMapping("/rnd")
	public String rnd(Model model) {
	List<RndDTO> list = pdService.allRnd();
		model.addAttribute("list", list);
		model.addAttribute("component", "../component/rnd.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/searchRnd")
	public String searchRnd(Model model) {
		List<RndDTO> srnd = pdService.searchRnd();
		model.addAttribute("searchRnd", srnd);
		model.addAttribute("component", "../component/rnd.jsp");
		return "/common/layout";
	}
	
//	@PostMapping("/deleteRnd")
//	public String deleteRnd(Model model, String projectId) {
//		uiService.deleteRnd(projectId);
//		model.addAttribute("component", "../component/rnd.jsp");
//		return"/common/layout";
//	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) {
		//System.out.println("파일 이름 : " + file.getOriginalFilename());
		//System.out.println("파일 사이즈 : " + file.getSize());
		//System.out.println("파일 파라미터명 : " + file.getName());
		
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		// System.out.println(uuid.toString());
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		File copyFile = new File("\\\\192.168.0.35\\upload\\" + fileName);
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
