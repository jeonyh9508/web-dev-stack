package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {

	public MemberDAO(){
		try {
			// 1. 드라이버 로딩 "com.mysql.cj.jdbc.Driver"
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection connect() throws SQLException {
		// 2. 디비 연결
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
//		URL = "jdbc:mysql://localhost:3306/work";
//		USER = "root";
//		PASSWORD = "qwer1234"; 
	}
	
	// 회원가입
	public void register(Member member) throws SQLException{
			Connection connect = connect();
			
			String query = "INSERT INTO member VALUES (?, ?, ?, ?)";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setString(1, member.getId());
			ps.setString(3, member.getName());
			ps.setString(2, member.getPwd());
			ps.setInt(4, member.getAge());
			
			ps.executeUpdate();	
	}
	

}
