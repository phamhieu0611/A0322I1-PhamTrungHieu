<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 18/10/2022
  Time: 2:06 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/save" method="post">
  <input type="checkbox" id="vehicle1" name="Lettuce" value="Lettuce">
  <label for="vehicle1">Lettuce</label><br/>
  <input type="checkbox" id="vehicle2" name="Tomato" value="Tomato">
  <label for="vehicle2">Tomato</label><br/>
  <input type="checkbox" id="vehicle3" name="Mustard" value="Mustard">
  <label for="vehicle3">Mustard</label><br/>
  <input type="checkbox" id="vehicle4" name="Sprouts" value="Sprouts">
  <label for="vehicle4">Sprouts</label><br/>
  <input type="submit" value="Save"><br/>
  <h1>RESULT = ${giaVi}</h1>
</form>
</body>
</html>
