package com.ktds.questionformentoring.scheduler.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardCountVo {

    //게시글 갯수
    private int count;
    //해당 날짜
    private String regDt;
}
