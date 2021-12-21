package com.ktds.questionformentoring.notification.entity;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationHistoryDTO {

    private int mbrNo;              // 회원 번호
    private int ntcPstgNo;          // 알림게시번호
    private String ntcPstgTitlNm;   // 알림게시제목명
    private String ntcPstgCn;       // 알림게시내용
    private String lgnId;           // 로그인 아이디
    private Date rcptnDt;           // 수신일시
}
