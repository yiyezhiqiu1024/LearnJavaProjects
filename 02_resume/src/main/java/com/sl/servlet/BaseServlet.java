package com.sl.servlet;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

public class BaseServlet extends HttpServlet {

    static {
        // null参数表示允许值为null
        DateConverter dateConverter = new DateConverter(null);
        dateConverter.setPatterns(new String[]{"yyyy-MM-dd"});
        ConvertUtils.register(dateConverter, Date.class);
    }

    /**
     * 当客户端发送的是GET请求，就会调用HttpServlet的doGet方法
     * @param request 用来接收客户端发送的数据
     * @param response 用来给客户端发送数据（响应）
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    /**
     * 当客户端发送的是GET请求，就会调用HttpServlet的doPost方法
     * @param request 用来接收客户端发送的数据
     * @param response 用来给客户端发送数据（响应）
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            // 利用方法名调用方法
            String uri = request.getRequestURI();
            String[] cmps = uri.split("/");
            String methodName = cmps[cmps.length - 1];
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
            forwardError(request, response, "访问路径有问题");
        }
    }

    protected void forwardError(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        request.setAttribute("error", error);
        request.getRequestDispatcher("/WEB-INF/page/error.jsp").forward(request, response);
    }
}
