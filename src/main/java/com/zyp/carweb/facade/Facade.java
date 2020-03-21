package com.zyp.carweb.facade;

import com.zyp.carweb.model.Comment;
import com.zyp.carweb.model.Order;
import com.zyp.carweb.service.CommentService;
import com.zyp.carweb.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Facade {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CommentService commentService;

    public void doSaveComment(Comment comment){
        Order orderVo = orderService.selectByPrimaryKey(comment.getOrderId());
        comment.setGoodsId(orderVo.getGoodsId());
        comment.setUserId(orderVo.getUserId());
        commentService.insertSelective(comment);
        orderVo.setStatus(2);
        orderService.updateByPrimaryKeySelective(orderVo);
    }
}
