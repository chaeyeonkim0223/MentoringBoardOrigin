package com.ktds.questionformentoring.member.service;

import com.ktds.questionformentoring.member.entity.MemberLoginHistoryDTO;
import com.ktds.questionformentoring.member.mapper.MemberLoginHistoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberLoginHistoryServiceImpl {

    private final MemberLoginHistoryMapper memberLoginHistoryMapper;

    public List<MemberLoginHistoryDTO> findByMbrNo(int mbrNo) {
        return memberLoginHistoryMapper.findByMbrNo(mbrNo);
    }
}
