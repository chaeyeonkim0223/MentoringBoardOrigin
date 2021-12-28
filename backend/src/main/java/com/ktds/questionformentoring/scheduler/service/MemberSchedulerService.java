package com.ktds.questionformentoring.scheduler.service;

public interface MemberSchedulerService {
    /*
     * 회원현황
     * 탈퇴회원현황
     */

    public void findStatusByDate(String nowDate);

    public void findWithdrawalStatusByDate(String nowDate);

}
