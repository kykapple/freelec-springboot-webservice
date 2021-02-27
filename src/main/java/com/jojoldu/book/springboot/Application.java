package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @EnableJpaAuditing  // JPA Auditing 어노테이션 활성화
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS 실행
    }
}

// @SpringbootApplication :
//          @SpringBootConfiguration : 스프링 부트의 설정을 나타냄.
//          @EnableAutoConfiguration : 미리 정의 되어 있는 Bean들을 가져와서 등록해줌.
//          @ComponentScan : 현재 패키지 아래에서 @Component, @Service, @Repository, @Controller 등이 붙어있는 클래스들을 찾아서 Bean으로 등록해줌