package com.zyp.carweb.controller;

import com.zyp.carweb.base.MessageInfo;
import com.zyp.carweb.base.Result;
import com.zyp.carweb.factory.CustomerFactory;
import com.zyp.carweb.factory.LoginLog;
import com.zyp.carweb.factory.LoginLogFactory;
import com.zyp.carweb.factory.MerchantFactory;
import com.zyp.carweb.model.User;
import com.zyp.carweb.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
public class LoginController {

    @Autowired
    public UserService userService;

    /**
     * 登录
     * String signcode(参数先去掉)
     *
     * @param user
     * @return
     */
    @RequestMapping("/doLogin")
    public MessageInfo login(HttpServletRequest request, HttpServletResponse response, User user) {
        String inputPwd = DigestUtils.md5Hex(user.getPassWord());
        log.info("输入密码为：{},加密后为{}",user.getPassWord(),inputPwd);
        user.setPassWord(null);
        user = userService.findByUser(user);
        if (user == null || user.getId() == null) {
            return new MessageInfo("没有该用户！", -2);
        }
        if (!inputPwd.equals(user.getPassWord())) {
            return new MessageInfo("密码错误！", -4);
        }
        LoginLogFactory factory = new LoginLogFactory();
        LoginLog loginLog;
        if(user.getUserType().equals(1)){
            loginLog = factory.getLoginLog("customer");
        }else{
            //商家
            loginLog = factory.getLoginLog("merchant");
        }
        loginLog.loginLog(user);
        String errorMessage = "";
        request.setAttribute("user", user);
        Subject subjectUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), inputPwd);
        token.setRememberMe(true);
        try {
            subjectUser.login(token);
            subjectUser.getSession().setAttribute("user", user);
            request.setAttribute("user", user);
            return new MessageInfo("登录成功", 0);
        } catch (UnknownAccountException uae) {
            errorMessage = "";
            log.info(errorMessage);
            return new MessageInfo(uae.getMessage(), 3);
        } catch (IncorrectCredentialsException ice) {
            return new MessageInfo("密码错误", 3);
        } catch (LockedAccountException lae) {
            return new MessageInfo(lae.getMessage(), 3);
        } catch (AuthenticationException e) {
            token.clear();
            return new MessageInfo(e.getMessage(), 3);
        }
    }


    @RequestMapping("/reg")
    public MessageInfo reg(HttpServletRequest request, HttpServletResponse response, User user) {
        String inputPwd = DigestUtils.md5Hex(user.getPassWord());
        user.setPassWord(null);
        User dbUser = userService.findByUser(user);
        if (dbUser != null ) {
            return new MessageInfo("用户已存在！", -2);
        }
        user.setUserName(user.getLoginName());
        user.setPassWord(inputPwd);
        userService.insertSelective(user);
        return new MessageInfo("注册成功", 0);
    }
}
