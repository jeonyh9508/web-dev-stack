package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptModifyAct
 */
@WebServlet("/dept_modify.do")
public class DeptModifyAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//dept_modify.do?deptno=#{?}
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		
		DeptVO vo = DeptDAO.getInstance().modifyDept(deptno);
		
		request.setAttribute("vo", vo);
		
		RequestDispatcher disp = request.getRequestDispatcher("/modify_form.jsp");
		disp.forward(request, response);
		
	
	}

}
