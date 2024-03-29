package com.ktds.questionformentoring.member.mapper;

import com.ktds.questionformentoring.member.entity.MemberDTO;
import com.ktds.questionformentoring.member.entity.MemberManagementDTO;

import java.util.List;

public interface MemberMapper {

    // 유저 조회 (한명)
    MemberManagementDTO findByMbrNo(int mbrNo);

    // 유저 저장
    public MemberDTO save(MemberDTO memberDTO);

    // 관리자 페이지 - 유저리스트 조회
    public List<MemberManagementDTO> findAll();

    // 관리자 페이지 - 유저 이름 검색
    public List<MemberManagementDTO> findByMbrNm(String mbrNm);

    // 관리자 페이지 - 유저 유형 검색 (멘토, 멘티)
    public List<MemberManagementDTO> findByMbrTypeCd(String mbrTypeCd);

    // 관리자 페이지 - 유저 삭제
    public void deleteByMbrNo(int mbrNo);
}
