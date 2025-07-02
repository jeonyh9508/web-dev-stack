package jdbc;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import config.ServerInfo;

public class DBConnectionTest4 {

	public static void main(String[] args) {

		try {
			Properties p = new Properties();
			p.load(new FileInputStream("src/config/db.properties"));
			
			// 1. 드라이버 로딩
			Class.forName(p.getProperty("driver"));
			
			// 2. DB 연결
			Connection connect = DriverManager.getConnection(p.getProperty("url"),
									p.getProperty("user"), p.getProperty("password"));
			
			// 3. PreparedStatement - 쿼리 : DELETE (user_no를 선택해서)
			String query = "DELETE FROM user_info WHERE user_no = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setInt(1, 6);
			
			// 4. 쿼리문 실행 - executeUpdate
			System.out.println(ps.executeUpdate() + " 명 삭제");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
