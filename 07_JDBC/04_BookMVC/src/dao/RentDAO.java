package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Rent;

public class RentDAO {
	
	public RentDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 7. 책 대여
	public void rentBook(String id, int bookNo) {
		
	}
	
	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id) {
		return null;
	}

	// 9. 대여 취소
	public void deleteRent(int rentNo) {
		
	}
}
