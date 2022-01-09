package com.ktds.questionformentoring.member.service;

import com.ktds.questionformentoring.common.util.CommonUtil;
import com.ktds.questionformentoring.member.entity.MemberDTO;
import com.ktds.questionformentoring.member.entity.MemberLoginHistoryDTO;
import com.ktds.questionformentoring.member.mapper.MemberLoginHistoryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;


@Service
@RequiredArgsConstructor
public class MemberLoginHistoryServiceImpl implements MemberLoginHistoryService {

    private final MemberLoginHistoryMapper memberLoginHistoryMapper;

    @Override
    public List<MemberLoginHistoryDTO> findByMbrNo(int mbrNo) {
        return memberLoginHistoryMapper.findByMbrNo(mbrNo);
    }

    @Override
    public void setMemberLoginHistory(MemberDTO memberDTO) throws UnknownHostException {
        MemberLoginHistoryDTO memberLoginHistoryDTO = new MemberLoginHistoryDTO();
        memberLoginHistoryDTO.setLoginId(memberDTO.getLoginId());
        memberLoginHistoryDTO.setMbrNo(memberDTO.getMbrNo());
        memberLoginHistoryDTO.setLoginIp(CommonUtil.getIpAddr());
        memberLoginHistoryMapper.saveLoginHistory(memberLoginHistoryDTO);
    }
}
