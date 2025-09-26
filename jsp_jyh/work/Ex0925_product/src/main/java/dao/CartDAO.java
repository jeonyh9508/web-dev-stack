package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVO;

public class CartDAO {

	SqlSessionFactory factory;
	
	// single-ton pattern: 
	// 객체1개만생성해서 지속적으로 서비스하자
	static CartDAO single = null;

	public static CartDAO getInstance() {
		//생성되지 않았으면 생성
		if (single == null)
			single = new CartDAO();
		//생성된 객체정보를 반환
		return single;
	}
	
	public CartDAO() {
		factory = MyBatisConnector.getInstance().getFactory();
	}
	
	// 회원 별 장바구니 목록 조회
	public List<CartVO> select( int m_idx ){
		SqlSession sql = factory.openSession();
		List<CartVO> list = sql.selectList("c.cart_list", m_idx);
		sql.close();
		
		return list;
	}
	
	// 장바구니 상품 총액
	public int selectTotalAmount (int m_idx ) {
		SqlSession sql = factory.openSession();
		int total = sql.selectOne("c.cart_total_amount", m_idx);
		sql.close();
		
		return total;
	}

	// 장바구니에 등록된 상품인지 조회
	public CartVO selectOne(CartVO vo) {
		SqlSession sql = factory.openSession();
		CartVO resVo = sql.selectOne("c.cart_one", vo);
		sql.close();
		
		return resVo;
	}
	
	// 장바구니에 등록
	public int insert (CartVO vo) {
		SqlSession sql = factory.openSession(true);
		int res = sql.insert("c.cart_insert", vo);
		sql.close();
		
		return res;
	}
}
