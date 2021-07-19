package com.sl.common.shiro;

import com.sl.common.cache.Caches;
import com.sl.common.util.JsonVos;
import com.sl.pojo.result.CodeMsg;
import org.apache.shiro.web.filter.AccessControlFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class TokenFilter extends AccessControlFilter {
    public static final String HEADER_TOKEN = "Token";

    /**
     * 当请求被TokenFilter拦截时，就会调用这个方法
     * 可以在这个方法中做初步判断
     *
     * 如果返回true：允许访问。可以进入下一个链条调用（比如Filter、拦截器、控制器等）
     * 如果返回false：不允许访问。会进入onAccessDenied方法，不会进入下一个链条调用（比如Filter、拦截器、控制器等）
     */
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object o) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        /**
         * 在前后端分离项目中，由于跨域，会导致复杂请求，即会发送预检请求（preflighted request）
         * 这样会导致在GET／POST等请求之前会先发一个OPTIONS请求
         * 放行所有的OPTIONS请求
         */
        return "OPTIONS".equals(request.getMethod().toUpperCase());
    }

    /**
     * 当isAccessAllowed返回false时，就会调用这个方法
     * 在这个方法中进行token的校验
     *
     * 如果返回true：允许访问。可以进入下一个链条调用（比如Filter、拦截器、控制器等）
     * 如果返回false：不允许访问。不会进入下一个链条调用（比如Filter、拦截器、控制器等）
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        // 取出Token
        String token = request.getHeader(HEADER_TOKEN);

        // 如果没有Token
        if (token == null) {
            return JsonVos.raise(CodeMsg.NO_TOKEN);
        }

        // 如果Token过期了
        if (Caches.getToken(token) == null) {
            return JsonVos.raise(CodeMsg.TOKEN_EXPIRED);
        }

        return true;
    }
}
