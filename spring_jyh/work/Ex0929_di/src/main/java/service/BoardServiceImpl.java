package service;

import java.util.List;

import dao.BoardDAO;

public class BoardServiceImpl implements BoardService{
	
	BoardDAO dao;
	
	// 외부에서 메모리가 할당 된 객체를 가져와서 사용
	public BoardServiceImpl(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public List selectList() {
		
		return dao.selectList();
	}

}
