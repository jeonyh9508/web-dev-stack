package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
        // JPA (Java Persistance API) : 객체와 데이터베이스를 쉽게 연결하기 위한 표준 인터페이스
        // 객체를 DB테이블과 자동으로 매핑
        // 자동화로 생산성 상승 효과
        // DB가 많아질수록 복잡도가 높아져 관리가 어려움
}
