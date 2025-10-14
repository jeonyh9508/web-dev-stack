package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import vo.ProductVO;


@WebServlet("/list.do")
public class ProductListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list.do?category=(?)
		String category = request.getParameter("category");
		
		// list.do <= category ==  null
		// list.do?category= <= category.isEmpty()
		if ( category == null || category.isEmpty() ) {
			category = "com001";
		}
		
		List<ProductVO> list = ProductDAO.getInstance().select(category);
		
//		System.out.println(category);
		
		request.setAttribute("list", list);
		
		RequestDispatcher disp = request.getRequestDispatcher("product_list.jsp");
		disp.forward(request, response);
		
	}

}
