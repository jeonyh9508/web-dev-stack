package com.kh.pro;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import dao.ProductDAO;
import vo.ProductVO;

@Controller
public class ProductController {

	@Autowired
	ServletContext app;

	@Autowired
	HttpServletRequest request;

	ProductDAO product_dao;

	public void setProduct_dao(ProductDAO product_dao) {
		this.product_dao = product_dao;
	}

	@RequestMapping("/list.do")
	public String list(String category, Model model) {
		if (category == null) {
			category = "com001";
		}
		List<ProductVO> list = product_dao.select(category);
		model.addAttribute("list", list);
		return "product/product_list";
	}

	@RequestMapping("/product_regi_form.do")
	public String rigiForm() {
		return "product/product_regi_form";
	}

	@RequestMapping("/insert.do")
	public String insert(ProductVO vo) throws IllegalStateException, IOException {

		String webPath = "/resources/images/";
		// 절대 경로
//		String savePath = "C:\\Users\\user1\\Desktop\\upload";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대 경로 : " + savePath);

		MultipartFile photo1 = vo.getPhoto1();
		String filename1 = "no_file";

		if (!photo1.isEmpty()) {
			filename1 = photo1.getOriginalFilename();
			File saveFile = new File(savePath, filename1);

			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				long time = System.currentTimeMillis();
				filename1 = String.format("%d_%s", time, filename1);
				saveFile = new File(savePath, filename1);
			}
			photo1.transferTo(saveFile);

		}

		MultipartFile photo2 = vo.getPhoto2();
		String filename2 = "no_file";

		if (!photo2.isEmpty()) {
			filename2 = photo2.getOriginalFilename();
			File saveFile = new File(savePath, filename2);

			if (!saveFile.exists()) {
				saveFile.mkdirs();
			} else {
				long time = System.currentTimeMillis();
				filename2 = String.format("%d_%s", time, filename2);
				saveFile = new File(savePath, filename2);
			}
			photo2.transferTo(saveFile);

		}

		vo.setP_image_s(filename1);
		vo.setP_image_l(filename2);

		product_dao.insert(vo);
		return "redirect:/list.do?category=" + vo.getCategory();
	}
	
	@RequestMapping("/view.do")
	public String view(Model model, int idx) {
		ProductVO vo = product_dao.selectOne(idx);
		model.addAttribute("vo", vo);
		return "product/product_detail";
	}
	
	@RequestMapping("/modify_form.do")
	public String modifyForm(int idx, Model model) {
		ProductVO vo = product_dao.selectOne(idx);
		model.addAttribute("vo", vo);
		return "product/product_modify_form";
	}

	@RequestMapping("/product_del")
	public String delProduct(int idx) {
		ProductVO vo = product_dao.selectOne(idx);
		
		product_dao.del(idx);
		return "redirect:/list.do?category=" + vo.getCategory();
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
}
