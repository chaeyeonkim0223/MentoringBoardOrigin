package com.ktds.questionformentoring.login.service;

import com.ktds.questionformentoring.member.entity.MemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class LoginServiceImplTest {

    @Autowired
    private LoginService loginServiceImpl;
    public String token;
    public int loginId = 1;

    @BeforeEach
    void createToken() {
        Assertions.assertThat(loginServiceImpl).isNotNull();
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setLoginId(loginId++ + "");
        memberDTO.setMbrNm("testuser");
        token = loginServiceImpl.createToken(memberDTO);
        log.info(token);
    }

    @Test
    void getInfo() throws Exception {
        Assertions.assertThat(token).isNotNull();
        Map<String, Object> list = loginServiceImpl.getInfo(token);
        System.out.println(list.size());

        for(String key : list.keySet()) {
            System.out.println(key + "  " + list.get(key));
        }
    }

    @Test
    void checkValid() throws Exception {
        Assertions.assertThat(token).isNotNull();
        loginServiceImpl.checkValid(token);
    }
}