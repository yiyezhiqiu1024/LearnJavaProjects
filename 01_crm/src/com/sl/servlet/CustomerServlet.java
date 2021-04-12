package com.sl.servlet;

import com.sl.bean.Customer;
import com.sl.dao.CustomerDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/customer/*")
public class CustomerServlet extends HttpServlet {

    private final CustomerDao dao = new CustomerDao();

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
        try {
            // 利用方法名调用方法
            String uri = request.getRequestURI();
            String[] cmps = uri.split("/");
            String methodName = cmps[cmps.length - 1];
            Method method = getClass().getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();

            request.setAttribute("error", "访问路径有问题");
            request.getRequestDispatcher("/page/error.jsp").forward(request, response);
        }
    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1.获取客户数据
        List<Customer> customers = dao.list();

        // 2.将客户数据存储到 request 中
        request.setAttribute("customers", customers);

        // 3.转发到 list.jsp 页面进行数据展示
        request.getRequestDispatcher("/page/list/index.jsp").forward(request, response);
    }

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
