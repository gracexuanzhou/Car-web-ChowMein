package com.zyp.carweb.utils;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResponseUtils {

    public static void renderString(HttpServletResponse response, String data) {
        response.setContentType("text/html; charset=utf-8");
        write(response, data);
    }

    public static void renderJson(HttpServletResponse response, Object data) {
        response.setContentType("application/json; charset=utf-8");

        write(response, JSON.toJSONString(data));
    }

    private static void write(HttpServletResponse response, String data) {
        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.write(data);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
