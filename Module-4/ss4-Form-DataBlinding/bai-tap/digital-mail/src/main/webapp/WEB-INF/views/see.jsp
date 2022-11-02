<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21/10/2022
  Time: 8:23 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
    <style>
        td{
            align-content: center;
        }
    </style>
</head>
<body>
<table border="1px solid">
    <tr>
        <th>ID</th>
        <th>Filter</th>
        <th>page size</th>
        <th>languages</th>
        <th>signature</th>
        <th>Actions</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
        <td>${product.id}</td>
        <td>${product.filter}</td>
        <td>${product.pageSize}</td>
        <td>${product.languages}</td>
        <td>${product.signature}</td>
        <td>
            <a href="settings.jsp">Edit</a>
        </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
