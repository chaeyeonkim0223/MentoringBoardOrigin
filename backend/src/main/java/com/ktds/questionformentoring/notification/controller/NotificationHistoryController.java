package com.ktds.questionformentoring.notification.controller;
import com.ktds.questionformentoring.notification.entity.NotificationHistoryDTO;
import com.ktds.questionformentoring.notification.service.NotificationHistoryServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Slf4j
@Api(value = "알림 이력 API", tags = "Notification History api")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notification")
public class NotificationHistoryController {

    private final NotificationHistoryServiceImpl notificationHistoryService;

    @GetMapping("/{mbrNo}")
    @ApiOperation(value = "알림 이력 조회", notes = "알림 이력 조회")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public List<NotificationHistoryDTO> searchNotificationHistory(@PathVariable int mbrNo) {
        log.info("GET /api/notification" + mbrNo);
        return notificationHistoryService.findByMbrNo(mbrNo);
    }

    @PostMapping()
    @ApiOperation(value = "알림 이력 추가", notes = "회원 알림 이력 추가 api")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public NotificationHistoryDTO saveNotificationHistory(
            @RequestBody @ApiParam(value = "알림 이력", required = true) NotificationHistoryDTO notificationHistoryDTO) {
        log.info("POST /api/notification");
        return notificationHistoryService.save(notificationHistoryDTO);
    }

    @DeleteMapping("/{ntcPstgNo}")
    @ApiOperation(value = "알림 이력 삭제", notes = "알림 이력 삭제 api")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity deleteNotificationHistoryByNtcPstgNo(@PathVariable int ntcPstgNo) {
        log.info("DELETE /api/" + ntcPstgNo);
        notificationHistoryService.deleteByNtcPstgNo(ntcPstgNo);
        return new ResponseEntity(HttpStatus.OK);
    }
}