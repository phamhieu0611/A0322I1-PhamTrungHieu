<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/10/2022
  Time: 11:44 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Directory</title>
</head>
<body>
<form action="/directory/search" method="get">
    <input type="text" name="search"><br/>
    <input type="submit" value="Search">
    <h1>RESULT = ${result}</h1>
</form>
</body>
</html>
