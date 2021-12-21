package com.ktds.questionformentoring.notification.mapper;

import com.ktds.questionformentoring.notification.entity.NotificationHistoryDTO;

import java.util.List;

public interface NotificationHistoryMapper {

    // 알림 저장
    public NotificationHistoryDTO save(NotificationHistoryDTO notificationHistoryDTO);

    // 알림 내역 가져오기
    public List<NotificationHistoryDTO> findByMbrNo(int mbrNo);

    // 알림 내역 삭제
    public void deleteByMbrNo(int ntcPsthNo);
}
