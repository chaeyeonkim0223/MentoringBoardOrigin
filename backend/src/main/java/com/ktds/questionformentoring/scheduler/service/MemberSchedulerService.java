package com.ktds.questionformentoring.scheduler.service;

import com.ktds.questionformentoring.scheduler.entity.BoardCountVo;
import com.ktds.questionformentoring.scheduler.entity.BoardStatusDTO;
import com.ktds.questionformentoring.scheduler.entity.MemberStatusDTO;
import com.ktds.questionformentoring.scheduler.entity.OutMemberStatusDTO;

import java.util.List;

public interface MemberSchedulerService {

    // 회원 현황 조회
    public MemberStatusDTO getMemberStatus();
    // 탈퇴 현황 조회
    public OutMemberStatusDTO getOutMemberStatus();
    // 회원 현황 삽입
    public void insertMemberStatus();
    // 탈퇴 회원 현황 삽입
    public void insertOutMemberStatus();

}
