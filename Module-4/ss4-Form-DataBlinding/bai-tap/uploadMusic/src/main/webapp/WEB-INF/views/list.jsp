<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 24/10/2022
  Time: 9:08 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/music/save">Add more</a>
<table border="1px solid">
  <tr>
    <th>Name</th>
    <th>Singer</th>
    <th>Kind</th>
    <th>Link</th>
  </tr>
  <c:forEach items="${musics}" var="music">
    <tr>
      <td>${music.nameSong}</td>
      <td>${music.singer}</td>
      <td>${music.type}</td>
      <td>${music.link}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
