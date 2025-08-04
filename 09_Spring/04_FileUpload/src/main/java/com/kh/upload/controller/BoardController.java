package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.model.dto.BoardDTO;
import com.kh.upload.model.dto.PagingDTO;
import com.kh.upload.model.vo.Board;
import com.kh.upload.service.BoardService;

@Controller
public class BoardController {
	
	private String path = "\\\\192.168.0.35\\upload\\";


	@Autowired
	private BoardService service;


	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	public String fileUpload(MultipartFile file) {
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
//		System.out.println(uuid.toString()); 업로드 할때마다 random
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
//		System.out.println(fileName);
		File copyFile = new File(path + fileName); // \\192.168.0.35\\upload
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	@PostMapping("/upload")
	public String upload(MultipartFile file) {
//		System.out.println("파일 이름 = " + file.getOriginalFilename());
//		System.out.println("파일 사이즈 = " + file.getSize());
//		System.out.println("파일 파라미터명 = " + file.getName());
		
		String fileName = fileUpload(file);
		// http://localhost:8081/ + fileName <- url
		return "redirect:/";
	}

	// List<MultipartFile>
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) {
		for (MultipartFile file : files) {
			String fileName = fileUpload(file);
		}
		
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public String list(Model model, PagingDTO paging) {
		List<BoardDTO> list = service.selectAll(paging);
			model.addAttribute("list", list);
			model.addAttribute("paging",new PagingDTO(paging.getPage(), service.total(paging.getKeyword())));
		return "list";
	}

	/*
	@PostMapping("/write")
	public String write(Board vo, BoardDTO dto) {
		service.insert(vo);
		vo.setUrl(fileUpload(dto.getFile()));
		return "redirect:/list";
	}
	*/
	@PostMapping("/write")
	public String write(BoardDTO dto) {
//		System.out.println(dto.getTitle());
//		System.out.println(dto.getContent());
//		System.out.println(dto.getFile());
		
		// 이미지 업로드 추가
		String fileName = fileUpload(dto.getFile());
		
		// board 테이블에 데이터 추가
		Board vo = new Board();
		vo.setTitle(dto.getTitle());
		vo.setContent(dto.getContent());
		vo.setUrl(fileName);
		service.insert(vo);
		
		System.out.println(vo);
		
		return "redirect:/view?no=" + vo.getNo();
	}
	
	@GetMapping("/view")
	public String view(Model model, int no) {
		Board select = service.select(no);
		model.addAttribute("select", select);
		return "view";
	}
	
//	@PostMapping("/update")
//	public String update(Model model, Board vo, MultipartFile file) {
//		File before = new File("\\\\192.168.0.35\\upload\\" + vo.getUrl());
//		before.delete();
//		
//		System.out.println(file);
//		vo.setUrl(fileUpload(file));
//		
//		System.out.println(vo);
//		fileUpload(file);
//		
//		service.update(vo);
//		return "redirect:/view?no=" + vo.getNo();
//	}
	
	@PostMapping("/update")
	public String update(BoardDTO dto) {
		// 새로운 파일로 수정 -> 기존 파일 살제 해당 파일 업로드 -> DB URL 수정
		if(!dto.getFile().isEmpty()) {
			// 1. 파일이 비어있지 않다면 기존 파일 삭제
			File file = new File(path + dto.getUrl());
			file.delete();
			
			// 2. 해당 파일 업로드
			String url = fileUpload(dto.getFile());
			dto.setUrl(url);
		}
	
		// 3. 해당 no에 따른 데이터 수정
		service.update(dto);
		
		return "redirect:/view?no=" + dto.getNo();
	}
	
	@GetMapping("/delete")
	public String delete(int no, BoardDTO dto) {
		// 이미지가 있는 경우 삭제를 
		Board select = service.select(no);
		
		File file = new File(path + select.getUrl());
		file.delete();
		service.delete(no);
		return "redirect:/list";
	}
	
}
