package com.skxj.firstboot.service;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;

/**
 * Created by Snow on 7/19/2017.
 */

@Service
public class MyShiroRealm extends AuthorizingRealm {
    private static Logger logger = Logger.getLogger(MyShiroRealm.class);

    // 验证是否有操作权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermission("select");
        authorizationInfo.addStringPermission("userInsert");
        logger.info("验证是否有操作权限:"+ authorizationInfo.getRoles() );
        return authorizationInfo;
    }

    // 验证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String)authenticationToken.getPrincipal();
       // Object passWord = authenticationToken.getCredentials();
        logger.info("验证登录:"+authenticationToken.getCredentials());
        if(username == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username,"123", ByteSource.Util.bytes("Snow123"),this.getName());
        return authenticationInfo;
    }
}
