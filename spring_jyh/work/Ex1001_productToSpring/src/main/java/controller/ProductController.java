package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dao.CartDAO;
import dao.ProductDAO;
import vo.CartVO;
import vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	ServletContext app;

	@Autowired
	HttpServletRequest request;

	ProductDAO product_dao;
	CartDAO cart_dao;

	public ProductController(ProductDAO product_dao) {
		this.product_dao = product_dao;
	}

	public void setCartDAO(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}

	@RequestMapping(value = { "/", "/list.do" })
	public String productList(String category, Model model) {
		if (category == null) {
			category = "com001";
		}
		List<ProductVO> list = product_dao.select(category);
		model.addAttribute("list", list);
		return "product_list";
	}

	@RequestMapping("/modify_form.do")
	public String modifyForm(int idx, Model model) {
		ProductVO vo = product_dao.selectOne(idx);
		model.addAttribute("vo", vo);
		return "product_modify_form";
	}

	@RequestMapping("/modify_fin.do")
	public String modifyFin(int idx, MultipartFile sPhoto, MultipartFile lPhoto) {
		
		ProductVO vo = product_dao.selectOne(idx);
		
		String webPath = "/resources/images/";
		// 절대 경로
//		String savePath = "C:\\Users\\user1\\Desktop\\upload";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대 경로 : " + savePath);

		// 업로드된 파일의 정보
		String p_image_s = vo.getP_image_s();
		String p_image_l = vo.getP_image_l();


		if (p_image_s != null && !p_image_s.isEmpty()) {
			File beforeS = new File(savePath, p_image_s);
			beforeS.delete();
		}
		if (p_image_l != null && !p_image_l.isEmpty()) {
			File beforeL = new File(savePath, p_image_l);
			beforeL.delete();
		}

		// 업로드를 위한 파일이 존재
		if (!sPhoto.isEmpty() && !lPhoto.isEmpty()) {
			// 업로드된 파일의 실제 파일명
			p_image_s = sPhoto.getOriginalFilename();
			p_image_l = lPhoto.getOriginalFilename();

			// 저장할 파일경로
			File saveSimage = new File(savePath, p_image_s);
			File saveLimage = new File(savePath, p_image_l);

			// 경로에 이상이 있을 경우
			if (!saveSimage.exists() || !saveLimage.exists()) {
				saveSimage.mkdirs();
			} else {
				// 동일한 파일명이 존재한다면 현재시간을 붙여서 중복 방지
				long time = System.currentTimeMillis();
				p_image_s = String.format("%d_%s", time, p_image_s);
				p_image_l = String.format("%d_%s", time, p_image_l);

				saveSimage = new File(savePath, p_image_s);
				saveLimage = new File(savePath, p_image_l);
			}

			try {
				sPhoto.transferTo(saveSimage);
				lPhoto.transferTo(saveLimage);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		vo.setP_image_s(p_image_s);
		vo.setP_image_l(p_image_l);
		System.out.println(vo.getP_image_l());
		System.out.println(vo.getP_image_s());

		product_dao.update(vo);

		return "redirect:/list.do?category=" + vo.getCategory();
	}

	@RequestMapping("/view.do")
	public String view(Model model, int idx) {
		ProductVO vo = product_dao.selectOne(idx);
		model.addAttribute("vo", vo);
		return "product_detail";
	}

	@RequestMapping("/product_regi_form.do")
	public String rigiForm() {
		return "product_regi_form";
	}

	@RequestMapping("/insert.do")
	public String insert(ProductVO vo, MultipartFile sPhoto, MultipartFile lPhoto) {

		String webPath = "/resources/images/";
		// 절대 경로
//		String savePath = "C:\\Users\\user1\\Desktop\\upload";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대 경로 : " + savePath);

		// 업로드된 파일의 정보

		String p_image_s = "no_file";
		String p_image_l = "no_file";

		// 업로드를 위한 파일이 존재
		if (!sPhoto.isEmpty() && !lPhoto.isEmpty()) {
			// 업로드된 파일의 실제 파일명
			p_image_s = sPhoto.getOriginalFilename();
			p_image_l = lPhoto.getOriginalFilename();

			// 저장할 파일경로
			File saveSimage = new File(savePath, p_image_s);
			File saveLimage = new File(savePath, p_image_l);

			// 경로에 이상이 있을 경우
			if (!saveSimage.exists() || !saveLimage.exists()) {
				saveSimage.mkdirs();
			} else {
				// 동일한 파일명이 존재한다면 현재시간을 붙여서 중복 방지
				long time = System.currentTimeMillis();
				p_image_s = String.format("%d_%s", time, p_image_s);
				p_image_l = String.format("%d_%s", time, p_image_l);

				saveSimage = new File(savePath, p_image_s);
				saveLimage = new File(savePath, p_image_l);
			}

			try {
				sPhoto.transferTo(saveSimage);
				lPhoto.transferTo(saveLimage);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		vo.setP_image_s(p_image_s);
		vo.setP_image_l(p_image_l);
		System.out.println(vo.getP_image_l());
		System.out.println(vo.getP_image_s());

		product_dao.insert(vo);
		return "redirect:/list.do?category=" + vo.getCategory();
	}

	@RequestMapping("/cart_list.do")
	public String cartList(int m_idx, Model model) {
		List<CartVO> list = cart_dao.select(m_idx);
		model.addAttribute("vo", list);
		int total = cart_dao.selectTotalAmount(m_idx);
		model.addAttribute("total",total);
		return "cartList";
	}

	@RequestMapping("/delete_cart.do")
	public String cartDel(int c_idx) {
		int m_idx = 1;
		cart_dao.cartDelete(c_idx);

		return "redirect:/cart_list.do?m_idx=" + m_idx;
	}

	@RequestMapping("/cart_insert.do")
	@ResponseBody
	public String cartInsert(String idx, String m_idx) {

		int p_idx = Integer.parseInt(idx);
		int cm_idx = Integer.parseInt(m_idx);

		CartVO vo = new CartVO();
		vo.setIdx(p_idx);
		vo.setM_idx(cm_idx);
		CartVO resVo = cart_dao.selectOne(vo);

		String result = "no";

		if (resVo == null) {
			// 상품을 장바구니에 등록
			result = "yes";
			cart_dao.insert(vo);
		}

		String resStr = String.format("[{'result' : '%s'}]", result);

		return resStr;
	}

	@RequestMapping("/cart_update.do")
	public String cntModify(CartVO vo) {
		int m_idx = 1;
		vo.setM_idx(m_idx);
		cart_dao.cartUpdate(vo);
		return "redirect:/cart_list.do?m_idx=" + m_idx;
	}
}
