package com.ktds.questionformentoring.scheduler.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class BoardStatusDTO {

    /* 집계 일자 */
    private int totYmd;
    /* 집계 게시물 숫자 */
    private int totPstartNum;
    /* 집계 답변 완료 게시물 숫자 */
    private int totAnsCmptnPstartNum;
    /* 집계 답변 미완료 게시물 숫자 */
    private int totAnsYetCmptnPstartNum;

}
