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

@WebServlet("/delete_cart.do")
public class CartDeleteAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		// 회원번호 가정
		int m_idx = 1;
		
		CartDAO.getInstance().cartDelete(c_idx);
		
		List<CartVO> list = CartDAO.getInstance().select(m_idx);
		int total_amount = CartDAO.getInstance().selectTotalAmount(m_idx);
		
		request.setAttribute("vo", list);
		request.setAttribute("total", total_amount);
		
		RequestDispatcher disp = request.getRequestDispatcher("cartList.jsp");
		
		disp.forward(request, response);
		
	}
	

}
