package com.sl.servlet;

import com.sl.bean.User;
import com.sl.service.UserService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet<User> {

    public void admin(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        User user = new User();
        BeanUtils.populate(user, request.getParameterMap());
        user = ((UserService) service).get(user);
        if (user != null) { // 用户名、密码正确
            redirect(request, response, "user/admin");
        } else { // 用户名、密码有问题
            forwardError(request, response, "邮箱或密码不正确");
        }
    }
}
