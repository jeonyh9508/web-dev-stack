package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import model.Person;
import model.PersonA;

public class PersonControllerA {

	// 리턴 타입이나 파라미터 자유
	// 메서드 추가 가능

	public void PersonController() {
		try {
			// 1. 드라이버 로딩
			Class.forName(ServerInfo.DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 고정 반복
	// 2. 디비 연결 , 자원반납
	public Connection getConnect () throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	// 오버로딩
	public void close(PreparedStatement ps, Connection connect) throws SQLException {
		ps.close();
		connect.close();
	}
	
	public void close(ResultSet rs, PreparedStatement ps, Connection connect) throws SQLException {
		rs.close();
		close(ps, connect);
	}
	
	// 변동적 반복 : DAO(Database Access Object)
	
	
	
	// person 테이블에 데이터 추가 - INSERT 
	public void addPerson(String name ,int age, String addr) throws SQLException {
		PersonController();
		Connection connect = getConnect();
		
		// 3. PreparedStatement 객체 생성 - 쿼리
		String query = "INSERT INTO person(name, age, addr) VALUES (?, ?, ?);";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, name);
		ps.setInt(2, age);
		ps.setString(3, addr);
		// --> 로직 추가 예정
		
		// 4. 쿼리 실행
		ps.executeUpdate();
		
		// 5. 자원 반납
		close(ps, connect);
		
	}

	// person 테이블에 있는 데이터 전체 보여주기 - SELECT
	public ArrayList<PersonA> searchAllPerson() throws SQLException {
		ArrayList<PersonA> list = new ArrayList<>();
		
		Connection connect = getConnect();
		String query = "SELECT * FROM person;";
		PreparedStatement ps = connect.prepareStatement(query);
		
		// 개발 추가 예정
		ResultSet rs = ps.executeQuery();
		
		// 추가 예정
		while(rs.next()) {
			list.add(new PersonA(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("addr")));
		}
		close(rs, ps, connect);
		return list;
	}
	
	// person 테이블에서 데이터 한개만 가져오기 - SELECT -> id로
	public void searchPerson(int id) throws SQLException {
		Connection connect = getConnect();
		
		String query = "SELECT * FROM person WHERE id = ?;";
		PreparedStatement ps = connect.prepareStatement(query);
		
		ps.setInt(1, id);
		// 개발 추가 예정
		
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			System.out.println(rs.getInt("id") + rs.getString("name") +rs.getInt("age")+ rs.getString("addr"));
		}
		// 추가 예정
		
		close(rs, ps, connect);
	}
	
	// person 테이블에 데이터 수정 - UPDATE
	public void updatePerson() throws SQLException {
		Connection connect = getConnect();
		PreparedStatement ps = connect.prepareStatement(null);
		// --> 로직 추가 예정
		
		// 4. 쿼리 실행
		ps.executeUpdate();
				
		// 5. 자원 반납
		close(ps, connect);
	}
	
	// person 테이블에 데이터 삭제 - DELETE
	public void removePerson() throws SQLException {
		Connection connect = getConnect();
		PreparedStatement ps = connect.prepareStatement(null);
		
		// --> 로직 추가 예정
		
		// 4. 쿼리 실행
		ps.executeUpdate();
				
		// 5. 자원 반납
		close(ps, connect);
	}
}
