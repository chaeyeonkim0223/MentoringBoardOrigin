package com.ktds.questionformentoring.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Scheduler {
    @Scheduled(cron = "*/10 * * * * *")
    public void TestSchedularRun(){
        log.info("hello schedular");
    }
}
