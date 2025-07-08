package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vo.Member;

import java.io.IOException;
import java.sql.SQLException;

import dao.MemberDAO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberDAO dao = new MemberDAO();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			
			Member member = new Member(id, name, pwd, age);
			dao.register(member);
			response.sendRedirect("index.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
