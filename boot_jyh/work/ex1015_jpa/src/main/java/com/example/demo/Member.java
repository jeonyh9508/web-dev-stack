package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;

// @Table : 현재 클래스가 매핑될 DB임을 명시
// @Entity : Entity로 지정된 클래스에 대해서 구체적인 테이블명 , 제약 조건등을 가능하게 한다
@Entity
@Builder
public class Member {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY ) // 기본키 값이 자동으로 생성되도록 한다
    private long id;
    private String name;
    private String email;
    private int age;
}
