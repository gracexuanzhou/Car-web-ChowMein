package com.zyp.carweb.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyp.carweb.DateUtil;
import com.zyp.carweb.JsonUtils;
import com.zyp.carweb.base.BaseController;
import com.zyp.carweb.base.Result;
import com.zyp.carweb.bridge.CustomerOrder;
import com.zyp.carweb.bridge.OrderParams;
import com.zyp.carweb.facade.Facade;
import com.zyp.carweb.model.Comment;
import com.zyp.carweb.model.Goods;
import com.zyp.carweb.model.Order;
import com.zyp.carweb.service.CommentService;
import com.zyp.carweb.service.GoodsService;
import com.zyp.carweb.service.OrderService;
import com.zyp.carweb.utils.PageUtils;
import com.zyp.carweb.vo.GoodsVo;
import com.zyp.carweb.vo.OrderVo;
import com.zyp.carweb.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
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
    private Facade facade;


    @RequestMapping("/goods/All")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        Page<GoodsVo> page = new Page<>(getCurrent(request), getSize(request));
        page.setCondition(params);
        page.setAsc(false);
        removePageParam(params);
        page = goodsService.selectGoodsPage(page,params);
        log.info("Brand query results："+ JsonUtils.toJson(page));
        PageUtils pageUtils = new PageUtils(page.getRecords(), page.getTotal());
        return pageUtils;
    }


    @RequestMapping("/order/pay")
    public Result orderPay(UserVo userVo) {
        Order order = new Order();
        order.setGoodsId(userVo.getGoodsId());
        order.setUserId(getSSOUser().getId());
        int i = (int)(5+Math.random()*(19-5+1));
        order.setDays(DateUtil.plusDay2(i));
        orderService.insertSelective(order);
        return Result.ok();
    }

    @RequestMapping("/order/All")
    public PageUtils orderList(@RequestParam Map<String, Object> params) {
        Page<OrderVo> page = new Page<>(getCurrent(request), getSize(request));
        page.setCondition(params);
        page.setAsc(false);
        removePageParam(params);
        OrderParams op = new OrderParams(new CustomerOrder());
        OrderVo order = new OrderVo();
        order.setUserId(getSSOUser().getId());
        page = orderService.selectPage(page,op.buildOrderParam(order));
        log.info("Order query results："+ JsonUtils.toJson(page));
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
        comment.setUserName(getSSOUser().getUserName());
        facade.doSaveComment(comment);
        return Result.ok();
    }

}
