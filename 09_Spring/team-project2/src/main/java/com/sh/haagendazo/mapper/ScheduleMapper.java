package com.sh.haagendazo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.model.dto.Paging;
import com.sh.haagendazo.model.dto.Project;
import com.sh.haagendazo.model.dto.Schedule;

@Mapper
public interface ScheduleMapper {

	void insertSchedule(Schedule schedule);
	void projectScheduleUpdate(Schedule schedule);
	void scheduleDelete(int scheduleId);
	List<Project> projectCal(int userId, String role);
	List<Schedule> scheduleCal(int userId, String role);
	List<Project> todayUser(Paging paging);
	int todayUserTotal(Paging paging);
	void scheduleMessage(Schedule schedule);
}
