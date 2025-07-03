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
	
	public BookDAO() {
		try {
			Class.forName(ServerInfo.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnect() throws SQLException {
		return DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	}
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll(){
		try {
			Connection connect = getConnect();
			String query = "SELECT * FROM book";
			PreparedStatement ps = connect.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			ArrayList<Book> list = new ArrayList<>();
			
			while(rs.next()) {
				Book book = new Book(rs.getInt("book_no"),rs.getString("title"), rs.getString("author"), rs.getInt("access_age"));
				list.add(book);
			}
			return list;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	// 2. 책 등록
	public void registerBook(String title, String author, int accessAge) {
		try {
			Connection connect = getConnect();
			String query = "INSERT INTO book(title, author, access_age) VALUES (?, ?, ?);";
			PreparedStatement ps = connect.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, author);
			ps.setInt(3, accessAge);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. 책 삭제
	public void sellBook(int bookNo) {
		try {
			Connection connect = getConnect();
			String query = "DELETE FROM book WHERE book_no = ?;";
			PreparedStatement ps = connect.prepareStatement(query);
			
			ps.setInt(1, bookNo);
			
			ps.executeUpdate();
			
			System.out.println("성공적으로 삭제되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
