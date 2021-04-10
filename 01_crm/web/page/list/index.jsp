<%--
  Created by IntelliJ IDEA.
  User: Franklin
  Date: 2021/4/10
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.sl.bean.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>


<%-- 声明成员变量、方法 --%>
<%!
    private List<Customer> getCustomers() {
        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Customer customer = new Customer("张三" + i, 15 + i, 155.0 + i);
            customers.add(customer);
        }
        return customers;
    }
%>

<table>
    <thead>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>身高</th>
    </tr>
    </thead>
    <tbody>

    <%-- 嵌入Java代码 --%>
    <%
        List<Customer> customers = getCustomers();
        for (Customer customer : customers) {
    %>
    <tr>
        <td><%= customer.getName() %></td>
        <td><%= customer.getAge() %></td>
        <td><%= customer.getHeight() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>

</body>
</html>


