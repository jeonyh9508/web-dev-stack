package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVO;

public class ProductDAO {

	SqlSession sqlSession;
	
	public ProductDAO(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	// 전체 상품 목록
		public List<ProductVO> select (String category) {
			
			List<ProductVO> list = sqlSession.selectList("p.product_list", category);
			
			return list;
		}
		
		// 상품 추가
		public int insert (ProductVO vo) {
			
			int res = sqlSession.insert("p.product_insert", vo);
			
			return res;
		}
		
		// 상세보기 / 수정을 위한 상품 조회
		public ProductVO selectOne (int idx) {
			ProductVO vo = sqlSession.selectOne("p.product_one", idx);
			
			return vo;
		}
		
		// 상품 수정
		public int update (ProductVO vo) {
			int res = sqlSession.update("p.product_update", vo);
			
			return res;
		}
}
