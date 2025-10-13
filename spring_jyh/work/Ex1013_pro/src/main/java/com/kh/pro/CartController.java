package com.kh.pro;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import dao.CartDAO;
import vo.CartVO;

@Controller
public class CartController {

	CartDAO cart_dao;
	
	@Autowired
	HttpServletRequest request;
	
	public void setCart_dao(CartDAO cart_dao) {
		this.cart_dao = cart_dao;
	}
	
	@RequestMapping("/cart_list.do")
	public String cartList(Model model) {
		HttpSession session = request.getSession();
		int m_idx = (Integer) session.getAttribute("member_idx");
		List<CartVO> list = cart_dao.select(m_idx);
		model.addAttribute("vo", list);
		int total = cart_dao.selectTotalAmount(m_idx);
		model.addAttribute("total", total);
		return "cart/cartList";
	}
	
	@RequestMapping("/cart_insert.do")
	@ResponseBody
	public String cartInsert(CartVO vo) {
		HttpSession session = request.getSession();
		int m_idx = (Integer) session.getAttribute("member_idx");
		vo.setM_idx(m_idx);
		CartVO resVo = cart_dao.selectOne(vo);
		String result = "no";
		if (resVo == null) {
			result = "yes";
			cart_dao.insert(vo);
		}
		String resStr = String.format("[{'result' : '%s'}]", result);
		
		return resStr;
	}
	
	@RequestMapping("/delete_cart.do")
	public String cartDel(int c_idx, Model model) {
		cart_dao.cartDelete(c_idx);
		
		return "redirect:/cart_list.do";
	}

	@RequestMapping("/cart_update.do")
	public String cntModify(CartVO vo) {
		HttpSession session = request.getSession();
		int m_idx = (Integer) session.getAttribute("member_idx");
		vo.setM_idx(m_idx);
		cart_dao.cartUpdate(vo);
		return "redirect:/cart_list.do";
	}
}
