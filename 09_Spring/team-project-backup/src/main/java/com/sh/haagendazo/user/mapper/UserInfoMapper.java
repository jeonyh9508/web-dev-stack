package com.sh.haagendazo.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.user.model.vo.UserInfo;

@Mapper
public interface UserInfoMapper {
	void register(UserInfo userInfo);
	UserInfo login(String id, String pwd);
}
