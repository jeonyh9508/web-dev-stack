package dao;

import java.util.ArrayList;
import java.util.List;

public class BoardDaoImpl implements BoardDAO {

	// 추상메서드를 상속 받아 Override
	@Override
	public int insert(Object ob) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List selectList() {
		// DB에서 정보를 가져왔다고 가정
		List<String> list = new ArrayList<String>();
		list.add("사과");
		list.add("수박");
		list.add("참외");
		list.add("복숭아");
		
		return list;
	}

}
