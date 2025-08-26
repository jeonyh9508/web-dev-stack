package com.sh.haagendazo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.User;

@Mapper
public interface UserMapper {
	void register(User vo);
	User login(String email);
	List<User> selectAll(Paging paging);
	List<User> search(User vo, Paging paging);
	void updateUser(User vo);
	void deleteUser(User vo);
	int total(Paging paging);
	int count(String role);
	List<User> userGrade();
	List<User> userDept();
	List<User> showCsdept();
	List<User> showManager();
}
