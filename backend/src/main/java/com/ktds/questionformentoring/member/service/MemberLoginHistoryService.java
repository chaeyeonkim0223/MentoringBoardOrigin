package com.ktds.questionformentoring.member.service;

import com.ktds.questionformentoring.member.entity.MemberDTO;
import com.ktds.questionformentoring.member.entity.MemberLoginHistoryDTO;

import java.net.UnknownHostException;
import java.util.List;

public interface MemberLoginHistoryService {

    // 회원 로그인 이력 가져오기
    public List<MemberLoginHistoryDTO> findByMbrNo(int mbrNo);

    // 회원 로그인 이력 저장
    public void setMemberLoginHistory(MemberDTO memberDTO) throws UnknownHostException;
}
