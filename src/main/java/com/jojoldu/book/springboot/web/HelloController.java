package com.jojoldu.book.springboot.web;

import com.jojoldu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody ==> 클라이언트 요청 - DispatcherServlet과 Handler Mapping이 요청 intercept
                //                                      - Controller에 의해 요청을 처리하고 Controller에서 직접 데이터(자바 객체)
                //                                          를 HTTP 요청의 body 내용으로 매핑하는 역할을 함
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);  // @RequestParam : 외부에서 ("")이란 이름으로 API로 넘긴 파라미터를 가져오는 어노테이션
    }
}
