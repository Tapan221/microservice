package com.example.zjpabasics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ZJpaBasicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZJpaBasicsApplication.class, args);
	}

}
