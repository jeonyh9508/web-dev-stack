package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ServerInfo;
import dao.PersonA_DAO;
import vo.PersonA;

// DAO - Controller - View
public class PersonControllerA {

	private PersonA_DAO dao = PersonA_DAO.getInstance();
	
	public String addPerson(String name ,int age, String addr){
		try {
			boolean check = dao.checkName(name, age, addr);
			if (check) {
				return "이미 정보가 있습니다.";
			}
			
			return dao.addPerson(name, age, addr);
			
		} catch (SQLException e) {
			return "회원가입 실패";
		}
	}

	public List<PersonA> searchAllPerson() {
		try {
			return dao.searchAllPerson();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public PersonA searchPerson(int id) {
		try {
			return dao.searchPerson(id);
		} catch (SQLException e) {
			return null;
		}
	}
	
	public String updatePerson(String name, int age, String addr, int id) {
		try {
			return dao.updatePerson(name, age, addr, id);
		} catch (SQLException e) {
			return "수정 실패";
		}
	}
	
	public String removePerson(int id) {
		try {
			if(dao.removePerson(id)) {
			return "성공적으로 "+ id + "님 탈퇴되었습니다"; 
			}
			return "삭제 실패";
		} catch (SQLException e) {
			return "관리자에게 문의하세요";
		}
			
	}
}
