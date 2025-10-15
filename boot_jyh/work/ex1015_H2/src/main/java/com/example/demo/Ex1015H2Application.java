package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class Ex1015H2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex1015H2Application.class, args);
	}

}
