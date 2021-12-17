package com.ktds.questionformentoring.comment.service;

import com.ktds.questionformentoring.comment.entity.CommentDTO;
import com.ktds.questionformentoring.comment.mapper.CommentMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CommentServiceTest {

    @Autowired
    CommentServiceImpl commentServiceImpl;

    @Test
    void findAll() {
        List<CommentDTO> result = commentServiceImpl.findAll();
        for( CommentDTO commentDTO : result){
            System.out.println("commentDTO = " + commentDTO);

        }
    }

    @Test
    void findCommentList() {
        int pstartNo = 5;
        List<CommentDTO> result = commentServiceImpl.findCommentList(pstartNo);
        for( CommentDTO commentDTO : result){
            assertThat(commentDTO.getPstartNo()).isEqualTo(pstartNo);
        }
    }

    @Test
    void findById() {
        int cmntSn = 2;
        CommentDTO result = commentServiceImpl.findById(cmntSn);
        assertThat(result.getCmntCn()).isEqualTo(cmntSn);
    }

    @Test
    void write() {
        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setPstartNo(5);
        commentDTO.setRgtrId("spring");
        commentDTO.setRgtrNm("spring");
        commentDTO.setRgtrMbrCd("멘토");
        commentDTO.setCmntCn("내용");
        commentDTO.setMbrNo(2);
        CommentDTO result = commentServiceImpl.write(commentDTO);
        assertThat(result.getCmntCn()).isEqualTo(commentDTO.getCmntCn());
    }

    @Test
    void update() {
        CommentDTO commentDTO = new CommentDTO();

        commentDTO.setCmntSn(4);
        commentDTO.setCmntCn("내용변경");
        commentDTO.setSlctnYn('Y');

        commentServiceImpl.update(commentDTO);

    }

    @Test
    void delete() {
        commentServiceImpl.delete(4);
        assertThat(commentServiceImpl.findById(4)).isEqualTo(null);
    }

    @Test
    void countNum() {
        int pstartNo = 5;
        int result = commentServiceImpl.countNum(pstartNo);
        assertThat(commentServiceImpl.findCommentList(pstartNo).size())
                .isEqualTo(result);
    }
}