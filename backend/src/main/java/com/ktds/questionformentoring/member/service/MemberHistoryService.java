package com.ktds.questionformentoring.member.service;

import com.ktds.questionformentoring.member.entity.MemberHistoryDTO;

import java.util.List;

public interface MemberHistoryService {

    // 유저 회원 이력 가져오기
    public List<MemberHistoryDTO> findByMbrNo(int mbrNo);

}
