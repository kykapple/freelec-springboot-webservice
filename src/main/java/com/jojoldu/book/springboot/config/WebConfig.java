package com.jojoldu.book.springboot.config;

import com.jojoldu.book.springboot.config.auth.LoginUserArgumentResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@RequiredArgsConstructor
@Configuration  // 설정을 위한 어노테이션, 클래스를 Bean으로 생성 할 때 SingleTone으로 한번만 생성
public class WebConfig implements WebMvcConfigurer {    // LoginUserArgumentResolver가 스프링에서 인식될 수 있도록 WebMvcConfigurer에 추가

    private final LoginUserArgumentResolver loginUserArgumentResolver;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        // HandlerMethodArgumentResolver는 항상 WebMvcConfigurer의 addArgumentResolvers()를 통해 추가해야 함.
        argumentResolvers.add(loginUserArgumentResolver);
    }
}
