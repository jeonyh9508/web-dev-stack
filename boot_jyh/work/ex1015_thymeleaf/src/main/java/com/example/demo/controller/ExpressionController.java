package com.example.demo.controller;

import com.example.demo.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class ExpressionController {

    private final List<Member> members =
            List.of( new Member("홍길동", "red@one.com", 26),
                    new Member("청길동", "blue@one.com", 34));

    @GetMapping("/object")
    public String getMember(Model model){

        model.addAttribute("money",999999999);

        Date date = Calendar.getInstance().getTime();
        model.addAttribute("date", date);

        model.addAttribute("members" , members);
        return "express/object";
    }

    @GetMapping("/link")
    public String getLink(Model model){
        model.addAttribute("id",1);
        return "express/link";
    }

    // 쿼리 형식 파라미터
    @GetMapping("/member")
    public String getIdParam(Model model, Integer id){

        if(id != null){
            model.addAttribute("p_mem", members.get(id));
        }else{
            model.addAttribute("p_mem", members.get(0));
        }
        return "express/member-fin";
    }

    // 패스 형식 파라미터
    @GetMapping("/member/{id}")
    public String getIdParam2(Model model,@PathVariable Integer id){

        if(id != null){
            model.addAttribute("p_mem", members.get(id));
        }else{
            model.addAttribute("p_mem", members.get(0));
        }
        return "express/member-fin";
    }

}
