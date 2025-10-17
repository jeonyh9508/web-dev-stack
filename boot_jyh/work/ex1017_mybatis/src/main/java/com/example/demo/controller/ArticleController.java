package com.example.demo.controller;

import com.example.demo.dao.ArticleDAO;
import com.example.demo.vo.ArticleVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleDAO articleDAO;

    @GetMapping(value = {"/", "/list"})
    public String getArticleList(Model model) {
        List<ArticleVO> articles = articleDAO.selectAll();
        model.addAttribute("articles", articles);
        return "article-list";
    }

    @GetMapping("/content")
    public String getArticle(Model model, Integer id) {
        ArticleVO vo = articleDAO.showView(id);
        model.addAttribute("vo", vo);
        return "article-content";
    }

    @GetMapping("/add")
    public String newArticleForm(Integer member_id, Model model) {
        // 새 글 작성 페이지로 member_id 바인딩
        model.addAttribute("member_id", member_id);
        return "article-add";
    }

    @PostMapping("/add")
    public String addFin(ArticleVO vo){
        articleDAO.addArticle(vo);
        return "redirect:/list";
    }

    @GetMapping("/delete")
    public String delArticle(Integer id){
        articleDAO.delArticle(id);
        return "redirect:/list";
    }

    @GetMapping("/edit")
    public String editForm(Integer id, Model model){
        ArticleVO vo = articleDAO.showView(id);
        model.addAttribute("vo", vo);
        model.addAttribute("id", id);
        return "edit-form";
    }

    @PostMapping("/edit")
    public String editFin(ArticleVO vo){
        articleDAO.editArticle(vo);
        return "redirect:/list";
    }
}
