package com.zyp.carweb.dao;

import com.zyp.carweb.model.Goods;
import com.zyp.carweb.model.Order;
import com.zyp.carweb.vo.OrderVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<OrderVo> selectList(Map<String,Object> map);

    Integer selectCount(Map<String,Object> map);
}