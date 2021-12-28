package com.ktds.questionformentoring.scheduler.service;

public interface MemberSchedulerService {
    /*
     * 회원현황 삽입/조회
     * 탈퇴회원현황 삽입/조회
     */

    public void findStatusByDate();

    public void findWithdrawalStatusByDate();

}
