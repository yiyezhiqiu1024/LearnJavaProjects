package com.sl.servlet;

import com.sl.bean.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

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
        // 转发到 jsp 页面进行数据展示，用户请求的 URL 不会改变
        request.getRequestDispatcher("/page/profile/index.jsp").forward(request, response);
    }

}
