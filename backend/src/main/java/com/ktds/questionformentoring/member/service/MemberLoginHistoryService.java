package com.ktds.questionformentoring.member.service;

import com.ktds.questionformentoring.member.entity.MemberLoginHistoryDTO;

import java.util.List;

public interface MemberLoginHistoryService {

    // 회원 로그인 이력 가져오기
    public List<MemberLoginHistoryDTO> findByMbrNo(int mbrNo);
}
