package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptList
 */
@WebServlet("/list.do")
public class DeptListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<DeptVO> list = DeptDAO.getInstance().select();
		
		// 바인딩
		request.setAttribute("list", list);
		
		// 포워딩 -> 바인딩된 정보를 disp로 전송
		RequestDispatcher disp = request.getRequestDispatcher("dept_list.jsp");
		disp.forward(request, response);
	}

}
