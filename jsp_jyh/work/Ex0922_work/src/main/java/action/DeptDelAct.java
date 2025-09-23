package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;

/**
 * Servlet implementation class DeptDel
 */
@WebServlet("/dept_delete.do")
public class DeptDelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int deptno =Integer.parseInt(request.getParameter("deptno"));
		DeptDAO.getInstance().del(deptno);
		
		response.sendRedirect("list.do");
	}

}
