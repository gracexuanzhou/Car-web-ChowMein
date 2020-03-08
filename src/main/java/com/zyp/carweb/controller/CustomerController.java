package com.zyp.carweb.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyp.carweb.JsonUtils;
import com.zyp.carweb.base.BaseController;
import com.zyp.carweb.base.Result;
import com.zyp.carweb.model.Comment;
import com.zyp.carweb.model.Goods;
import com.zyp.carweb.model.Order;
import com.zyp.carweb.service.CommentService;
import com.zyp.carweb.service.GoodsService;
import com.zyp.carweb.service.OrderService;
import com.zyp.carweb.utils.PageUtils;
import com.zyp.carweb.vo.OrderVo;
import com.zyp.carweb.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/customer")
public class CustomerController extends BaseController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private CommentService commentService;


    @RequestMapping("/goods/All")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        Page<Goods> page = new Page<>(getCurrent(request), getSize(request));
        page.setCondition(params);
        page.setAsc(false);
        removePageParam(params);
        Map<String, Object> map = new HashMap<>();
        page = goodsService.selectGoodsPage(page,map);
        log.info("品牌查询结果："+ JsonUtils.toJson(page));
        PageUtils pageUtils = new PageUtils(page.getRecords(), page.getTotal());
        return pageUtils;
    }


    @RequestMapping("/order/pay")
    public Result orderPay(UserVo userVo) {
        Order order = new Order();
        order.setGoodsId(userVo.getGoodsId());
        order.setUserId(getSSOUser().getId());
        order.setDays((int)(10+Math.random()*(20-5+1)));
        orderService.insertSelective(order);
        return Result.ok();
    }

    @RequestMapping("/order/All")
    public PageUtils orderList(@RequestParam Map<String, Object> params) {
        Page<OrderVo> page = new Page<>(getCurrent(request), getSize(request));
        page.setCondition(params);
        page.setAsc(false);
        removePageParam(params);
        Map<String, Object> map = new HashMap<>();
        map.put("creator",getSSOUser().getId());
        page = orderService.selectPage(page,map);
        log.info("订单查询结果："+ JsonUtils.toJson(page));
        PageUtils pageUtils = new PageUtils(page.getRecords(), page.getTotal());
        return pageUtils;
    }

    @RequestMapping("/order/receive")
    public Result orderReceive(OrderVo orderVo) {
        orderService.updateByPrimaryKeySelective(orderVo);
        return Result.ok();
    }

    @RequestMapping("/comment/save")
    public Result orderReceive(Comment comment) {
        Order orderVo = orderService.selectByPrimaryKey(comment.getOrderId());
        comment.setGoodsId(orderVo.getGoodsId());
        comment.setUserId(orderVo.getUserId());
        comment.setUserName(getSSOUser().getUserName());
        commentService.insertSelective(comment);
        orderVo.setStatus(2);
        orderService.updateByPrimaryKeySelective(orderVo);
        return Result.ok();
    }
}
