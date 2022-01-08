package com.ktds.questionformentoring.member.service;

import com.ktds.questionformentoring.member.entity.MemberDTO;
import com.ktds.questionformentoring.member.entity.MemberManagementDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class MemberServiceImplTest {

    @Autowired
    MemberServiceImpl memberService;

    @Test
    void save() {
        MemberDTO member = MemberDTO.builder()
                .mbrNm("test")
                .loginId("test")
                .loginPwd("test")
                .mbrTypeCd("test")
                .mtrId("")
                .telno("test")
                .mbrSbscDt(new Date().toString())
                .rtrmmbDt(new Date().toString())
                .rtrmmbWhyCd("")
                .lastLoginDt(new Date().toString())
                .pwdChgDate(new Date().toString())
                .infoAmdDt(new Date().toString())
                .build();

        memberService.save(member);

        log.info(member.toString());
    }

    @Test
    void searchMemberList() {
    }

    @Test
    void searchMemberNameList() {
    }

    @Test
    void searchMemberTypeList() {
    }

    @Test
    void deleteByMbrNo() {
    }
}