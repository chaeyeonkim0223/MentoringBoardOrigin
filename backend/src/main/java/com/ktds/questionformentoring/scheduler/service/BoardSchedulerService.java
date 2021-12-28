package com.ktds.questionformentoring.scheduler.service;

public interface BoardSchedulerService {
    /*
     * 오늘의 글 현황(답변/미답변)
     * 일별 게시물 수
     */

    public void getStatusByDate(String nowDate);

    public void getCountByDate(String nowDate);
}
