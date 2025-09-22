package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptInsert
 */
@WebServlet("/dept_insert.do")
public class DeptInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
	
		
		DeptVO vo = new DeptVO();
		
		vo.setDname(dname);
		vo.setLoc(loc);

		DeptDAO.getInstance().insert(vo);
		
		response.sendRedirect("/dept_list.jsp");
	}
	

}
