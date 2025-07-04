package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import config.ServerInfo;
import vo.Book;
import vo.Member;
import vo.Rent;

public class RentDAO {

	BookDAO bd = new BookDAO();
	Rent r = new Rent();

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
	public void rentBook(String id, int bookNo) throws SQLException {

		Connection connect = getConnect();

		Date today = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String date = sdf.format(today);
		String query = "INSERT INTO rent(id, book_no, rent_date) VALUES (? ,?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, id);
		ps.setInt(2, bookNo);
		ps.setString(3, date);
		ps.executeUpdate();

	}

	// 8. 내가 대여한 책 조회

	public ArrayList<Rent> printRentBook(String id) {
		String member = new Member().getId();
		Book book = new Book();

		try {
			Connection connect = getConnect();
			String query = "SELECT * FROM rent WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();

			ArrayList<Rent> list = new ArrayList<>();
			
			while (rs.next()) {
				Rent rent = new Rent();
				
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	// 9. 대여 취소
	public void deleteRent(int rentNo) {

	}
}
