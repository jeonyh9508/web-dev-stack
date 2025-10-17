package com.example.demo.dao;


import com.example.demo.vo.ArticleVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleDAO {
    // 전체 글 조회
    List<ArticleVO> selectAll();
    // 게시글 상세보기
    ArticleVO showView(Integer id);
    void addArticle(ArticleVO vo);
    void delArticle(Integer id);
    void editArticle(ArticleVO vo);
}
