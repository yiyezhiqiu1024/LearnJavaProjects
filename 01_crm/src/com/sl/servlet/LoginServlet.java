package com.sl.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
        // 1.设置请求数据的编码
        request.setCharacterEncoding("UTF-8");

        // 2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 3.设置响应的内容类型（MIMEType + 数据编码)
        response.setContentType("text/plain;charset=UTF-8");

        // 4.获取输出流
        PrintWriter out = response.getWriter();

        // 5.判断用户名、密码是否正确（假设规定用户名密码都是123，才代表正确）
        if ("123".equals(username) && "123".equals(password)) {
            out.write("登录成功");
        } else {
            out.write("登录失败");
        }
    }
}
