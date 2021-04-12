<%@ page import="java.io.PrintWriter" %><%--
  Created by IntelliJ IDEA.
  User: Franklin
  Date: 2021/4/10
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心</title>
</head>
<body>

<%-- 嵌入Java代码 --%>
<%
    // 1.设置请求数据的编码
    request.setCharacterEncoding("UTF-8");

    // 2.获取请求参数
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    // 3.设置响应的内容类型（MIMEType + 数据编码)
    response.setContentType("text/html;charset=UTF-8");

    // 4.判断用户名、密码是否正确（假设规定用户名密码都是123，才代表正确）
    if ("123".equals(username) && "123".equals(password)) {
%>
<h1 style="color: blue; border: 1px solid black;">登录成功</h1>
<ul>
    <li>个人信息</li>
    <li>修改密码</li>
    <a href="http://localhost:8080/crm/page/login/index.html">退出登录</a>
</ul>
<a href="/crm/customer/list">客户列表</a>
<%
    } else {
%>
<h1 style="color: red; border: 1px solid black;">登录失败</h1>
<a href="http://localhost:8080/crm/page/login/index.html">重新登录</a>
<%
    }
%>

</body>
</html>

