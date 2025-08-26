package com.sh.haagendazo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sh.haagendazo.model.Board;
import com.sh.haagendazo.model.Customer;
import com.sh.haagendazo.model.Paging;
import com.sh.haagendazo.model.User;
import com.sh.haagendazo.service.BoardService;
import com.sh.haagendazo.service.CustomerService;
import com.sh.haagendazo.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class BoardController {

	private String path = "\\\\192.168.0.20\\upload\\";
    private final CustomErrorController customErrorController;

    BoardController(CustomErrorController customErrorController) {
        this.customErrorController = customErrorController;
    }

	public String fileUpload(MultipartFile file) {
		//System.out.println("파일 이름 : " + file.getOriginalFilename());
		//System.out.println("파일 사이즈 : " + file.getSize());
		//System.out.println("파일 파라미터명 : " + file.getName());
		
		// 중복 방지를 위한 UUID 적용
		UUID uuid = UUID.randomUUID();
		String fileName = uuid.toString() + "_" + file.getOriginalFilename();
		System.out.println(file.getOriginalFilename());
		File copyFile = new File(path + fileName);
		try {
			file.transferTo(copyFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		return fileName;
	}
	
	@PostMapping("/upload")
	public String upload(MultipartFile file) {
		String fileName = fileUpload(file);
		// http://localhost:8081/ + fileName <- url
		return "redirect:/board";
	}
	
	// List<MultipartFile>
	@PostMapping("/multiUpload")
	public String multiUpload(List<MultipartFile> files) {
		
		for(MultipartFile file: files) {
			String fileName = fileUpload(file);
		}
		return "redirect:/board";
	}
	
//	@WebServlet("/download")
//	public class FileDownloadServlet extends HttpServlet {
//	    private static final long serialVersionUID = 1L;
//	    private static final String FILE_DIRECTORY = path; // 실제 파일 저장 경로로 변경해야 합니다.
//
//	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//	            throws ServletException, IOException {
//	        
//	        // 1. 요청 파라미터에서 파일 URL 가져오기
//	        String fileName = request.getParameter("url");
//	        if (fileName == null || fileName.isEmpty()) {
//	            response.getWriter().println("File URL is missing.");
//	            return;
//	        }
//
//	        // 2. 파일 객체 생성
//	        File file = new File(FILE_DIRECTORY, fileName);
//	        if (!file.exists()) {
//	            response.getWriter().println("File not found on server: " + file.getAbsolutePath());
//	            return;
//	        }
//
//	        // 3. 파일 다운로드 설정
//	        response.setContentType("application/octet-stream");
//	        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
//
//	        // 4. 파일 데이터 클라이언트에 전송
//	        try (FileInputStream fis = new FileInputStream(file);
//	             OutputStream os = response.getOutputStream()) {
//	            
//	            byte[] buffer = new byte[1024];
//	            int bytesRead;
//	            while ((bytesRead = fis.read(buffer)) != -1) {
//	                os.write(buffer, 0, bytesRead);
//	            }
//	        }
//	    }
//	}
	
	@Autowired
	private BoardService boardService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customer/board")
	public String showBoard(Model model, Paging paging) {
		List<Board> list = boardService.showBoard(paging);
		List<User> dept = userService.showCsdept();
		List<User> manager = userService.showManager();
		List<Customer> customer = customerService.allCustomer(paging);
		model.addAttribute("list", list);
		model.addAttribute("dept", dept);
		model.addAttribute("manager", manager);
		model.addAttribute("customer", customer);
		model.addAttribute("paging", new Paging(paging.getPage(), boardService.total(paging)));
		return "/customer/board";
	}
	
	@PostMapping("/write")
	public String write(Board vo) {
		if(vo.getType().equals("claim")) {
			vo.setUploaderType("customer");
		} else if (vo.getType().equals("notice")) {
			vo.setUploaderType("user");
		};
		boardService.addBoard(vo);
		System.out.println(vo);
		
		return "redirect:/customer/board";
	}
	
	@GetMapping("/customer/delete")
	public String deleteBoard(int boardNo) {
		//Board b = service.selectBoard(boardNo);
		//File file = new File(path + b.getUrl());
		//file.delete();
		boardService.deleteBoard(boardNo);
		return "redirect:/customer/board";
	}
	
	@GetMapping("/customer/view")
	public String view(int boardNo, Model model) {
		Board board = boardService.selectBoard(boardNo);
		model.addAttribute("board", board);
		System.out.println(boardNo);
		return "/customer/view";
	}
	
	@PostMapping("/customer/update")
	public String updateBoard(Board vo) {
		// 새로운 파일로 수정 -> 기존 파일은 삭제하고 해당 파일을 업로드 하고 DB URL을 수정
		
		if(!vo.getFile().isEmpty()) {
			// 1. 파일이 비어있지 않다면 기존 파일 삭제
			File file = new File(path + vo.getUrl());
			file.delete();
			
			// 2. 해당 파일 업로드 -> 새로운 파일의 url 파일명
			String url = fileUpload(vo.getFile());
			vo.setUrl(url);
		}
		
		// 3. 해당 넘버에 따른 데이터들 수정
		boardService.updateBoard(vo);
		System.out.println(vo);
		return "redirect:/customer/view?boardNo=" + vo.getBoardNo();
	}
	
}
