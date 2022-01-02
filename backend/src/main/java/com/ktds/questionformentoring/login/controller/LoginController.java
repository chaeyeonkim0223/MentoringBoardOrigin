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
@RequestMapping("/api/v1/auth")
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
            System.out.println(e);
            //return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
            return new ResponseEntity<Object>("error", HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/refreshToken") // 토큰에 담겨있는 사용자 정보를 리턴, 토큰이 필요한 경로
    public ResponseEntity<Object> refreshToken(HttpServletRequest request) {
        try {
            String token = request.getHeader("jwt-refresh-token");
            Map<String, Object> tokenInfoMap = loginService.getInfo(token);

            MemberDTO user = new ObjectMapper().convertValue(tokenInfoMap.get("user"), MemberDTO.class);

            return new ResponseEntity<Object>(user, HttpStatus.OK);
        } catch(Exception e) {
            System.out.println(e);
            //return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
            return new ResponseEntity<Object>("error", HttpStatus.CONFLICT);
        }
    }

    @PostMapping("/login") // 로그인, 토큰이 필요하지 않는 경로
    public ResponseEntity<Object> login(@RequestBody MemberDTO memberDTO, HttpServletResponse response) {
        try {
            boolean isValidUser = loginService.checkValidUser(memberDTO);
            if (isValidUser) {
                String token = loginService.createUserToken(memberDTO); // 사용자 정보로 토큰 생성
                String refreshToken = loginService.createRefreshToken(memberDTO);
                response.setHeader("jwt-auth-token", token); // client에 token 전달
                response.setHeader("jwt-refresh-token", refreshToken); // client에 refresh token 전달
                return new ResponseEntity<Object>("login Success", HttpStatus.OK);
            } else {
                return new ResponseEntity<Object>("login Fail", HttpStatus.OK);
            }
        } catch(Exception e) {
            return new ResponseEntity<Object>(null, HttpStatus.CONFLICT);
        }
    }
}
