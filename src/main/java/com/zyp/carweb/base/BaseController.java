package com.zyp.carweb.base;

import com.baomidou.mybatisplus.plugins.Page;
import com.zyp.carweb.utils.RequestUtils;
import com.zyp.carweb.utils.ResponseUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class BaseController {

    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;



    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }

    public SSOUserInfo getSSOUser() {
        Subject currentAgent = SecurityUtils.getSubject();
        return (SSOUserInfo) currentAgent.getPrincipal();
    }

    protected int getCurrent(HttpServletRequest request) {
        String current = request.getParameter("pageNumber");
        if (StringUtils.isEmpty(current)) {
            return 1;
        }
        return Integer.parseInt(request.getParameter("pageNumber"));
    }

    protected int getSize(HttpServletRequest request) {
        String size = request.getParameter("pageSize");
        if (StringUtils.isEmpty(size)) {
            return 10;
        }
        return Integer.parseInt(request.getParameter("pageSize"));
    }
    protected <T> Page<T> getPage(Map<String, Object> data) {
        Page<T> page = new Page<>();
        String current = data.get("pageNumber")!=null?(String)data.get("pageNumber"):null;
        if (current != null) {
            page.setCurrent(Integer.parseInt(current));
        }
        String pageSize = data.get("pageSize")!=null?(String)data.get("pageSize"):null;
        if(pageSize!=null){
            page.setSize(Integer.parseInt(pageSize));
        }
        return page;
    }

public void removePageParam(Map<String, Object> params){
    params.remove("pageNumber");
    params.remove("pageSize");
    params.remove("limit");
    params.remove("offset");
    params.remove("order");

}
    protected void renderJson(HttpServletResponse response, Result result) {
        ResponseUtils.renderJson(response, result);
    }




    protected Long getUerId(HttpServletRequest request) {
        return (Long) request.getAttribute("userId");
    }

    protected String getOperateIp(HttpServletRequest request) {
        return RequestUtils.getIp(request);
    }




}
