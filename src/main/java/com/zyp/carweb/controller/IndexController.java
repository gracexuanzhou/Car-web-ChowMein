package com.zyp.carweb.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.zyp.carweb.base.BaseController;
import com.zyp.carweb.model.Comment;
import com.zyp.carweb.model.Goods;
import com.zyp.carweb.service.CommentService;
import com.zyp.carweb.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@Slf4j
public class IndexController extends BaseController {


    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CommentService commentService;

    @RequestMapping("/index")
    public String index(HttpServletRequest request){
        List<JSONObject> menuList = new ArrayList<>();
        if(getSSOUser().getUserType().equals(1)){
            //顾客
            JSONObject menu = new JSONObject();
            menu.put("text","商品列表");
            menu.put("url","/customer");
            menuList.add(menu);
            menu = new JSONObject();
            menu.put("text","订单管理");
            menu.put("url","/order");
            menuList.add(menu);
        }else{
            //商家
            JSONObject menu = new JSONObject();
            menu.put("text","商品管理");
            menu.put("url","/merchant");
            menuList.add(menu);
        }
        request.setAttribute("menus", menuList);
        request.setAttribute("noticelist", null);
        request.setAttribute("userName", getSSOUser().getUserName());
        request.setAttribute("loginName", getSSOUser().getLoginName());
        request.setAttribute("sex", "1");
         return "index";
    }

    @RequestMapping("/welcome")
    public String welcome(){
        return "welcome";
    }

    @RequestMapping("/login")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/merchant")
    public String merchant(){
        return "merchant/index";
    }

    @RequestMapping("/goods/add")
    public String goodsAdd(){
        return "merchant/add";
    }


    @RequestMapping("/goods/detail/{id}")
    public String goodsDetail(@PathVariable("id") Integer id, Model model){
        Goods goods = goodsService.selectByPrimaryKey(id);
        Comment comment = new Comment();
        comment.setGoodsId(id);
        List<Comment> list = commentService.getCommentByGoods(comment);
        model.addAttribute("clist",list);
        model.addAttribute("goods",goods);
        return "customer/goodsDetail";
    }

    @RequestMapping("/goods/pay/{id}")
    public String goodsPay(@PathVariable("id") Integer id, Model model){
        model.addAttribute("gid",id);
        return "customer/pay";
    }

    @RequestMapping("/goods/edit/{id}")
    public String goodsEdit(@PathVariable("id") Integer id, Model model){
        Goods goods = goodsService.selectByPrimaryKey(id);
        model.addAttribute("goods",goods);
        return "merchant/edit";
    }

    @RequestMapping("/customer")
    public String customer(){
        return "customer/index";
    }

    @RequestMapping("/order")
    public String order(){
        return "customer/order";
    }

    @RequestMapping("/comment/{id}")
    public String comment(@PathVariable("id") Integer id, Model model){
        model.addAttribute("orderId",id);
        return "customer/comment";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        try {
            SecurityUtils.getSubject().logout();
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("用户登出");
        return "redirect:/";
    }
}
