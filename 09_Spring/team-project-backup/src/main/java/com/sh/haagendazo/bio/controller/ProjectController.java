package com.sh.haagendazo.bio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sh.haagendazo.bio.model.dto.ProjectDTO;
import com.sh.haagendazo.bio.service.ProjectService;

@Controller
public class ProjectController {


	@Autowired
	private ProjectService projectService;

	@GetMapping("/project")
	public String project(Model model, ProjectDTO dto) {
		List<ProjectDTO> project = projectService.allProject();
		model.addAttribute("project", project);
		model.addAttribute("component", "../component/project.jsp");
		return "/common/layout";
	}
	
	@GetMapping("/delete")
	public String deleteProject(Model model, Integer projectId) {
		System.out.println(projectId);
		projectService.deleteProject(projectId);
		model.addAttribute("component", "../component/project.jsp");
		System.out.println("---------------------");
		System.out.println("delete " + projectId);
		return "redirect:/project";
	}
	
	@PostMapping("/project")
	public String searchProject(Model model, ProjectDTO dto) {
		List<ProjectDTO> search = projectService.searchProject(dto);
		System.out.println(dto.getSearch() + "," + dto.getSelect());
		model.addAttribute("project" , search);
		model.addAttribute("component", "../component/project.jsp");
		return "/common/layout";
	}
	
	@PostMapping("/insert")
	public String insertProject(Model model, ProjectDTO dto) {
		projectService.insertProject(dto);
		model.addAttribute("component", "../component/project.jsp");
		return "redirect:/project";
	}
	
	@PostMapping("/update")
	public String updateProject(Model model, ProjectDTO dto) {
		projectService.updateProject(dto);
		System.out.println(dto);
		model.addAttribute("component", "../component/project.jsp");
		return "redirect:/project";
	}
	
	@GetMapping("/detail")
	public String projectDetails(Model model, Integer projectId) {
		System.out.println(projectId);
		ProjectDTO dto = projectService.projectDetail(projectId);
		System.out.println(dto);
		model.addAttribute("project", dto);
		model.addAttribute("component", "../component/detail.jsp");
		return "/common/layout";
	}
}
