package com.ktds.questionformentoring.scheduler.service;

import com.ktds.questionformentoring.scheduler.entity.MemberStatusDTO;
import com.ktds.questionformentoring.scheduler.entity.OutMemberStatusDTO;
import com.ktds.questionformentoring.scheduler.mapper.MemberSchedulerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class MemberSchedulerServiceImpl implements MemberSchedulerService{

    @Autowired
    private MemberSchedulerMapper memberSchedulerMapper;


    public String makeNowDate(){
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);

        System.out.println("SQL Date: " + date1.toString());

        return date1.toString();
    }

    @Override
    public MemberStatusDTO getMemberStatus() {
        Map<String, Object> param = new HashMap<>();
        param.put("date", makeNowDate());
        return memberSchedulerMapper.getMemberStatus(param);
    }

    @Override
    public OutMemberStatusDTO getOutMemberStatus() {
        Map<String, Object> param = new HashMap<>();
        param.put("date", makeNowDate());
        return memberSchedulerMapper.getOutMemberStatus(param);
    }

    @Override
    public void insertMemberStatus() {
        memberSchedulerMapper.insertMemberStatus();
    }

    @Override
    public void insertOutMemberStatus() {
        memberSchedulerMapper.insertOutMemberStatus();
    }
}
