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
public class DeptInsertAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1. jsp 받아온 값
		
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
	
		// 2. vo에 저장
		DeptVO vo = new DeptVO();
		vo.setDeptno(deptno);
		vo.setDname(dname);
		vo.setLoc(loc);

		// 3. dao로 구문 실행
		DeptDAO.getInstance().insert(vo);
		
		// 4. list.do 로 redirect
		response.sendRedirect("list.do");
	}
	

}
