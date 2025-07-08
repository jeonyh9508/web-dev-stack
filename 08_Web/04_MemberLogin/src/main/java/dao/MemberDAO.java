package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	}
	
	public void register(Member member) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO member VALUES (?, ?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, member.getId());
		ps.setString(2, member.getName());
		ps.setString(3, member.getPwd());
		ps.setInt(4, member.getAge());
		ps.executeUpdate();
		
	}
	
	public boolean login(String id, String pwd) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id = ? AND pwd = ? ";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setString(2, pwd);
		ResultSet rs = ps.executeQuery();
		
		boolean check = false;
		if (rs.next()) {
			check = true;
		} else {
			check = false;
		}
		return check;
	}
	
	public Member search(String id) throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM member WHERE id = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		Member member = new Member();
		
		if(rs.next()) {
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPwd(rs.getString("pwd"));
			member.setAge(rs.getInt("age"));
		}return member;
	}
	
	public List<Member> searchAll() throws SQLException{
		Connection connect = connect();
		String query = "SELECT * FROM member";
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		List<Member> list = new ArrayList<>();
		while(rs.next()) {
			list.add(new Member(rs.getString("id"),rs.getString("name"),rs.getString("pwd"),rs.getInt("age")));
		}return list;
	}
}
