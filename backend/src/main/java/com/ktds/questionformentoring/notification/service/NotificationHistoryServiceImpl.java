package com.ktds.questionformentoring.notification.service;

import com.ktds.questionformentoring.notification.entity.NotificationHistoryDTO;
import com.ktds.questionformentoring.notification.mapper.NotificationHistoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotificationHistoryServiceImpl implements NotificationHistoryService {

    private final NotificationHistoryMapper notificationHistoryMapper;


    @Override
    public NotificationHistoryDTO save(NotificationHistoryDTO notificationHistoryDTO) {
        return notificationHistoryMapper.save(notificationHistoryDTO);
    }

    @Override
    public List<NotificationHistoryDTO> findByMbrNo(int mbrNo) {
        return notificationHistoryMapper.findByMbrNo(mbrNo);
    }

    @Override
    public void deleteByMbrNo(int ntcPsthNo) {
        notificationHistoryMapper.deleteByMbrNo(ntcPsthNo);
    }
}
