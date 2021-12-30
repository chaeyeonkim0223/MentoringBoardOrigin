package com.ktds.questionformentoring.scheduler.mapper;

import com.ktds.questionformentoring.scheduler.entity.MemberStatusDTO;
import com.ktds.questionformentoring.scheduler.entity.OutMemberStatusDTO;

import java.util.Map;

public interface MemberSchedulerMapper {

    // 회원 현황 조회
    public MemberStatusDTO getMemberStatus(Map<String, Object> param);
    // 탈퇴 현황 조회
    public OutMemberStatusDTO getOutMemberStatus(Map<String, Object> param);
    // 회원 현황 삽입
    public MemberStatusDTO insertMemberStatus();
    // 탈퇴 회원 현황 삽입
    public OutMemberStatusDTO insertOutMemberStatus();


}
