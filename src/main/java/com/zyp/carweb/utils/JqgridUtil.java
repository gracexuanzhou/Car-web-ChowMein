package com.zyp.carweb.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class JqgridUtil {
	
	public static String  getJson(List<?> list , String currentPage ,int totalCount , int count){
	
		
		if (totalCount <= 0 ) {
			return "{}";
		}
		int totalPage = totalCount% count == 0 ? totalCount/count : totalCount/count + 1;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalPage", totalPage+"");
		map.put("totalCount", totalCount+"");
		map.put("currentPage", currentPage);
		map.put("dataList", list);
		JSONObject jsonObject=new JSONObject(map);
		System.out.println(jsonObject.toJSONString());
		return jsonObject.toJSONString();
	}
	
}
