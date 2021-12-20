package com.ktds.questionformentoring.comment.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
    /* 댓글일련번호 */
    private int cmntSn;
    /* 게시물번호 */
    private int pstartNo;
    /* 등록자 아이디 */
    private String rgtrId;
    /* 등록자 명  */
    private String rgtrNm;
    /* 등록자 회원 코드 */
    private String rgtrMbrCd;
    /* 등록일시 */
    private String regDt;
    /* 댓글내용 */
    private String cmntCn;
    /* 선정여부 */
    private char slctnYn;
    /* 회원 번호 */
    private int mbrNo;
}
