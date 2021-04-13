package com.sl.servlet;

import com.sl.bean.Customer;
import com.sl.dao.CustomerDao;
import org.apache.commons.beanutils.BeanUtils;

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

    public void save(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取请求参数
        Customer customer = new Customer();
        BeanUtils.populate(customer, request.getParameterMap());

        if ( dao.save(customer)) {
            response.sendRedirect("/crm/customer/list");
        } else {
            forwardError(request, response, "保存客户信息失败");
        }
    }

    /**
     * 更新 customer
     */
    public void update(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取请求参数
        Customer customer = new Customer();
        BeanUtils.populate(customer, request.getParameterMap());

        if (dao.update(customer)) {
            response.sendRedirect("/crm/customer/list");
        } else {
            forwardError(request, response, "更新客户信息失败");
        }
    }

    public void remove(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取请求参数
        Integer id = Integer.valueOf(request.getParameter("id"));

        if (dao.remove(id)) {
            response.sendRedirect("/crm/customer/list");
        } else {
            forwardError(request, response, "删除客户信息失败");
        }
    }

    public void edit(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 获取请求参数
        Integer id = Integer.valueOf(request.getParameter("id"));
        Customer customer = dao.find(id);
        request.setAttribute("customer", customer);
        request.getRequestDispatcher("/page/customer/save.jsp").forward(request, response);

    }

    public void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 1.获取客户数据
        List<Customer> customers = dao.list();

        // 2.将客户数据存储到 request 中
        request.setAttribute("customers", customers);

        // 3.转发到 list.jsp 页面进行数据展示
        request.getRequestDispatcher("/page/customer/list.jsp").forward(request, response);
    }

    private void forwardError(HttpServletRequest request, HttpServletResponse response, String error) throws ServletException, IOException {
        request.setAttribute("error", error);
        request.getRequestDispatcher("/page/error.jsp").forward(request, response);
    }



}
