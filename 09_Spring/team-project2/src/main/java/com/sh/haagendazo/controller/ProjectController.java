package com.sh.haagendazo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.Project;
import com.sh.haagendazo.service.ProjectService;


@Controller
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/project/list")
	public String project(Paging paging, Model model) {
	    int count1 = projectService.status("계획중");
	    int count2 = projectService.status("진행중");
	    int count3 = projectService.status("완료");
	    
	    model.addAttribute("count1",count1);
	    model.addAttribute("count2",count2);
	    model.addAttribute("count3",count3);
	    
		List<Project> list = projectService.selectAll(paging);
//		System.out.println("project : " + list);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(paging.getPage(), projectService.total(paging)));
		return "/project/list";
	}

	@GetMapping("/project/searchBar")
	public String searchBar(Paging paging, Model model) {
		int count1 = projectService.status("계획중");
		int count2 = projectService.status("진행중");
		int count3 = projectService.status("완료");
		
		model.addAttribute("count1", count1);
		model.addAttribute("count2", count2);
		model.addAttribute("count3",count3);
		
		paging.setTotal(projectService.searchBarTotal(paging));
		
		System.out.println(paging);
		
		List<Project> list = projectService.searchBar(paging);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(paging.getPage(), projectService.searchBarTotal(paging)));
		
		return "/project/list";
	}

	@PostMapping("/project/selectDelete")
	public String delelte(@RequestParam(name="idList", required = false) List<String> idList) {
		// required : false -> null 이어도 에러가 나지 않음 기본값: true
		if(idList != null) {
			projectService.projectSelectDelete(idList);
		}
		return "redirect:/project/list";
	}
	
	@GetMapping("/project/insert")
	public String projectInsert() {
		return "/project/insert";
	}
	

	@PostMapping("/project/insert")
	public String projectInsert(Project project) {
		projectService.projectInsert(project);
		return "redirect:/project/detail?projectId=" + project.getProjectId();
	}
	
	@GetMapping("/project/checkCode")
	@ResponseBody
	public String checkProjectCode(String projectCode) {
	    boolean duplicate = projectService.duplicate(projectCode);
	    if(duplicate) {
	    	return "success";
	    } else {
	    	return "fail";
	    }
	    
	}
	
}
