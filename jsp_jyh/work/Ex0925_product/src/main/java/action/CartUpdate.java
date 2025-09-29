package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CartDAO;
import vo.CartVO;

@WebServlet("/cart_update.do")
public class CartUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		int c_cnt = Integer.parseInt(request.getParameter("c_cnt"));
		
		// 회원번호를 가정
		int m_idx = 1; 
		
		CartVO vo = new CartVO();
		vo.setC_idx(c_idx);
		vo.setC_cnt(c_cnt);
		
		// c_idx가 고유값이기 때문에 m_idx는 넘기지 않아도 됨
		vo.setM_idx(m_idx);
		
		CartDAO.getInstance().cartUpdate(vo);
		
		//현재 접속한 회원의 장바구니 목록 조회
		List<CartVO> list = CartDAO.getInstance().select(m_idx);
	
		// 장바구니 총 계
		int total_amount = CartDAO.getInstance().selectTotalAmount(m_idx);
		
		request.setAttribute("vo", list);
		request.setAttribute("total", total_amount);
		
		RequestDispatcher disp = request.getRequestDispatcher("cartList.jsp");
		disp.forward(request, response);
		
	}

}
