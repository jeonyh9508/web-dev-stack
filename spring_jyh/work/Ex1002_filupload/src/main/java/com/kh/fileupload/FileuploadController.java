package com.kh.fileupload;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import vo.PhotoVO;

@Controller
public class FileuploadController {

	@Autowired
	ServletContext app;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	SqlSession sqlSession;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping(value={"/", "/insert_form.do"})
	public String insert_form() {
		return "insert_form";
	}
	
	@RequestMapping("/upload.do")
	public String upload(PhotoVO vo, Model model) {
		
		String webPath = "/resources/upload";
		// 절대 경로
//		String savePath = "C:\\Users\\user1\\Desktop\\upload";
		String savePath = app.getRealPath(webPath);
		System.out.println("절대 경로 : " + savePath);
		
		// 업로드된 파일의 정보
		MultipartFile photo = vo.getPhoto();
		
		String filename = "no_file";
		
		// 업로드를 위한 파일이 존재
		if(!photo.isEmpty()) {
			// 업로드된 파일의 실제 파일명
			filename = photo.getOriginalFilename();
			
			// 저장할 파일경로
			File saveFile = new File(savePath, filename);
			
			// 경로에 이상이 있을 경우
			if( !saveFile.exists() ) {
				saveFile.mkdirs();
			} else {
				// 동일한 파일명이 존재한다면 현재시간을 붙여서 중복 방지
				long time = System.currentTimeMillis();
				filename = String.format("%d_%s", time, filename);
				saveFile = new File(savePath, filename);
			}
			
			try {
				photo.transferTo(saveFile);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		vo.setFilename(filename);
		
		model.addAttribute("vo", vo);
		
		
		return "input_result";
	}
}
