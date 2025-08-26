package com.sh.haagendazo.bio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.sh.haagendazo.bio.model.vo.ProjectTask;
import com.sh.haagendazo.bio.service.ProjectTaskService;

@Controller
public class ProjectTaskController {

	@Autowired
	private ProjectTaskService service;
	
	@GetMapping("/task")
	public String task(Model model) {
	List<ProjectTask> projectTask = service.allProjectTask();
		model.addAttribute("projectTask", projectTask);
		System.out.println(service.allProjectTask());
		model.addAttribute("component", "../component/projectTask.jsp");
		return "/common/layout";
		}
}
