package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
	
		PrintWriter out = response.getWriter();
		String id = request.getParameter("userId");
		
		String pwd = request.getParameter("userPwd");
		
		String gender = request.getParameter("gender");
		gender = gender.equals("M") ? "남자" : "여자";
		/*
		if(gender.equals("M")) {
			gender = "남자";
			out.println("<h1> 성별 : " + gender + "</h1>");
		} else if (gender.equals("W")) {
			gender = "여자";
			out.println("<h1> 성별 : " + gender + "</h1>");
		}*/
		
	
		String[] menu = request.getParameterValues("menu");
		
		out.println("<html><body>");
		out.println("<h2> 아이디 : " + id + "</h2>");
		out.println("<h2> 비밀번호 : " + pwd + "</h2>");
		out.println("<h2> 성별 : " + gender + "</h2>");
		
		if(menu!=null) {
			out.println("<h2> 좋아하는 메뉴 </h2>");
			out.println("<ul>");
			for(String m : menu) {
				out.println("<li>" + m + "</li>");
			}
		out.println("</ul>");
		}
//		out.println("<h2> 좋아하는 메뉴 : " + String.join(", ", menu) + "</h2>");
		out.println("</body></html>");
		out.close();
	}
	
}
