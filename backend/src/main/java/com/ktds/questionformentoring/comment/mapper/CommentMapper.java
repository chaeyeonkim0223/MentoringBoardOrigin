package com.ktds.questionformentoring.comment.mapper;

import com.ktds.questionformentoring.comment.entity.CommentDTO;

import javax.xml.stream.events.Comment;
import java.util.List;

public interface CommentMapper {
    /* 댓글 전체 조회 */
    public List<CommentDTO> findAll();
    /* 글의 댓글들 글 번호로 조회 */
    public List<CommentDTO> findCommentList(int pstartNo);
    /* 댓글 아이디로 찾기 */
    public CommentDTO findById(int cmntSn);
    /* 댓글 작성 */
    public CommentDTO write(CommentDTO commentDTO);
    /* 댓글 수정 */
    public void update(CommentDTO commentDTO);
    /* 댓글 삭제 */
    public void delete(int cmntSn);
    /* 해당 게시물의 댓글 수 세기 */
    public int countNum(int pstartNo);

}
