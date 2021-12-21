package com.ktds.questionformentoring.member.service;

import com.ktds.questionformentoring.member.entity.MemberHistoryDTO;
import com.ktds.questionformentoring.member.mapper.MemberHistoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberHistoryServiceImpl implements MemberHistoryService {

    private final MemberHistoryMapper memberHistoryMapper;

    @Override
    public List<MemberHistoryDTO> findByMbrNo(int mbrNo) {
        return memberHistoryMapper.findByMbrNo(mbrNo);
    }

}
