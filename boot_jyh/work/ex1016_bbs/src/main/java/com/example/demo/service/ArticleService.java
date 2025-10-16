package com.example.demo.service;

import com.example.demo.dto.ArticleDto;
import com.example.demo.model.Article;
import com.example.demo.repsitory.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // final 키워드로 생성자를 사용할 수 있도록
public class ArticleService {
    private final ArticleRepository articleRepository;

    // Article(DB 연동객체) 에서 가져온 정보를 화면에 보여주기 위해 DTO타입으로 매핑하기 위한 메서드
    private ArticleDto mapToArticleDto(Article article){
        return ArticleDto.builder().id(article.getId()).title(article.getTitle()).description(article.getDescription())
                .created(article.getCreated()).updated(article.getUpdated()).member_id(article.getMember_id()).build();
    };

    // 게시글 전체 조회
    public List<ArticleDto> findAll(){
        // SELECT * FROM article
        return articleRepository.findAll().stream().map(this::mapToArticleDto).toList();
    }

    // id로 게시글 조회
    public ArticleDto findById( Long id ){
        // Optional -> findById 객체가 없을 경우 .orElseThrow() 로 처리 할 수 있도록
        return articleRepository.findById(id).map(this::mapToArticleDto).orElseThrow();
    }

    // 새글 작성
    public ArticleDto addNewArticle(Integer member_id, String title, String description){
        Article article = new Article();

        article.setMember_id(member_id);;
        article.setTitle(title);
        article.setDescription(description);
        article.setCreated(article.getCreated());
        article.setUpdated(article.getUpdated());

        Article saveArticle = articleRepository.save(article);

        return mapToArticleDto(saveArticle);
    }

    // 게시글 수정
    public ArticleDto update(ArticleDto dto){
        Article article = articleRepository.findById(dto.getId()).orElseThrow();
        article.setTitle(dto.getTitle());
        article.setDescription(dto.getDescription());
        article.setUpdated(dto.getUpdated());

        Article updateArticle = articleRepository.save(article);

        return mapToArticleDto(updateArticle);
    }

    // 게시글 삭제
    public void delete(Long id){

//        Article article = articleRepository.findById(id).orElseThrow();
//        articleRepository.delete(article);

        articleRepository.deleteById(id);
    }
}
