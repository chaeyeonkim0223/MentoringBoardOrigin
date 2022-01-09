package com.ktds.questionformentoring.signin.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ktds.questionformentoring.common.ResponseMsg;
import com.ktds.questionformentoring.login.service.LoginServiceImpl;
import com.ktds.questionformentoring.member.entity.MemberDTO;
import com.ktds.questionformentoring.member.service.MemberLoginHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin("*")
public class SinginController {

    @Autowired
    private LoginServiceImpl loginService;
    @Autowired
    private MemberLoginHistoryServiceImpl memberLoginHistoryService;

    @PostMapping("/siginIn")
    public ResponseEntity<Object> siginIn(HttpServletRequest request, @RequestBody MemberDTO memberDTO) throws Exception {
        String msg = "";
        return new ResponseEntity<Object>(msg, HttpStatus.OK);
    }
}
