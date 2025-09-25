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
 * Servlet implementation class ModifyFin
 */
@WebServlet("/modify_fin.do")
public class ModifyFin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String web_path = "/images/";
		ServletContext app = request.getServletContext();
		String path = app.getRealPath(web_path);
		System.out.println("절대 경로 : " + path);
		int max_size = 1024 * 1024 * 100;

		MultipartRequest mr = new MultipartRequest(request, path, max_size, "utf-8", new DefaultFileRenamePolicy());

		File f = mr.getFile("p_image_s");
		
		int idx = Integer.parseInt(mr.getParameter("idx"));
		ProductVO orivo = ProductDAO.getInstance().selectOne(idx);
		
		String p_image_s = orivo.getP_image_s();
		String p_image_l = orivo.getP_image_l();
		File orifs = new File(path + p_image_s);
		File orifl = new File(path + p_image_l);
		
		if (f != null) {
			orifs.delete();
			p_image_s = f.getName(); // 업로드된 파일의 실제 파일 명
		}

		f = mr.getFile("p_image_l");

		if (f != null) {
			orifl.delete();
			p_image_l = f.getName();
		}

		
		int p_price = Integer.parseInt(mr.getParameter("p_price"));
		int p_saleprice = Integer.parseInt(mr.getParameter("p_saleprice"));
		String p_content = mr.getParameter("p_content");
		
		ProductVO vo = new ProductVO();
		
		vo.setIdx(idx);
		vo.setP_image_s(p_image_s);
		vo.setP_image_l(p_image_l);
		vo.setP_price(p_price);
		vo.setP_saleprice(p_saleprice);
		vo.setP_content(p_content);
		
		ProductDAO.getInstance().update(vo);

		response.sendRedirect("list.do");
	}
}
