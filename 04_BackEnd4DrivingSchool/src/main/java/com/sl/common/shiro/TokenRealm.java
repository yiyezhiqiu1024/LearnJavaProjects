package com.sl.common.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class TokenRealm extends AuthorizingRealm {

    public TokenRealm(TokenMatcher matcher) {
        super(matcher);
    }

    /**
     * 当主体（subject）要进行角色\权限判断时，就会调用
     *
     * 开发者需要在这个方法中干啥？【一般】
     * 根据用户名查询用户的角色\权限信息
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
       return null;
    }

    /**
     * 当主体（subject）要进行认证是，就会调用
     *
     * 开发者需要在这个方法中干啥？【一般】
     * 根据用户名查询用户的具体信息（用户名、密码）
     *
     * @param authenticationToken subject.login()登录时传进来的token
     * @return 用户名的具体信息
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        return null;
    }
}
