package dao;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.CartVO;

public class CartDAO {

	SqlSession sqlSession;
	
	public CartDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 회원 별 장바구니 목록 조회
	public List<CartVO> select( int m_idx ){
		List<CartVO> list = sqlSession.selectList("c.cart_list", m_idx);
		
		return list;
	}
	
	// 장바구니 상품 총액
	public int selectTotalAmount (int m_idx ) {
		int total = sqlSession.selectOne("c.cart_total_amount", m_idx);
		
		return total;
	}

	// 장바구니에 등록된 상품인지 조회
	public CartVO selectOne(CartVO vo) {
		CartVO resVo = sqlSession.selectOne("c.cart_one", vo);
		
		return resVo;
	}
	
	// 장바구니에 등록
	public int insert (CartVO vo) {
		int res = sqlSession.insert("c.cart_insert", vo);
		
		return res;
	}
	
	// 장바구니 수량 업데이트
	public int cartUpdate (CartVO vo) {
		int res =sqlSession.update("c.cart_update",vo);
		
		return res;
	}
	
	// 장바구니 삭제	
	public int cartDelete (int c_idx) {
		int res = sqlSession.delete("c.cart_delete", c_idx);
		
		return res;
	}
}
