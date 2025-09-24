package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;

/**
 * Servlet implementation class MemberDelAct
 */
@WebServlet("/member_del.do")
public class MemberDelAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		int res = MemberDAO.getInstance().memberDel(idx);
		
		String param = "no";
		
		if(res > 0 ) {
			param = "yes";
		}
		
		String resultStr = String.format("[{'res' : '%s'}]", param);
		
		response.getWriter().println(resultStr);
		
		
//		response.sendRedirect("list.do");
	}

}
