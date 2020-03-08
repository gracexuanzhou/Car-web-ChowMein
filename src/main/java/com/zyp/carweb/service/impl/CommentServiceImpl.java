package com.zyp.carweb.service.impl;

import com.zyp.carweb.dao.CommentMapper;
import com.zyp.carweb.model.Comment;
import com.zyp.carweb.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentByGoods(Comment comment) {
        return commentMapper.getCommentByGoods(comment);
    }

    @Override
    public int insertSelective(Comment record) {
        return commentMapper.insertSelective(record);
    }
}
