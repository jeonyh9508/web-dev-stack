package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends CrudRepository<Member, Long> {
    // CrudRepository : 따로 sql 문을 작성하지 않고, 생성 조회 수정 삭제기능을 제공하는 인터페이스
    // CrudRepository가 제공하는 기본 crud 메서드
    
    // 1. save() :  생성 및 수정
    // 2. findById(), findAll() : 조회
    // 3. deleteById(), deleteAll() : 삭제
    // 4. count() : 전체 행수 조회

    List<Member> findByName(String name);

    // 정해진 규칙이 있는 메서드 명
    List<Member> findByNameContaining(String name);

    // 이름으로 삭제
    int deleteByName(String name);
    // 아이디로 삭제
    int deleteById(long id);
}
