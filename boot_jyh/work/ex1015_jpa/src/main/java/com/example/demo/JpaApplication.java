package com.example.demo;

import com.example.demo.repository.ArticleRepository;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class JpaApplication implements ApplicationRunner {

    private final MemberRepository memberRepository;
    private final ArticleRepository articleRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Member member1 = Member.builder().name("홍길동").email("hong@one.com").age(82).build();
        Member member2 = Member.builder().name("청길동").email("cheong@two.com").age(23).build();

        memberRepository.save(member1);
        memberRepository.save(member2);

        var article1 = Article.builder().title("안녕하세요.").description("반가워요").member(member1).build();
        var article2 = Article.builder().title("잘 있어요.").description("다시 만나요").member(member1).build();

        articleRepository.save(article1);
        articleRepository.save(article2);


    }
}
