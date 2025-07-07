package controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.BookDAO;
import dao.MemberDAO;
import dao.RentDAO;
import vo.Member;
import vo.Rent;

public class RentController {

	RentDAO dao = RentDAO.getInstance();
	BookDAO bookDao = BookDAO.getInstance();
	MemberDAO memberDao = MemberDAO.getInstance();

	// 7. 책 대여
	public boolean rentBook(String id, String title) {
		
		
		try {
			
			// 내가 대여한 책들
			ArrayList<Rent> list = printRentBook(id);
			
			// 한 사람 당 대여할 수 있는 책은 총 5권 -> 내가 대여한 책이 몇 권인지 알아야 함..
			if(list.size() > 4) {
				return false;
			}
			
			// 빌리려는 책의 pk 
			int bookNo = bookDao.searchBook(title);
			
			// 내 정보
			Member member = memberDao.selectMember(id);
			
			for(Rent r : list) {
				// 중복 책 대여 불가능 -> 해당 책이 기존에 있는지 체크 
				if(r.getBookNo() == bookNo) {
					return false;
				}
				
				// 나이 제한 걸리는 책도 대여 불가능 -> 빌리려는 책 접근제한 나이가 있는지 체크
				if(r.getBook().getAccessAge() > member.getAge()) {
					return false;
				}
			}
			
			// 각 책들마다 가능한 대여가 2권까지만 -> 각 책마다.. 그럼 rent...? 개수 필요..
			int count = dao.selectRent(bookNo);
			if(count == 2) {
				return false;
			}
			dao.rentBook(id, bookNo);
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

	// 8. 내가 대여한 책 조회
	public ArrayList<Rent> printRentBook(String id) {
		try {
			return dao.printRentBook(id);
		} catch (SQLException e) {
			return null;
		}
	}

	// 9. 대여 취소
	public boolean deleteRent(String title, String id) {
		try {
			dao.deleteRent(dao.selectRent(title, id));
			return true;
		} catch (SQLException e) {
			return false;
		}
	}

}