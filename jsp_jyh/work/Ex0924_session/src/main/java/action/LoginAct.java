package action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import vo.MemberVO;

/**
 * Servlet implementation class LoginAct
 */
@WebServlet("/login.do")
public class LoginAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// login.do?id=(?)&pwd=(?)
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		MemberVO vo = MemberDAO.getInstance().selectOne(id);
		
		String param = "";
		String resultStr = "";
		
		// id 불일치
		if( vo == null ) {
			param = "no_id";
			resultStr = String.format("[{'param' : '%s'}]", param);
			response.getWriter().println(resultStr);
			return;
		} 
		
		// pwd 불일치
		if ( !vo.getPwd().equals(pwd) ) {
			param = "no_pwd";
			resultStr = String.format("[{'param' : '%s'}]", param);
			response.getWriter().println(resultStr);
			return;
		}
		
		// 로그인 성공
		// 세션에 정보를 저장
		HttpSession session = request.getSession();
		
		session.setAttribute("user", vo);
		System.out.println(vo.getName());
		param = "clear";
		resultStr = String.format("[{'param' : '%s'}]", param);
		response.getWriter().println(resultStr);

	
	}

}
