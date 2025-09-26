package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

@WebServlet("/cart_insert.do")
public class CartInsertAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 상품 번호와 로그인한 회원번호
		int idx = Integer.parseInt(request.getParameter("idx"));
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		CartVO vo = new CartVO();
		
		vo.setIdx(idx);
		vo.setM_idx(m_idx);
		
		CartVO resVo = CartDAO.getInstance().selectOne(vo);
		
		String result = "no";
		
		if( resVo == null) {
			// 상품을 장바구니에 등록
			result = "yes";
			CartDAO.getInstance().insert(vo);
		}
		
		String resStr = String.format("[{'result' : '%s'}]", result);
		
		response.getWriter().println(resStr);
	}

}
