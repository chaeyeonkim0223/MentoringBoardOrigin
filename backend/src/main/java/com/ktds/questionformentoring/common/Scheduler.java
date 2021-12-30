package com.ktds.questionformentoring.common;

import com.ktds.questionformentoring.scheduler.entity.BoardStatusDTO;
import com.ktds.questionformentoring.scheduler.service.BoardSchedulerService;
import com.ktds.questionformentoring.scheduler.service.MemberSchedulerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Scheduler {

    @Autowired
    private BoardSchedulerService boardSchedulerService;
    @Autowired
    private MemberSchedulerService memberSchedulerService;

    // 매일 00시 정각
    @Scheduled(cron = "0 0 0 * * *")
    public void everyDay() throws Exception {
        // 게시물 상태 insert
        BoardStatusDTO result = boardSchedulerService.insertStatus();
        // 회원 상태 insert
        memberSchedulerService.insertMemberStatus();
        memberSchedulerService.insertOutMemberStatus();
        log.info("매일 00시");

    }
}
