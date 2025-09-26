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


@WebServlet("/cart_list.do")
public class CartListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// cart_list.do?m_idx=(?)
		
		int m_idx = Integer.parseInt(request.getParameter("m_idx"));
		
		List<CartVO> vo = CartDAO.getInstance().select(m_idx);
		int total = CartDAO.getInstance().selectTotalAmount(m_idx);
		
		request.setAttribute("vo", vo);
		request.setAttribute("total", total);
		
		for(int i = 0; i< vo.size(); i++) {
			System.out.println(vo.get(i).getC_cnt());
		}
		
		RequestDispatcher disp = request.getRequestDispatcher("cartList.jsp");
		
		disp.forward(request, response);
	}

}
