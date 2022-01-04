package com.ktds.questionformentoring.board.service;

import com.ktds.questionformentoring.board.entity.BoardDTO;
import com.ktds.questionformentoring.member.entity.MemberDTO;

import java.util.List;


public interface BoardService {
    /* 글작성 */
    public BoardDTO write(BoardDTO boardVo);
    /* 글 목록 조회 */
    public List<BoardDTO> findAll();
    /* 글 단건 조회 */
    public BoardDTO findById(int pstartNo);
    /* 글 수정 */
    public void update(BoardDTO boardDTO);
    /* 글 삭제 */
    public void delete(int pstartNo);

    // 멘토 정보 조회
    public MemberDTO getMentorInfo(int mbrNo);
    
    
}
