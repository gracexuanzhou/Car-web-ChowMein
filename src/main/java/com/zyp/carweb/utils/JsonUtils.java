package com.zyp.carweb;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class JsonUtils {
    public static <T> T convert(Object object, Class<T> clz) {
        if (object.getClass().getName().equals(clz.getName())) return (T) object;
        String json = "";
        if (object instanceof String) json = (String) object;
        else json = toJson(object);
        return (T) JSON.parseObject(json, clz);
    }

    public static <T> T convert(Object object, Type type) {
        if (type instanceof Class<?>)
            return (T) convert(object, (Class) type);
        if (object.getClass().getName().equals(type.getClass())) return (T) object;
        String json = "";
        if (object instanceof String) json = (String) object;
        else json = toJson(object);
        return (T) JSON.parseObject(json, type);
    }


    public static String toJson(Object object) {
        if (object == null) return "null";
        if (object instanceof String) return String.valueOf(object);
        return JSON.toJSONString(object, SerializerFeature.WriteDateUseDateFormat);
    }

    /**
     * 将json转化成map
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, String> convertJsonStrToMap(String jsonStr) {

        Map<String, String> map = JSON.parseObject(
                jsonStr, new TypeReference<Map<String, String>>() {
                });

        return map;

    }
    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }

}
