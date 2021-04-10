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
        outHTML(request, response);
    }

    private void outHTML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1.设置请求数据的编码
        request.setCharacterEncoding("UTF-8");

        // 2.获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 3.设置响应的内容类型（MIMEType + 数据编码)
        response.setContentType("text/html;charset=UTF-8");

        // 4.获取输出流
        PrintWriter out = response.getWriter();

        // 5.判断用户名、密码是否正确（假设规定用户名密码都是123，才代表正确）
        if ("123".equals(username) && "123".equals(password)) {
            success(out);
        } else {
            faile(out);
        }
    }

    private void success(PrintWriter out) {
        out.write("<html>");
        out.write("<head>");
        out.write("<link rel=\"stylesheet\" href=\"http://localhost:8080/crm/page/login/index.css\">");
        out.write("</head>");
        out.write("<h1 style=\"color: blue; border: 1px solid black;\">登录成功</h1>");
        out.write("<ul>");
        out.write("<li>个人信息</li>");
        out.write("<li>修改密码</li>");
        out.write("<a href=\"http://localhost:8080/crm/page/login/index.html\">退出登录</a>");
        out.write("</ul>");
        out.write("<h2>客户列表</h2>");
        out.write("<table>");
        out.write("<thead>");
        out.write("<tr>");
        out.write("<th>姓名</th>");
        out.write("<th>电话</th>");
        out.write("<th>性别</th>");
        out.write("</tr>");
        out.write("</thead>");
        out.write("<tbody>");

        List<Customer> customers = getCustomers();
        for (Customer customer : customers) {
            out.write("<tr>");
            out.write("<td>" + customer.getName() + "</td>");
            out.write("<td>" + customer.getAge() + "</td>");
            out.write("<td>" + customer.getHeight() + "</td>");
            out.write("</tr>");
        }

        out.write("</tbody>");
        out.write("</table>");
        out.write("</body>");
        out.write("</html>");
    }

    private List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer("张三" + i, 15 + i, 155.0 + i);
            customers.add(customer);
        }
        return customers;
    }

    private void faile(PrintWriter out) {
        out.write("<h1 style=\"color: red; border: 1px solid black;\">登录失败</h1>");
        out.write("<ul>");
        out.write("<a href=\"http://localhost:8080/crm/page/login/index.html\">重新登录</a>");
        out.write("</ul>");
    }

    private void outPlain(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
