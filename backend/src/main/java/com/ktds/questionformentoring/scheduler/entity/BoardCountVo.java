package com.ktds.questionformentoring.scheduler.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardCountVo {

    //게시글 갯수
    private int totPstartNum;
    //집계 일자
    private String totYmd;
}
