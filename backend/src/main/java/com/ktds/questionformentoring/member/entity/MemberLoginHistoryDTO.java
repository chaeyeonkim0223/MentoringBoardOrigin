package com.ktds.questionformentoring.member.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberLoginHistoryDTO {

    private int mbrLoginSeq;    // 회원 로그인 일련번호
    private int mbrNo;          // 회원 번호
    private String loginId;     // 로그인 아이디
    private String loginIp;     // 로그인 IP
    private String loginDt;     // 로그인 일시
}
