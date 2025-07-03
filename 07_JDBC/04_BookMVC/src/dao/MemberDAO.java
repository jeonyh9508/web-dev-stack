package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;
import vo.Member;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	// 4. 회원가입 
	public void register(Member member) throws SQLException {
	
			Connection connect = getConnect();
			String query = "INSERT INTO member VALUES (?, ?, ?, ?);";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, member.getId());
			ps.setString(2, member.getName());
			ps.setString(3, member.getPwd());
			ps.setInt(4, member.getAge());
			ps.executeUpdate();
			
			System.out.println("회원가입완료");
		
	}
	
	// 5. 로그인
	public Member login (String id , String pwd) {
		try {
			
			Connection connect = getConnect();
			String query = "SELECT * FROM member WHERE id = ? AND pwd = ?;";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, id);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			
		
			if (rs.next()) {
				Member member = new Member(rs.getString("id"),rs.getString("name"),rs.getString("pwd"),rs.getInt("age"));
				System.out.println("로그인 성공");
				return member;
			} else {
				System.out.println("아이디 / 비밀번호가 틀렸습니다.");
				return null;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	// 6. 회원탈퇴
	public void delete(String id) {
		try {
			Connection connect = getConnect();
			String query = "DELET FROM member WHERE id = ?;";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
}
