<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/10/2022
  Time: 9:09 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="/music/save" method="post" modelAttribute="music">
    <fieldset>
        <legend>Add music</legend>
        <table>
            <tr>
                <td><form:label path="nameSong">Song name:</form:label></td>
                <td><form:input path="nameSong"/></td>
            </tr>
            <tr>
                <td><form:label path="singer">Song singer:</form:label></td>
                <td><form:input path="singer"/></td>
            </tr>
            <tr>
                <td><form:label path="type">Song kind:</form:label></td>
                <td><form:input path="type"/></td>
            </tr>
            <tr>
                <td><form:label path="link">Song link:</form:label></td>
                <td><form:input path="link"/></td>
            </tr>
            <tr>
                <td><form:button>Cancel</form:button></td>
                <td><form:button>Add</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
