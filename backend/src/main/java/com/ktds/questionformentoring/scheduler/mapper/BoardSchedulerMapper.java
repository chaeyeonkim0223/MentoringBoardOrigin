package com.ktds.questionformentoring.scheduler.mapper;

import com.ktds.questionformentoring.scheduler.entity.BoardCountVo;
import com.ktds.questionformentoring.scheduler.entity.BoardStatusDTO;

import java.util.List;
import java.util.Map;

public interface BoardSchedulerMapper {

    // 게시글 현황 가져오기
    public BoardStatusDTO getStatusByDate(Map<String, Object> param);
    // 게시글 갯수 (1주일 분량)가져오기
    public List<BoardCountVo> getCountByDate(Map<String, Object> param);
    // 게시글 상태 삽입하기
    public BoardStatusDTO insertStatus();
//    // 게시글 갯수 삽입하기
//    public void insertCount();
}
