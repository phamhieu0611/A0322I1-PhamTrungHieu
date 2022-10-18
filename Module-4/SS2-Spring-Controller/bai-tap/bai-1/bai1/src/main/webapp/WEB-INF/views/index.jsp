<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/10/2022
  Time: 2:02 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/calculator" method="get">
  <input type="number" name="num1"/>
  <select name="operator">
    <option value="+">+</option>
    <option value="-">-</option>
    <option value="*">*</option>
    <option value="/">/</option>
  </select>
  <input type="number" name="num2"/>
  <input type="submit" value="Count">
  <h1>Result: ${result}</h1>
</form>
</body>
</html>
