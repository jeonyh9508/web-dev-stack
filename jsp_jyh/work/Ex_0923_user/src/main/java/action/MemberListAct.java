package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class MemberListAct
 */
@WebServlet("/list.do")
public class MemberListAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<MemberVO> list = MemberDAO.getInstance().memberList();
		request.setAttribute("list", list);
		System.out.println(list.size());
		RequestDispatcher disp = request.getRequestDispatcher("member_list.jsp");
		disp.forward(request, response);
		
	}

}
