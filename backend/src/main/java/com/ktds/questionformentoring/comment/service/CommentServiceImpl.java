package com.ktds.questionformentoring.comment.service;

import com.ktds.questionformentoring.comment.entity.CommentDTO;
import com.ktds.questionformentoring.comment.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<CommentDTO> findAll() {
        return commentMapper.findAll();
    }

    @Override
    public List<CommentDTO> findCommentList(int pstartNo) {
        return commentMapper.findCommentList(pstartNo);
    }

    @Override
    public CommentDTO findById(int cmntSn) {
        return commentMapper.findById(cmntSn);
    }

    @Override
    public CommentDTO write(CommentDTO commentDTO) {
        return commentMapper.write(commentDTO);
    }

    @Override
    public void update(CommentDTO commentDTO) {
        commentMapper.update(commentDTO);
    }

    @Override
    public void delete(int cmntSn) {
        commentMapper.delete(cmntSn);
    }
    @Override
    public int countNum(int pstartNo) {
        return commentMapper.countNum(pstartNo);
    }
}
