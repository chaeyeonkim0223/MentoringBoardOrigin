package com.ktds.questionformentoring.scheduler.service;

import com.ktds.questionformentoring.scheduler.entity.BoardCountVo;
import com.ktds.questionformentoring.scheduler.entity.BoardStatusDTO;
import com.ktds.questionformentoring.scheduler.mapper.BoardSchedulerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BoardSchedulerServiceImpl implements BoardSchedulerService{

    @Autowired
    private BoardSchedulerMapper boardSchedulerMapper;

    public String makeNowDate(){
        Date date = new Date();

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = simpleDateFormat.format(date);

        java.sql.Date date1 = java.sql.Date.valueOf(formattedDate);

        System.out.println("SQL Date: " + date1.toString());

        return date1.toString();
    }

    @Override
    public BoardStatusDTO getStatusByDate() {
        Map<String, Object> param = new HashMap<>();
        param.put("date", makeNowDate());
        return boardSchedulerMapper.getStatusByDate(param);
    }

    @Override
    public List<BoardCountVo> getCountByDate() {
        Map<String, Object> param = new HashMap<>();
        param.put("date", makeNowDate());
        return boardSchedulerMapper.getCountByDate(param);
    }

    @Override
    public BoardStatusDTO insertStatus() {
        return boardSchedulerMapper.insertStatus();
    }

//    @Override
//    public void insertCount() {
//
//    }
}
