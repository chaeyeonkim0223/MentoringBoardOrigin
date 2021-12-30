package com.ktds.questionformentoring.scheduler.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class OutMemberStatusDTO {

    /* 집계 일자 */
    private String totYmd;
    /* 집계 멘토 탈퇴 숫자 */
    private int totMtrWhdwlNum;
    /* 집계 멘티 탈퇴 숫자 */
    private int totMteWhdwlNum;


}
