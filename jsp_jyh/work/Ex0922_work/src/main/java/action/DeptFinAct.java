package action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeptDAO;
import vo.DeptVO;

/**
 * Servlet implementation class DeptFinAct
 */
@WebServlet("/dept_modify_fin.do")
public class DeptFinAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int ori_deptno = Integer.parseInt(request.getParameter("ori_deptno"));
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String dname = request.getParameter("dname");
		String loc = request.getParameter("loc");
		
		// vo 에 모자란 값이 있으면 map으로 묶어서
		// 인자를 map 처리
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("ori_deptno", ori_deptno);
		map.put("deptno", deptno);
		map.put("dname", dname);
		map.put("loc", loc);
		
	
		DeptDAO.getInstance().deptUpdate(map);
		
		response.sendRedirect("list.do");
		
	}

}
