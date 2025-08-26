package com.sh.haagendazo.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.bio.model.dto.RndDTO;
import com.sh.haagendazo.user.mapper.UserInfoMapper;
import com.sh.haagendazo.user.model.vo.UserInfo;

@Service
public class UserInfoService implements UserInfoMapper {
	
	@Autowired
	private UserInfoMapper mapper;

	@Override
	public UserInfo login(String id, String pwd) {
		return mapper.login(id, pwd);
	}
	
	public void register(UserInfo userInfo) {
		mapper.register(userInfo);
	}
};

