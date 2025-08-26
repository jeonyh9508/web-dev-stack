package com.sh.haagendazo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.mapper.ScheduleMapper;
import com.sh.haagendazo.model.Project;
import com.sh.haagendazo.model.Schedule;

@Service
public class ScheduleService implements ScheduleMapper{

	@Autowired
	private ScheduleMapper scheMapper;
	
	@Override
	public void insertSchedule(Schedule schedule) {
		scheMapper.insertSchedule(schedule);
	}
	
	@Override
	public void projectScheduleUpdate(Schedule schedule) {
		scheMapper.projectScheduleUpdate(schedule);
	}

	@Override
	public List<Schedule> scheduleCal() {
		return scheMapper.scheduleCal();
	}

	@Override
	public List<Project> projectCal() {
		return scheMapper.projectCal();
	}

	@Override
	public void scheduleDelete(int scheduleId) {
		scheMapper.scheduleDelete(scheduleId);
		
	}
}
