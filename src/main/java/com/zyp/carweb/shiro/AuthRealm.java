package com.zyp.carweb.shiro;

import com.zyp.carweb.base.SSOUserInfo;
import com.zyp.carweb.model.User;
import com.zyp.carweb.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * yangyang on 2017/12/31.
 */
public class AuthRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;


    //认证.登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken utoken = (UsernamePasswordToken) token;//获取用户输入的token
        String userName = utoken.getUsername();
        User user = new User();
        user.setLoginName(userName);
        user = userService.findByUser(user);
        if (user == null) {
            return null;
        } else {
            SSOUserInfo ssoUser = new SSOUserInfo();
            BeanUtils.copyProperties(user, ssoUser, new String[]{});
            SimpleAuthenticationInfo info
                    = new SimpleAuthenticationInfo(ssoUser, user.getPassWord(), getName());
            return info;
        }
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
        if (principal == null) {
            throw new AuthorizationException("PrincipalCollection method argument cannot be null.");
        }

        SSOUserInfo shiroAgent = (SSOUserInfo) principal.fromRealm(getName()).iterator().next();
        int userId = shiroAgent.getId();
        SimpleAuthorizationInfo info = null;
        return info;
    }
}
