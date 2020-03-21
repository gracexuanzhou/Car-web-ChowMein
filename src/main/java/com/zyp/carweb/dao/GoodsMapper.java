package com.zyp.carweb.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zyp.carweb.model.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface GoodsMapper {

    int insert(Goods record);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(Goods record);

    Goods selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Goods record);

    int updateByPrimaryKey(Goods record);

    List<Goods> selectGoodsList(Map<String,Object> map);

    Integer selectGoodsCount(Map<String,Object> map);
}