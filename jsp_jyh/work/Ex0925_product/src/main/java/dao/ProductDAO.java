package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVO;

public class ProductDAO {

	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static ProductDAO single = null;

	public static ProductDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new ProductDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public ProductDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	public List<ProductVO> select (String category) {
		
		SqlSession sql = factory.openSession();
		List<ProductVO> list = sql.selectList("p.product_list", category);
		sql.close();
		
		return list;
	}
	
	public int insert (ProductVO vo) {
		
		SqlSession sql = factory.openSession(true);
		int res = sql.insert("p.product_insert", vo);
		sql.close();
		
		return res;
	}
	
}
