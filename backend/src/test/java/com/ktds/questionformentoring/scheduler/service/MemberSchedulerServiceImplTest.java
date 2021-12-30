package com.ktds.questionformentoring.scheduler.service;

import com.ktds.questionformentoring.scheduler.entity.MemberStatusDTO;
import com.ktds.questionformentoring.scheduler.entity.OutMemberStatusDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class MemberSchedulerServiceImplTest {

    @Autowired
    private MemberSchedulerService memberSchedulerService;

    @Test
    void getMemberStatus() {
        MemberStatusDTO result = memberSchedulerService.getMemberStatus();
        System.out.println("result = " + result.toString());
        Assertions.assertThat(result.getTotYmd()).isEqualTo("2021-12-30");
    }

    @Test
    void getOutMemberStatus() {
        OutMemberStatusDTO result = memberSchedulerService.getOutMemberStatus();
    }
    // 회원 현황 테스트 ㅇ
    @Test
    void insertMemberStatus() {
        memberSchedulerService.insertMemberStatus();
        MemberStatusDTO result = memberSchedulerService.getMemberStatus();
        System.out.println("result = " + result.toString());
    }
    // 탈퇴 회원 현황 테스트 ㅇ
    @Test
    void insertOutMemberStatus() {
        memberSchedulerService.insertOutMemberStatus();
        OutMemberStatusDTO result = memberSchedulerService.getOutMemberStatus();
        System.out.println("result = " + result.toString());
    }

}