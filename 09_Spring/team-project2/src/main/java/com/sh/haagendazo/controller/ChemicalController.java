package com.sh.haagendazo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.haagendazo.model.Chemical;
import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.Project;
import com.sh.haagendazo.model.Storage;
import com.sh.haagendazo.service.ChemicalService;

@Controller
public class ChemicalController {
	
	@Autowired
	private ChemicalService service;
	
	@GetMapping("/chemical/list")
	public String list(Paging paging, Model model) {
		List<Chemical> list = service.viewChemical(paging);
		model.addAttribute("list", list);
		model.addAttribute("StorageNameList", service.viewAllStorageName());
		model.addAttribute("paging", new Paging(paging.getPage(), service.total(paging)));
		return "/chemical/list";
	}
	
	@PostMapping("/chemical/manage")
	public String manage(Chemical vo, String storageName, int storageId, String type) {
		if(type != null && type.equals("modify")) {
			service.modifyChemical(vo);
		} else if(type != null && storageName != null && type.equals("add")) {
			vo.setStorageId(service.selectStorageId(storageName));
			service.addChemical(vo);
		}
		return "redirect:/chemical/list";
	}
	
	@PostMapping("/chemical/delete")
	public String delete(@RequestParam(name="chemList", required = false) List<Integer> chemList) {
		if(chemList != null) service.deleteChemical(chemList);
		return "redirect:/chemical/list";
	}
	
	@GetMapping("/chemical/stock")
	public String storage(Model model) {
		List<Storage> list = service.viewStorage();
		model.addAttribute("list", list);
		return "/chemical/storage";
	}; 
	
	@GetMapping("/chemical/request")
	public String request(Project vo, Model model) {
		List<Project> projectsOfUser = service.projectListOfUser(vo.getUserId());
		model.addAttribute("projectsOfUser", projectsOfUser);
		model.addAttribute("userId", vo.getUserId());
		
		/* 승인 대기 항목 페이지에 정보 보내 줘야 함
			 CREATE TABLE approval (  
			    approval_id INT AUTO_INCREMENT PRIMARY KEY,      -- 승인 요청 ID
			    project_id INT NOT NULL,                         -- 관련 프로젝트 ID
			    requested_by INT NOT NULL,                       -- 요청자 ID (연구원 ID -> user_id)
			    approval_type VARCHAR(50),                       -- 요청 유형 (문서, 예산, 시약 등)
			    approval_content VARCHAR(50),                    -- 요청 내용 (추가, 삭제, 결제 등) -- 08/20 추가
			    target_id INT,                                   -- 대상 항목 ID (문서 ID 등)
			    status VARCHAR(20) DEFAULT '대기',                -- 상태 (대기, 승인, 반려)
			    comment TEXT,                                    -- 관리자 코멘트
			    approved_by INT,                                 -- 승인자 ID (관리자 ID -> user_id)
			    approved_at DATETIME                             -- 승인 일시
			);
		 * */
		return "/chemical/request";
	}
	
	@ResponseBody
	@GetMapping("/getChemicals")
	public List<Project> getChemicals(int projectId) {
		return service.chemicalListOfProject(projectId);
	}
	
	@ResponseBody
	@GetMapping("/getStockOfChemical")
	public Chemical getStockOfChemical(int chemicalId) {
		return service.stockOfchemical(chemicalId);
	}

}
