package com.ktds.questionformentoring.member.controller;

import com.ktds.questionformentoring.member.entity.MemberHistoryDTO;
import com.ktds.questionformentoring.member.service.MemberHistoryServiceImpl;
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
@Api(value = "멤버 상세 페이지 API", tags = "Member Detail Page")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")
public class MemberHistoryController {

    private final MemberHistoryServiceImpl memberHistoryService;

    @GetMapping("/{mbrNo}")
    @ApiOperation(value = "회원 접속 이력 조회", notes = "회원 접속 이력 상세 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public List<MemberHistoryDTO> searchMemberHistory(@PathVariable int mbrNo) {
        return memberHistoryService.findByMbrNo(mbrNo);
    }
}
