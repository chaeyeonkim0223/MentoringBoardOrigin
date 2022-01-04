package com.ktds.questionformentoring.board.controller;

import com.ktds.questionformentoring.board.entity.BoardDTO;
import com.ktds.questionformentoring.board.service.BoardService;
import com.ktds.questionformentoring.member.entity.MemberDTO;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@Api(value = "게시판 API", tags = {"Board"})
@RequestMapping("/api/boards")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping()
    @ApiOperation(value = "해당 게시판에 있는 모든 게시글들 반환", notes = "<strong>모든 게시글들을 반환한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List<BoardDTO>> findAll() {
        try {
            List<BoardDTO> result = boardService.findAll();
            return new ResponseEntity<List<BoardDTO>>(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }

    }

    @GetMapping("/{pstartNo}")
    @ApiOperation(value = "게시글 정보 pstartNo로 찾기", notes = "<strong>게시글 pstartNo로 게시글을 찾는다</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<BoardDTO> findBoardById(
            @PathVariable @ApiParam(value = "게시글 pstartNo", required = true) int pstartNo) {
        try {
            BoardDTO boardDTO = boardService.findById(pstartNo);

            //조회수 +1
            boardDTO.setInqCnt(boardDTO.getInqCnt() + 1);
            System.out.println("boardDTO = " + boardDTO);
            boardService.update(boardDTO);
            return new ResponseEntity(boardDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping()
    @ApiOperation(value = "게시글 생성", notes = "<strong>게시판을 생성한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<BoardDTO> writeBoard(
            @RequestBody @ApiParam(value = "게시글 생성 정보", required = true) BoardDTO boardDTO) {
        try {
//                  boardDTO.setPstartNo(1);
//            boardDTO.setRgtrId("id");
//            boardDTO.setRgtrNm("name");
//            boardDTO.setRgtrMbrCd("공통코드");
////        boardDTO.setRegDt("timestamp");
////            boardDTO.setPstartTitlNm("게시물 제목명");
////            boardDTO.setPstartCn("게시물 내용");
//            boardDTO.setInqCnt(1);
//            boardDTO.setCmntCnt(3);
//            boardDTO.setSlctnYn('N');
//            boardDTO.setMbrNo(2);
            BoardDTO result = boardService.write(boardDTO);//
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping()
    @ApiOperation(value = "게시글 수정", notes = "<strong>pstartNo가 일치하는 게시글을 수정한다.</strong></br>수정하고 싶은 항목들만 작성하면 된다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<BoardDTO> updateBoard(@RequestBody BoardDTO boardDTO) {
        try {
            boardService.update(boardDTO);
            BoardDTO boardRes = boardService.findById(boardDTO.getPstartNo());
            return new ResponseEntity(boardRes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{pstartNo}")
    @ApiOperation(value = "게시글 삭제", notes = "<strong>pstartNo가 일치하는 게시글을 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity deleteBoard(@PathVariable int pstartNo) {
        try {
            boardService.delete(pstartNo);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/mentor/{mbrNo}")
    @ApiOperation(value = "멘토 정보를 회원 번호로 조회", notes = "<strong>회원 번호로 멘토의 정보를 조회한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<MemberDTO> findMentorInfo(
            @PathVariable @ApiParam(value = "회원번호 mbrNo", required = true) int mbrNo) {
        try {
            MemberDTO mentorInfo = boardService.getMentorInfo(mbrNo);
            return new ResponseEntity(mentorInfo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

}
