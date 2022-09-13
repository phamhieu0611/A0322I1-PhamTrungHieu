<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 13/09/2022
  Time: 8:21 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/calculator" method="get">
    Nhập vào số đầu tiên: <input type="number" name="so1"><br/>
    Nhập vào số thứ hai: <input type="number" name="so2"><br/>
    Phép toán: <select name="operator">
    <option value="+">Cộng</option>
    <option value="-">Trừ</option>
    <option value="*">Nhân</option>
    <option value="/">Chia</option>
  </select><br/>
    <input type="submit" value="Tính toán">
  </form>
  </body>
</html>
