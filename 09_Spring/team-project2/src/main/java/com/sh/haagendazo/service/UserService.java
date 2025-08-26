package com.sh.haagendazo.service;

import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.sh.haagendazo.mapper.UserMapper;
import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.User;


@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserMapper mapper;
	
	private BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
	
	public void register(User vo) {
		System.out.println("암호화 전 : " + vo.getPassword());
		System.out.println("암호화 후 : " + bcpe.encode(vo.getPassword()));
		String pwd = vo.getPassword();
		vo.setPwd(pwd);
		vo.setPassword(bcpe.encode(vo.getPassword()));
//		System.out.println("원래 비밀번호 : " + pwd);
//		int defaultGradeId = 1; // 신규 가입자 기본 등급
//		vo.setGradeId(defaultGradeId);
		
		 if (vo.getGradeId() <= 2) {
	            vo.setRole("ROLE_RESEARCHER");
	        } else if (vo.getGradeId() == 9||vo.getEmail().equals("admin")) {
	        	vo.setRole("ROLE_ADMIN");
	        } else {
	        	vo.setRole("ROLE_MANAGER");
	        }
        mapper.register(vo);
	}
    

	public User login(String email) {
		return mapper.login(email);
	}
	
	public List<User> selectAll(Paging paging) {
		paging.setOffset(paging.getLimit() * (paging.getPage()-1));
		List<User> list = mapper.selectAll(paging);
		return list;
	}
	
	public int total(Paging paging) {
		return mapper.total(paging);
	}
	
	public int count(String role) {
		return mapper.count(role);
	}
	
//	public List<User> search(User vo) {
//		return mapper.search(vo);
//	}
	
	public void updateUser(User vo) {
		vo.setPassword(bcpe.encode(vo.getPassword()));
		mapper.updateUser(vo);
	}
	
	public void deleteUser(User vo) {
		mapper.deleteUser(vo);
	}


	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = mapper.login(email);
		System.out.println(user);
		return user;
	}

	public List<User> userGrade() {
		return mapper.userGrade();
	}
	
	public List<User> userDept() {
		return mapper.userDept();
	}


	public boolean isEmailDuplicate(String email) {
		return false;
	}

	public List<User> showCsdept() {
		return mapper.showCsdept();
	}
	
	public List<User> showManager() {
		return mapper.showManager();
	}
}
