package com.ktds.questionformentoring.login.service;

import com.ktds.questionformentoring.member.entity.MemberDTO;

import java.util.List;
import java.util.Map;

public interface LoginService {
    public String createToken(MemberDTO memberDto);
    public Map<String, Object> getInfo(String token) throws Exception;
    public void checkValid(String token);
    public boolean checkValidUser(MemberDTO memberDto);
    public List<MemberDTO> findAll();
    public MemberDTO findOne(MemberDTO memberDTO);
}
