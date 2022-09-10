<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 09/09/2022
  Time: 8:04 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>login</title>
    <style>
      .login{
        height: 180px;
        width: 230px;
        margin: 0;
        padding: 10px;
        border: 1px #ccc solid;
      }
      .login input{
        padding: 5px;
        margin: 5px;
      }
    </style>
  </head>
  <body>
  <form method="post" action="/a">
    <div class="login">
      <h2>Login</h2>
      <input type="text" name="username" size="30" placeholder="username">
      <input type="text" name="password" size="30" placeholder="password">
      <input type="submit" value="Sign in">
    </div>
  </form>
  </body>
</html>
