package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import vo.Book;

public class BookController {

	BookDAO dao = BookDAO.getInstance();
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll() {
		try {
			return dao.printBookAll();
		} catch (SQLException e) {
			return null;
		}
	}
	
	// 2. 책 등록
	public boolean registerBook(String title, String author, int accessAge) {
		// 기존 제목, 저자, 제한 나이까지 동일한 책이 있으면 안되게!
		try {
			if(dao.checkBook(title, author, accessAge)) {
				return false;
			} else {
			dao.registerBook(title, author, accessAge);
			return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	// 3. 책 삭제
	public boolean sellBook(String title) {
		
		// 빌려있는 책은 삭제 못하게!
		try {
			int result = dao.sellBook(dao.searchBook(title));
			if(result == 1)	return true;
			return false;
		} catch (SQLException e) {
			return false;
		}
		
	}
	
	
	
	
	
	
	
	
	
}