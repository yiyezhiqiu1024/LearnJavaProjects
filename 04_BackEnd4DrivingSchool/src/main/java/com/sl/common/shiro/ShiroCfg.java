package com.sl.common.shiro;

import com.sl.common.prop.DsProperties;
import com.sl.filter.ErrorFilter;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroCfg {
    @Bean
    public Realm realm() {
       return new TokenRealm(new TokenMatcher());
    }

    /**
     * ShiroFilterFactoryBean用来告诉Shiro如何进行拦截
     * 1.拦截哪些URL
     * 2.每个URL需要进行哪些filter
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(Realm realm, DsProperties properties) {
        ShiroFilterFactoryBean filterBean = new ShiroFilterFactoryBean();

        // 安全管理器
        filterBean.setSecurityManager(new DefaultWebSecurityManager(realm));

        // 添加一些自定义Filter
        Map<String, Filter> filters = new LinkedHashMap<>();
        filters.put("token", new TokenFilter());
        filterBean.setFilters(filters);

        // 设置URL如何拦截
        Map<String, String> urlMap = new LinkedHashMap<>();
        // 验证码
        urlMap.put("/sysUsers/captcha", "anon");
        // 用户登录
        urlMap.put("/sysUsers/login", "anon");
        // swagger
        urlMap.put("/swagger*/**", "anon");
        urlMap.put("/v2/api-docs/**", "anon");
        // 全局Filter的异常处理
        urlMap.put(ErrorFilter.ERROR_URI, "anon");
        // 其他
        urlMap.put("/**", "token");
        filterBean.setFilterChainDefinitionMap(urlMap);

        return filterBean;
    }
}
