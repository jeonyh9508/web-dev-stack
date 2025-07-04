package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import config.ServerInfo;
import vo.Book;

public class BookDAO {

	private static BookDAO instance = new BookDAO();

	private BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static BookDAO getInstance() {
		return instance;
	}

	public Connection connect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}

	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() throws SQLException {
		Connection connect = connect();
		String query = "SELECT * FROM book";
		
		PreparedStatement ps = connect.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		ArrayList<Book> list = new ArrayList<>();
		
		while (rs.next()) {
			Book book = new Book();
			book.setBookNo(rs.getInt("book_no"));
			book.setTitle(rs.getString("title"));
			book.setAuthor(rs.getString("author"));
			book.setAccessAge(rs.getInt("access_age"));
			list.add(book);
		}
		return list;
	}

	// 2. 책 등록
	public void registerBook(String title, String author, int accessAge) throws SQLException {
		Connection connect = connect();
		String query = "INSERT INTO book(title, author, access_age) VALUES(?, ?, ?)";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setString(1, title);
		ps.setString(2, author);
		ps.setInt(3, accessAge);
		ps.executeUpdate();
	}

	// 3. 책 삭제
	public void sellBook(int bookNo) throws SQLException {
		Connection connect = connect();
		String query = "DELETE FROM book WHERE book_no = ?";
		PreparedStatement ps = connect.prepareStatement(query);
		ps.setInt(1, bookNo);
		ps.executeUpdate();
	}

}