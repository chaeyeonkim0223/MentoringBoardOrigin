package com.ktds.questionformentoring.scheduler.service;

import com.ktds.questionformentoring.scheduler.entity.BoardCountVo;
import com.ktds.questionformentoring.scheduler.entity.BoardStatusDTO;

import java.util.List;

public interface BoardSchedulerService {

    // 게시글 현황 가져오기
    public BoardStatusDTO getStatusByDate();
    // 게시글 갯수 (1주일 분량)가져오기
    public List<BoardCountVo> getCountByDate();
    // 게시글 상태 삽입하기
    public BoardStatusDTO insertStatus();
    // 게시글 갯수 삽입하기
//    public void insertCount();

}
