package com.sh.haagendazo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sh.haagendazo.model.Project;
import com.sh.haagendazo.model.Schedule;
import com.sh.haagendazo.service.DetailService;
import com.sh.haagendazo.service.ScheduleService;

@Controller
public class ScheduleController {

	@Autowired
	private ScheduleService scheService;
	
	@Autowired
	private DetailService detailService;
	
	@PostMapping("/project/scheAdd")
	public String scheAdd(Schedule schedule) {
		
		Project project = detailService.detail(schedule.getProjectId());
		System.out.println(schedule);
		scheService.insertSchedule(schedule);
		System.out.println(project);
		
		return "redirect:/project/detail?projectId=" + schedule.getProjectId() + "#schedule";
	}
	
	@PostMapping("/project/proSche")
	public void proSche(Schedule schedule) {
		scheService.projectScheduleUpdate(schedule);
	}
	
	@ResponseBody
	@PostMapping("/schedule/proScheDel")
	public void scheduleDelete(Schedule schedule) {
		int scheduleId = schedule.getScheduleId();
		scheService.scheduleDelete(scheduleId);
	}
	
	  // 1) 캘린더 페이지
    @GetMapping("/schedule")
    public String schedulePage() {
        return "/schedule/schedule"; // /WEB-INF/views/schedule/schedule.jsp
    }

    // 2) 캘린더 이벤트 JSON
    @GetMapping("/schedule/event")
    @ResponseBody
    public List<Map<String, Object>> getCalendarEvents() {
        List<Map<String, Object>> events = new ArrayList<>();

        // 프로젝트 이벤트
        List<Project> projects = scheService.projectCal();
        for(Project p : projects) {
            Map<String, Object> event = new HashMap<>();
            event.put("title", p.getProjectName());
            event.put("start", p.getStartDate());
            event.put("end", p.getEndDate());
            event.put("color", "#1E90FF");
            event.put("type", "project");
            event.put("projectId", p.getProjectId()); // ← 여기 추가
            events.add(event);
        }

        // 스케줄 이벤트
        List<Schedule> schedules = scheService.scheduleCal();
        for(Schedule s : schedules) {
            Map<String, Object> event = new HashMap<>();
            event.put("title", s.getTitle());
            event.put("start", s.getStartDatetime());
            event.put("end", s.getEndDatetime());
            event.put("color", "#FF4500");
            event.put("type", "schedule");
            event.put("projectId", s.getProjectId());
            events.add(event);
        }

        return events;
    }
}
