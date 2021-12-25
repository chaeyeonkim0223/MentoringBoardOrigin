package com.ktds.questionformentoring.login.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ktds.questionformentoring.login.service.LoginServiceImpl;
import com.ktds.questionformentoring.member.entity.MemberDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/v1/auth")
@CrossOrigin("*")
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @GetMapping("/getUser") // 토큰에 담겨있는 사용자 정보를 리턴, 토큰이 필요한 경로
    public ResponseEntity<Object> getUser(HttpServletRequest request) {
        try {
            String token = request.getHeader("jwt-auth-token");
            Map<String, Object> tokenInfoMap = loginService.getInfo(token);

            MemberDTO user = new ObjectMapper().convertValue(tokenInfoMap.get("user"), MemberDTO.class);

            return new ResponseEntity<Object>(user, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login") // 로그인, 토큰이 필요하지 않는 경로
    public ResponseEntity<Object> login(@RequestBody MemberDTO memberDTO, HttpServletResponse response) {
        try {
            System.out.println(memberDTO.getLoginId());
            MemberDTO DBUser = new MemberDTO(); // 원래는 DB에 저장되어 있는 사용자 정보 가져와야 하는 부분
            DBUser.setLoginId("testuser");
            DBUser.setLoginPwd("1234");

            if(DBUser.getLoginId().equals(memberDTO.getLoginId()) && DBUser.getLoginPwd().equals(memberDTO.getLoginPwd())) { // 유효한 사용자일 경우
                String token = loginService.createToken(memberDTO); // 사용자 정보로 토큰 생성
                response.setHeader("jwt-auth-token", token); // client에 token 전달
                return new ResponseEntity<Object>("login Success", HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>("login Fail", HttpStatus.OK);
            }
        } catch(Exception e) {
            return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
        }
    }
}
