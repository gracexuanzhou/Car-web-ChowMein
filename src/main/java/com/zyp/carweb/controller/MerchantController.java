package com.zyp.carweb.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyp.carweb.JsonUtils;
import com.zyp.carweb.base.BaseController;
import com.zyp.carweb.base.Result;
import com.zyp.carweb.model.Goods;
import com.zyp.carweb.service.GoodsService;
import com.zyp.carweb.utils.PageUtils;
import com.zyp.carweb.vo.GoodsVo;
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
@RequestMapping("/merchant")
public class MerchantController extends BaseController {

    @Autowired
    private GoodsService goodsService;


    @RequestMapping("/getGoods")
    public PageUtils list(@RequestParam Map<String, Object> params) {
        Page<GoodsVo> page = new Page<>(getCurrent(request), getSize(request));
        page.setCondition(params);
        page.setAsc(false);
        removePageParam(params);
        Map<String, Object> map = new HashMap<>();
        map.put("creator",getSSOUser().getId());
        page = goodsService.selectGoodsPage(page,map);
        log.info("品牌查询结果："+ JsonUtils.toJson(page));
        PageUtils pageUtils = new PageUtils(page.getRecords(), page.getTotal());
        return pageUtils;
    }


    @PostMapping("/save")
    public Result save(Goods goods) {
        try{
            goods.setCreator(getSSOUser().getId());
            goodsService.saveGoods(goods);
            return Result.ok("成功");
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public Result update(Goods goods) {
        try{
            goodsService.updateByPrimaryKeySelective(goods);
            return Result.ok("成功");
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }

    /**
     * 删除
     */
    @PostMapping("/remove")
    public Result remove(Integer id) {
        try{
            goodsService.deleteByPrimaryKey(id);
            return Result.ok("成功");
        }catch (Exception e){
            return Result.error(e.getMessage());
        }
    }
}
