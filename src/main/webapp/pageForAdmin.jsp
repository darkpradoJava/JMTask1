<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: darkprado
  Date: 02.12.2019
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>

<html>
<head>
    <title>Admin</title>
</head>
<body>
<h3>Список пользователей:</h3>
<table width="500px" cellspacing="0" cellpadding="0" border="1">
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
        <th>Role</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="user">
        <tr>
            <td> ${user.id} </td>
            <td> ${user.login} </td>
            <td> ${user.password} </td>
            <td>${user.role}</td>
        </tr>
    </c:forEach>
</table>
<p>Добавить пользователя:</p>
<form action="/admin/add" method="POST">
    Login: <input type="text" name="login">
    Password: <input type="password" name="password">
    Role: <input type="radio" name="role" value="user" checked> user
    <input type="radio" name="role" value="admin"> admin
    <input type="submit" value="добавить">
</form>
<p>Удалить пользователя по id:</p>
<form action="/admin/delete" method ="POST">
    Id: <input type="number" name="id">
    <input type="submit" value="удалить">
</form>
<p>Изменить пользователя по id:</p>
<form action="/admin/update" method ="POST">
    Id: <input type="number" name="id">
    Login: <input type="text" name="login">
    Password: <input type="password" name="password">
    <input type="submit" value="изменить">
</form>
</body>
</html>
