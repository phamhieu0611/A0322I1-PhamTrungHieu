<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 21/10/2022
  Time: 8:01 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bài 1</title>
</head>
<body>
<form:form action="update" method="post" modelAttribute="update">
        <table>
            <tr>
                <td><form:label path="language">Languages:</form:label></td>
                <td>
                    <form:select  path="languages">
                        <form:option value="NONE"> --SELECT--</form:option>
                        <form:option value="English">English</form:option>
                        <form:option value="Vietnamese">Vietnamese</form:option>
                        <form:option value="Japanese">Japanese</form:option>
                        <form:option value="Chinese">Chinese</form:option>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td><form:label path="pageSize">Page Size:</form:label></td>
                <td>Show <form:select  path="pageSize">
                    <form:option value="5">5</form:option>
                    <form:option value="10">10</form:option>
                    <form:option value="15">15</form:option>
                    <form:option value="25">25</form:option>
                    <form:option value="50">50</form:option>
                    <form:option value="100">100</form:option>
                </form:select>
                    emails per page
                </td>
            </tr>
            <tr>
                <td><form:label path="filter">Spams fillter</form:label></td>
                <td><form:checkbox path="filter" />Enables spams filter</td>
            </tr>
            <tr>
                <td><form:label path="signature">Spams fillter</form:label></td>
                <td><form:textarea path="signature" /></td>
            </tr>
            <tr>
                <td><form:button>Cancel</form:button></td>
                <td><form:button>Update</form:button></td>
            </tr>
        </table>
</form:form>
</body>
</html>
