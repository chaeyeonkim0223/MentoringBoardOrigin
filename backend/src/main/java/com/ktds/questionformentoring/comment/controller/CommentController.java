package com.ktds.questionformentoring.comment.controller;

import com.ktds.questionformentoring.board.entity.BoardDTO;
import com.ktds.questionformentoring.board.service.BoardService;
import com.ktds.questionformentoring.comment.entity.CommentDTO;
import com.ktds.questionformentoring.comment.service.CommentService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.stream.events.Comment;
import java.util.List;

@CrossOrigin("*")
@Api(value = "댓글 API", tags = {"Comment"})
@RequestMapping("/api/comments")
@RestController
public class CommentController {

    @Autowired private CommentService commentServiceImpl;
    @Autowired private BoardService boardServiceImpl;

    @GetMapping("/{pstartNo}")
    @ApiOperation(value = "해당 게시글 있는 모든 댓글들 반환", notes = "<strong>게시글 pstartNo로 댓글들을 찾는다</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<List<CommentDTO>> findCommentList(
            @PathVariable @ApiParam(value = "게시글 pstartNo", required = true) int pstartNo) {
        try {
            return new ResponseEntity(commentServiceImpl.findCommentList(pstartNo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
    @GetMapping("comment/{cmntSn}")
    @ApiOperation(value = "댓글 정보 cmntSn로 찾기", notes = "<strong>댓글 cmntSn로 댓글을 찾는다</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<CommentDTO> findById(@PathVariable @ApiParam(value = "댓글 cmntSn", required = true) int cmntSn){
        try {
            return new ResponseEntity(commentServiceImpl.findById(cmntSn), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping()
    @ApiOperation(value = "댓글 생성", notes = "<strong>댓글을 생성한다.</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<BoardDTO> writeComment(
            @RequestBody @ApiParam(value = "댓글 생성 정보", required = true) CommentDTO commentDTO) {
        try {
            CommentDTO result = commentServiceImpl.write(commentDTO);
            // 게시물의 댓글 수 증가
            BoardDTO boardDTO = boardServiceImpl.findById(commentDTO.getPstartNo());
            boardDTO.setCmntCnt(boardDTO.getCmntCnt() + 1);
            boardServiceImpl.update(boardDTO);

            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping()
    @ApiOperation(value = "댓글 수정", notes = "<strong>cmntSn가 일치하는 댓글을 수정한다.</strong></br>수정하고 싶은 항목들만 작성하면 된다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<BoardDTO> updateComment(@RequestBody CommentDTO commentDTO) {
        try {
            commentServiceImpl.update(commentDTO);
            CommentDTO result = commentServiceImpl.findById(commentDTO.getCmntSn());
            return new ResponseEntity(result, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{cmntSn}")
    @ApiOperation(value = "댓글 삭제", notes = "<strong>cmntSn 일치하는 댓글을 삭제한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity deleteComment(@PathVariable int cmntSn) {
        try {
            // 게시물의 댓글 수 감소
            CommentDTO commentDTO = commentServiceImpl.findById(cmntSn);
            BoardDTO boardDTO = boardServiceImpl.findById(commentDTO.getPstartNo());
            boardDTO.setCmntCnt(boardDTO.getCmntCnt() - 1);
            boardServiceImpl.update(boardDTO);
            commentServiceImpl.delete(cmntSn);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("count/{pstartNo}")
    @ApiOperation(value = "해당 게시글에 있는 댓글 수 세기", notes = "<strong>게시글 pstartNo로 댓글의 수를 센다</strong>")
    @ApiResponses({
            @ApiResponse(code = 200, message = "성공"),
            @ApiResponse(code = 204, message = "정보 없음"),
            @ApiResponse(code = 500, message = "서버 오류")
    })
    public ResponseEntity<Integer> findCommentCount(
            @PathVariable @ApiParam(value = "게시글 pstartNo", required = true) int pstartNo) {
        try {
            return new ResponseEntity(commentServiceImpl.countNum(pstartNo), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

}
