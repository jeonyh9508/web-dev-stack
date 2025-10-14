package com.example.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class SpringJdbcApplication implements ApplicationRunner {

    // @Component : 어노테이션들의 부모
    // ㄴ @Controller, @Repository, @Service : Component의 자식 어노테이션

    private final MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        log.info("{}", "hello run");

        // create
//        Member member = Member.builder().name("청길동").email("cheong@six.com").age(10).build();
//        memberRepository.save(member);
//        member.setAge(11);
//        memberRepository.save(member);

        List<Member> members = memberRepository.findByName("홍길동");

        if (members.isEmpty()){
            log.info("'홍길동'은 찾을 수 없는 이름 입니다.");
        }else{
            for(Member member : members){
                log.info("조회된 회원 : {}",member);
            }
        }
        // 이름에 o가 포함되어 있는 데이터를 조회
//        log.info("포함 여부 : {}", memberRepository.findByNameContaining("o"));
//
//        int res = memberRepository.deleteByName("홍길동");
//
    }

}
