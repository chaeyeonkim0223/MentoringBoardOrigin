package com.ktds.questionformentoring.config;

import com.ktds.questionformentoring.common.intercepter.LoginIntercepter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.ktds.questionformentoring.login.controller", "com.ktds.questionformentoring.common.intercepter"}) // Interceptor도 스캔
public class LoginConfig implements WebMvcConfigurer {

    // Interceptor 등록
    @Autowired
    LoginIntercepter loginIntercepter;

    @Override
    public void addCorsMappings(CorsRegistry registry) { // client에서 header추출이 가능하도록 하기 위해 등록
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("jwt-auth-token");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) { // 인터셉터 등록
        registry.addInterceptor(loginIntercepter)
                //.addPathPatterns("/test/**") // Interceptor가 적용될 경로
                .addPathPatterns("/v1/chart/**") // Interceptor가 적용될 경로
                .excludePathPatterns(new String[]{"/v1/login/**"}); // Interceptor가 적용되지 않을 경로
    }
}