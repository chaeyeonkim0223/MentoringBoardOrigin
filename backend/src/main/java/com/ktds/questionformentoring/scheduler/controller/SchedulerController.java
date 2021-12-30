package com.ktds.questionformentoring.scheduler.controller;

import com.ktds.questionformentoring.scheduler.entity.BoardCountVo;
import com.ktds.questionformentoring.scheduler.entity.BoardStatusDTO;
import com.ktds.questionformentoring.scheduler.entity.MemberStatusDTO;
import com.ktds.questionformentoring.scheduler.entity.OutMemberStatusDTO;
import com.ktds.questionformentoring.scheduler.service.BoardSchedulerService;
import com.ktds.questionformentoring.scheduler.service.MemberSchedulerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@Api(value = "통계 스케줄러 API", tags = {"Scheduler"})
@RequestMapping("/api/chartData")
@RestController
public class SchedulerController {

    @Autowired
    private BoardSchedulerService boardSchedulerService;
    @Autowired
    private MemberSchedulerService memberSchedulerService;

    @GetMapping("/members")
    @ApiOperation(value = "회원 현황 조회", notes = "<strong>현재 가입된 회원의 현황(멘티/멘토/탈퇴) 현황을 보여준다</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<MemberStatusDTO> findMemberStatus(){
        try{
            return new ResponseEntity<MemberStatusDTO>(memberSchedulerService.getMemberStatus(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/outMembers")
    @ApiOperation(value = "탈퇴 회원 현황 조회", notes = "<strong>현재 탈퇴한 회원의 현황(멘티/멘토) 현황을 보여준다</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<OutMemberStatusDTO> findOutMemberStatus(){
        try{
            return new ResponseEntity<OutMemberStatusDTO>(memberSchedulerService.getOutMemberStatus(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/boardStatus")
    @ApiOperation(value = "게시물 현황 조회", notes = "<strong>현재 작성된 게시물의 답변현황(답변/미답변) 현황을 보여준다</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<BoardStatusDTO> findBoardStatus(){
        try{
            return new ResponseEntity<BoardStatusDTO>(boardSchedulerService.getStatusByDate(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("/boardCount")
    @ApiOperation(value = "일주일 간 게시물 갯수 조회", notes = "<strong> 금일 기준으로 일주일 동안의 작성된 글의 갯수를 보여준다</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List<BoardCountVo>> findBoardCount(){
        try{

            return new ResponseEntity<List<BoardCountVo>>(boardSchedulerService.getCountByDate(), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
    }

}
