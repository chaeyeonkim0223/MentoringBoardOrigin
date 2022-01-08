package com.ktds.questionformentoring.login.mapper;

import com.ktds.questionformentoring.member.entity.MemberDTO;

import java.lang.reflect.Member;
import java.util.List;

public interface LoginMapper {

    /* 회원 조회 */
    public MemberDTO findOne(String loginId, String loginPwd);
    /* 회원 전체 조회 */
    public List<MemberDTO> findAll();
    /* 유효 회원 체크 */
    public MemberDTO getUserValidate(String loginId, String loginPwd);
}
