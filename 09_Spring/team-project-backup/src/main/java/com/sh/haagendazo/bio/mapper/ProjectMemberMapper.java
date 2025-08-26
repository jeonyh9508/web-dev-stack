package com.sh.haagendazo.bio.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.bio.model.vo.ProjectTask;
import com.sh.haagendazo.user.model.vo.UserInfo;

@Mapper
public interface ProjectMemberMapper {

	List<ProjectTask> allProjectTask();
	void login(String id, String pwd);
	void register(UserInfo userInfo);
}
