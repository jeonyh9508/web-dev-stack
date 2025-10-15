package com.example.demo.controller;

import com.example.demo.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class MemberController {

    private List<Member> members =
            List.of( new Member(1l,"홍길동","red@one.com",20),
                    new Member(2l,"청길동","blue@two.com",26),
                    new Member(3l,"자길동","purple@three.com",72),
                    new Member(4l,"흑길동","black@four.com",37));


    @GetMapping("/member/list")
    public String getMembers(Model model){
        model.addAttribute("members",members);
        return "member-list";
    }
}
