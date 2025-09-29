package dao;

import java.util.List;

// 추상 메서드
public interface BoardDAO {
	int insert( Object ob );
	List selectList();
	
}
