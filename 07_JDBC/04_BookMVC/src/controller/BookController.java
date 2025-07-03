package controller;

import java.util.ArrayList;

import dao.BookDAO;
import vo.Book;

public class BookController {
	
	BookDAO bd = new BookDAO();
	
	// 1. 전체 책 조회
	public ArrayList<Book> printBookAll(){
		return bd.printBookAll();
	}
	
	// 2. 책 등록
	public boolean registerBook(String title, String author, int accessAge) {
		bd.registerBook(title, author, accessAge);
		return true;
	}
	
	// 3. 책 삭제
	public void sellBook(int bookNo) {
		bd.sellBook(bookNo);
		// 대여된 책은 삭제 불가
		
	}
	
	
}
