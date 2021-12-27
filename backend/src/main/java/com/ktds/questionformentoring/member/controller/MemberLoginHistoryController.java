package com.ktds.questionformentoring.member.controller;

import com.ktds.questionformentoring.member.entity.MemberLoginHistoryDTO;
import com.ktds.questionformentoring.member.service.MemberLoginHistoryServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Slf4j
@Api(value = "회원 로그인 이력 API", tags = "Member Login History api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/memberLogin")
public class MemberLoginHistoryController {

    private final MemberLoginHistoryServiceImpl memberLoginHistoryService;

    @GetMapping("/{mbrNo}")
    @ApiOperation(value = "회원 접속 이력 조회", notes = "회원 접속 이력 상세 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public List<MemberLoginHistoryDTO> searchMemberHistory(@PathVariable int mbrNo) {
        log.info("GET /api/memberLogin/" + mbrNo);
        return memberLoginHistoryService.findByMbrNo(mbrNo);
    }
}
