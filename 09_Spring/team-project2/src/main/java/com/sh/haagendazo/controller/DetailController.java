package com.sh.haagendazo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sh.haagendazo.model.Project;
import com.sh.haagendazo.service.DetailService;
import com.sh.haagendazo.service.ProjectChemicalService;

@Controller
public class DetailController {

	@Autowired
	private DetailService detailService;
	
	@Autowired
	private ProjectChemicalService pcService;
	
	@GetMapping("/project/detail")
	public String detail(Model model, int projectId) {
//		System.out.println("projectDetail : " + projectId);
		Project project = detailService.detail(projectId);
		model.addAttribute("project", project);
		
		List<Project> projectMember = detailService.projectMember(projectId);
		if(projectMember.size() == 0 ) {
			detailService.memberClean(projectId);
		}
		model.addAttribute("projectMember", projectMember);
		
		List<Project> projectUser = detailService.userView();
		model.addAttribute("projectUser", projectUser);
		
		List<Project> projectChemical = pcService.projectChemicalList(projectId);
		model.addAttribute("projectChemical", projectChemical); // projectId에 해당하는 user, chemical, approval 모두 뽑아옴
		
		List<Project> chemicalList = pcService.chemicalList();
		model.addAttribute("chemicalList", chemicalList); // chemical name 리스트 시약추가 모달에 전달
		
		List<Project> projectUserList = detailService.projectUserList(projectId);
		model.addAttribute("projectUserList", projectUserList); // 해당 projectId에 참여한 유저 이름 리스트
		
		List<Project> memberSchedule = detailService.memberSchedule(projectId);
		model.addAttribute("memberSchedule", memberSchedule);
		
		
		return "/project/detail";
	}
	
	@PostMapping("/project/memberInsert")
	public String memberInsert(Project project) {
//		System.out.println(project);
		detailService.pmUpdate(project);
		detailService.memberInsert(project);
		return "redirect:/project/detail?projectId=" + project.getProjectId() + "#member";
	}
	
	@PostMapping("/project/memberDelete")
	public String delelte(@RequestParam(name="idList", required = false) List<String> idList, Project project) {
		// required : false -> null 이어도 에러가 나지 않음 기본값: true
		if(idList != null) {
			detailService.memberDelete(idList);
		}
//		System.out.println(idList);
		return "redirect:/project/detail?projectId=" + project.getProjectId() + "#member";
	}
	
	@GetMapping("/project/delete")
	public String projectDelete(int projectId) {
//		System.out.println("projectDelete : " + projectId);
		detailService.projectDelete(projectId);
		return "redirect:/project/list";
	}
	
	@PostMapping("/project/update")
	public String projectUpdate(Project project) {
		detailService.projectUpdate(project);
		return "redirect:/project/detail?projectId=" + project.getProjectId();
	}
	
	@PostMapping("/project/pcAdd")
	public String pcAdd(Project project) {
		System.out.println(project.getUserUserId());
		if(project.getUserId() != 0 && project.getUsedQty() != 0) {
			pcService.pcAdd(project);
			System.out.println(project.getUserUserId());
		}
		return "redirect:/project/detail?projectId=" + project.getProjectId() + "#chemical";
	}
	
}
