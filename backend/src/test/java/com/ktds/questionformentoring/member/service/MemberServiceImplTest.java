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
                .mbrSbscDt(new Date())
                .rtrmmbDt(new Date())
                .rtrmmbWhyCd("")
                .lastLoginDt(new Date())
                .pwdChgDate(new Date())
                .infoAmdDt(new Date())
                .build();

        memberService.save(member);

        log.info(member.toString());
    }

    @Test
    void searchMemberList() {
        List<MemberManagementDTO> result = memberService.searchMemberList();
        for (int i=1; i<=result.size(); i++) {
            assertEquals(result.get(i-1).getMbrNo(), i);
        }
    }

    @Test
    void searchMemberNameList() {
        String name = "test";
        List<MemberManagementDTO> result = memberService.searchMemberNameList(name);
        for (int i=1; i<=result.size(); i++) {
            assertEquals(result.get(i-1).getMbrNm(), name);
        }
    }

    @Test
    void searchMemberTypeList() {
        String type = "test";
        List<MemberManagementDTO> result = memberService.searchMemberTypeList(type);
        for (int i=1; i<=result.size(); i++) {
            assertEquals(result.get(i-1).getMbrTypeCd(), type);
        }
    }

    @Test
    void deleteByMbrNo() {
    }
}