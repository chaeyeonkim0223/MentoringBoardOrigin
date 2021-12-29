package com.ktds.questionformentoring.scheduler.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class MemberStatusDTO {

    /* 집계 일자 */
    private int totYmd;
    /* 집계 회원 숫자 */
    private int totMbrNum;
    /* 집계 멘티 숫자 */
    private int totMteNum;
    /* 집계 멘토 숫자 */
    private int totMtrNum;
    /* 집계 탈퇴 회원 숫자 */
    private int totWhdwlMbrNum;

}
