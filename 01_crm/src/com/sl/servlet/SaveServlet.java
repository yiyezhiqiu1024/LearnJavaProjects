package com.sl.servlet;

import com.sl.bean.Customer;
import com.sl.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/save")
public class SaveServlet extends HttpServlet {

    private final CustomerDao dao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        // 获取请求参数
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String height = request.getParameter("height");

        // 转成Java Bean对象
        Customer customer = new Customer(name, Integer.valueOf(age), Double.valueOf(height));
        dao.save(customer);

        // 重定向
        // 状态码：302
        // response.setStatus(302);
        // 响应头Location：/crm/list
        // response.setHeader("Location", "/crm/list");
        response.sendRedirect("/crm/list");
    }
}
