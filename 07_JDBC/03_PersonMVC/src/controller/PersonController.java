package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import model.Person;

public class PersonController {

	// 리턴 타입이나 파라미터 자유
	// 메서드 추가 가능
	

	public void PersonController() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// person 테이블에 데이터 추가 - INSERT 
	public void addPerson(String name, int age, String addr) {
		try {
			PersonController();
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			
			String query = "INSERT INTO person(name, age, addr) VALUES (?, ?, ?);";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, age);
			ps.setString(3, addr);
			ps.executeUpdate();
			
			System.out.println("추가");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public ArrayList<Person> searchAllPerson() {
		ArrayList<Person> list = new ArrayList<>();
		
		try {
			PersonController();
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "SELECT * FROM person;";
			PreparedStatement ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로
	public ArrayList<Person> searchPerson(int id) {
		ArrayList<Person> person = new ArrayList<>();
		try {
			PersonController();
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "SELECT * FROM person WHERE id = ?;";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				person.add(new Person(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return person;
		
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson(int number, String update, int id) {
		switch(number) {
		case 1 : try {
			PersonController();
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "UPDATE person SET name = ? WHERE id = ?;";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, update);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("ID : " +id + "    이름 변경");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		break;
		case 2: try {
			PersonController();
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "UPDATE person SET age = ? WHERE id = ?;";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, update);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("ID : " +id + "    나이 변경");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		break;
		case 3: try {
			PersonController();
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "UPDATE person SET addr = ? WHERE id = ?;";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, update);
			ps.setInt(2, id);
			ps.executeUpdate();
			System.out.println("ID : " +id + "    주소 변경");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		break;
		}
	}
	
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson(int id) {
		try {
			PersonController();
			Connection connect = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			String query = "DELETE FROM person WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("ID : " + id + "    삭제");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
