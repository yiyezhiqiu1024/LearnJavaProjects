package com.sl.servlet;

import com.sl.bean.Customer;
import com.sl.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {

    private final CustomerDao dao = new CustomerDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.获取客户数据
        List<Customer> customers = dao.list();

        // 2.将客户数据存储到 request 中
        request.setAttribute("customers", customers);

        // 3.转发到 list.jsp 页面进行数据展示
        request.getRequestDispatcher("/page/list/index.jsp").forward(request, response);
    }
}
