package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnectionTest2 {

	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/erp";
	public static final String USER = "root";
	public static final String PASSWORD = "qwer1234"; 
	
	public static void main(String[] args) {

		
		try {
			// 1. 드라이버 로딩
			Class.forName(DRIVER);
			
			// 2. 데이터베이스 연결 : 스키마 - erp
			Connection connect = DriverManager.getConnection(URL, USER, PASSWORD);
			
			// 3. PreparedStatement 객체 생성 - INSERT - user_info 테이블에 사람 한명 추가하는 쿼리문 작성
			String query = "INSERT INTO user_info(id, password, name) VALUES (?, ?, ?);";
			PreparedStatement ps = connect.prepareStatement(query);
			
			// ? 개수 -> 자리에 맞춰 set
			ps.setString(1, "user3");
			ps.setString(2, "2222");
			ps.setString(3, "비비빅");
			
			// 4. 쿼리문 실행 - rs.executeUpdate();
			System.out.println(ps.executeUpdate() + " 명 추가 ");
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
	}

}
