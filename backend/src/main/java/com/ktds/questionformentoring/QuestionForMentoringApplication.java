package com.ktds.questionformentoring;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//@MapperScan(value = {"com.ktds.questionformentoring.board.mapper"})
@SpringBootApplication
@EnableScheduling
public class QuestionForMentoringApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionForMentoringApplication.class, args);
	}

}
