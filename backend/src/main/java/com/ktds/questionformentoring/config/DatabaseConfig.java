package com.ktds.questionformentoring.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
        basePackages = {
                "com.ktds.questionformentoring.board.mapper",
                "com.ktds.questionformentoring.member.mapper",
                "com.ktds.questionformentoring.comment.mapper",
                "com.ktds.questionformentoring.notification.mapper",
                "com.ktds.questionformentoring.login.mapper",
                "com.ktds.questionformentoring.scheduler.mapper",
                "com.ktds.questionformentoring.siginin.mapper"
        }
)
public class DatabaseConfig {}

