package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BasicController {

    @GetMapping("/book")
    public String getBook(Model model){
        // 타임리프는 resources/templates 안으로 매핑
        model.addAttribute("title", "타임리프 With 부트");
        model.addAttribute("description", "타임리프 패턴");
        return "basic/book";
    }
}
