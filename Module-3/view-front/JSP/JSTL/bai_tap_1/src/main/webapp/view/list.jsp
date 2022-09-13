<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 12/09/2022
  Time: 8:49 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer List</title>

</head>
<body>
<div style="align-content: center">
    <h1>Danh sách khách hàng</h1>
    <table>
        <tr>
            <th>STT</th>
            <th>Tên</th>
            <th>Ngày Sinh</th>
            <th>Địa chỉ</th>
            <th>Ảnh</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="status">
            <tr>
                <td>${status.count}</td>
                <td>${customer.getName()}</td>
                <td>${customer.getBirthDay()}</td>
                <td>${customer.getAddress()}</td>
                <td>
                    <img width="95" height="115" src="${customer.getImage()}" alt="image">
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
