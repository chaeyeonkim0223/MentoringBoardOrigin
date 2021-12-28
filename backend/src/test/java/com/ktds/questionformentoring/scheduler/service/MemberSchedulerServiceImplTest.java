package com.ktds.questionformentoring.scheduler.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MemberSchedulerServiceImplTest {

    @Test
    void findStatusByDate() {

    }

    @Test
    void findWithdrawalStatusByDate() {
    }

    @Test
    void SQL날짜형식테스트(){
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);

        System.out.println("SQL Date: " + date1.toString());
    }
}