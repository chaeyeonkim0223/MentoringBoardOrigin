package com.ktds.questionformentoring.member.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberHistoryDTO {

    private int mbrNo;          // 회원번호
    private Date hstChgDt;      // 이력 변경 일시
    private String mbrNm;       // 회원 명
    private String loginId;     // 로그인 아이디
    private String mbrTypeCd;   // 회원 유형 코드
    private String mtrId;       // 멘토아이디
    private String telno;       // 전화번호
    private Date mbrSbscDt;     // 회원 가입 일시
    private Date rtrmmbDt;      // 탈퇴 일시
    private String rtrmmbWhyCd; // 탈퇴 사유 코드
    private Date lastLoginDt;   // 최종 로그인 일시
    private Date pwdChgDate;    // 비밀번호 변경 일자
    private Date infoAmdDate;   // 정보 수정 일자
}
