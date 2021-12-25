package com.ktds.questionformentoring.login.service;

import com.ktds.questionformentoring.member.entity.MemberDTO;

import java.util.Map;

public interface LoginService {
    public String createToken(MemberDTO memberDto);
    public Map<String, Object> getInfo(String token) throws Exception;
    public void checkValid(String token);
}
