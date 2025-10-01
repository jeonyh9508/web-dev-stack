package controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CartDAO;
import dao.ProductDAO;
import vo.CartVO;
import vo.ProductVO;

@Controller
public class ProductController {

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
		if(category == null) {
			category = "com001";
		}
		List<ProductVO> list = product_dao.select(category);
		model.addAttribute("list", list);
		return "product_list";
	}
	
	@RequestMapping("/modify_form.do")
	public String modifyForm (int idx, Model model) {
		ProductVO vo = product_dao.selectOne(idx);
		model.addAttribute("vo", vo);
		return "product_modify_form";
	}
	
	@RequestMapping("/modify_fin.do")
	public String modifyFin(ProductVO vo) {
		product_dao.update(vo);
		return "redirect:/list.do";
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
	public String insert(ProductVO vo) {
		
		product_dao.insert(vo);
		return "redirect:/list.do?category=" + vo.getCategory();
	}
	
	@RequestMapping("/cart_list.do")
	public String cartList(int m_idx, Model model) {
		List<CartVO> list = cart_dao.select(m_idx);
		model.addAttribute("vo",list);
		return "cartList";
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
}
