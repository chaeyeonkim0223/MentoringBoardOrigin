package com.ktds.questionformentoring.scheduler.service;

public interface BoardSchedulerService {
    /*
     * 오늘의 글 현황(답변/미답변) 삽입/조회
     * 일별 게시물 수 삽입/조회
     */

    public void getStatusByDate();

    public void getCountByDate();
}
