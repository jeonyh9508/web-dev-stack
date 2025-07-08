package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			MemberDAO dao = new MemberDAO();
			
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			
			request.setAttribute("id", id);
			request.setAttribute("pwd", pwd);
			
//			System.out.println("service : " + dao.login(id, pwd));
			
			
			if(dao.login(id, pwd)) {
				request.getRequestDispatcher("index.jsp").forward(request, response);
				
				Member member = dao.search(id);
				request.setAttribute("member", member);
				HttpSession session = request.getSession();
				session.setAttribute("member", member);
				response.sendRedirect("LogoutServlet");
			} else {
				response.sendRedirect("/views/fail.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
				
	}

}
