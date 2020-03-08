package com.zyp.carweb.service;

import com.zyp.carweb.model.Comment;

import java.util.List;

public interface CommentService {

    List<Comment> getCommentByGoods(Comment comment);

    int insertSelective(Comment record);
}
