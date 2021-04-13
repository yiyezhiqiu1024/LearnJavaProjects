<%--
  Created by IntelliJ IDEA.
  User: Franklin
  Date: 2021/4/13
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:choose>
        <c:when test="${empty customer}"><title>添加客户</title></c:when>
        <c:otherwise><title>编辑客户</title></c:otherwise>
    </c:choose>
</head>
<body>

<form
    <c:choose>
        <c:when test="${empty customer}">action="/crm/customer/save"</c:when>
        <c:otherwise>action="/crm/customer/update"</c:otherwise>
    </c:choose>
        method="post">


    <c:if test="${not empty customer}">
        <%-- 隐藏域 --%>
        <input type="hidden" name="id" value="${customer.id}"/>
    </c:if>
    <div>姓名<input type="text" name="name" value="${customer.name}"/></div>
    <div>年龄<input type="text" name="age" value="${customer.age}"/></div>
    <div>身高<input type="text" name="height" value="${customer.height}"/></div>
    <div><button type="submit">
        <c:choose>
            <c:when test="${empty customer}">添加</c:when>
            <c:otherwise>更新</c:otherwise>
        </c:choose>
    </button></div>
</form>

</body>
</html>
