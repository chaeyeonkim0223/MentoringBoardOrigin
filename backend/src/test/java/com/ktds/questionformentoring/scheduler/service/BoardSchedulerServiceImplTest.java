package com.ktds.questionformentoring.scheduler.service;

import com.ktds.questionformentoring.scheduler.entity.BoardStatusDTO;
import com.ktds.questionformentoring.scheduler.mapper.BoardSchedulerMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BoardSchedulerServiceImplTest {

    @Autowired
    BoardSchedulerService boardSchedulerService;

    @Test
    void getStatusByDate() {
        String date = "2021-12-29";
        BoardStatusDTO result = boardSchedulerService.getStatusByDate();
        System.out.println("result = " + result.toString());
        assertThat(result.getTotPstartNum()).isEqualTo(9);

    }

    @Test
    void getCountByDate() {
    }

    @Test
    void insertStatus() {
    }
}