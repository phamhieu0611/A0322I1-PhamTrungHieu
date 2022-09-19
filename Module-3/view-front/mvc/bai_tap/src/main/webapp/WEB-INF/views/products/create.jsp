<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19/09/2022
  Time: 10:57 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Add new product</h1>
<c:if test="${error != null}">
    <h2 style="color: red">${error}</h2>
</c:if>

<a href="/product">Return List</a>
<form action="/product" method="post">
    <table border="1">
        <tr>
            <td>ID</td>
            <td><input type="text" name="id" /></td>
        </tr>
        <tr>
            <td>Name</td>
            <td><input type="text" name="name" /></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input type="text" name="description" /></td>
        </tr>
        <tr>
            <td>Producer</td>
            <td><input type="description" name="producer" /></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price" /></td>
        </tr>
        <tr>
            <td>
                <input type="reset" value="Reset" />
            </td>
            <td>
                <input type="submit" value="Submit" />
            </td>
        </tr>
    </table>
    <input type="hidden" name="action" value="create" />
</form>
</body>
</html>
