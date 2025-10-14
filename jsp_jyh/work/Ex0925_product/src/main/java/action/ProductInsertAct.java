package action;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDAO;
import vo.ProductVO;

/**
 * Servlet implementation class ProductInsertAct
 */
@WebServlet("/insert.do")
public class ProductInsertAct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 저장 위치 
		// 상대 경로
		String web_path = "/images/";
		// 서블릿 관리자
		ServletContext app = request.getServletContext();
		// 절대 경로
		String path = app.getRealPath(web_path);
		System.out.println("절대 경로 : " + path);
		// 최대 업로드 용량
		int max_size = 1024 * 1024 * 100;
		
		// 요청, 저장위치, 최대 사이즈, 인코딩, 동일 이름 방지 정책
		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());		
		
		// 업로드된 파일정보 받아오기
		String p_image_s = "no_file";
		String p_image_l = "no_file";
				
		File f = mr.getFile("p_image_s");
		
		if( f != null ) {
			p_image_s = f.getName(); // 업로드된 파일의 실제 파일 명
		}
		
		f = mr.getFile("p_image_l");
		
		if( f != null ) {
			p_image_l = f.getName();
		}
		
		// 파일 이외의 나머지 파라미터 수신
		// MultipartRequest 객체로
		
		String category = mr.getParameter("category");
		String p_num = mr.getParameter("p_num");
		String p_name = mr.getParameter("p_name");
		String p_company = mr.getParameter("p_company");
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
		String p_content = mr.getParameter("p_content");
		
		ProductVO vo = new ProductVO();
		vo.setCategory(category);
		vo.setP_num(p_num);
		vo.setP_name(p_name);
		vo.setP_company(p_company);
		vo.setP_price(p_price);
		vo.setP_saleprice(p_saleprice);
		vo.setP_content(p_content);
		vo.setP_image_s(p_image_s);
		vo.setP_image_l(p_image_l);
		
		ProductDAO.getInstance().insert(vo);
		
		response.sendRedirect("list.do?category=" + category);
	}

}
