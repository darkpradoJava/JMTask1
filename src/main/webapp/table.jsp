<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--
  Created by IntelliJ IDEA.
  User: darkprado
  Date: 07.11.2019
  Time: 18:20
  To change this template use File | Settings | File Templates.
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
--%>

<html>
<head>
    <title>preProjTask1</title>
</head>
<body>
<h1>Задача 1</h1>
<h3>Список пользователей:</h3>
<table width="500px" cellspacing="0" cellpadding="0" border="1">
    <tr>
        <th>ID</th>
        <th>Login</th>
        <th>Password</th>
    </tr>
    <c:forEach items="${requestScope.list}" var="user">
        <tr>
            <td> ${user.id} </td>
            <td> ${user.login} </td>
            <td> ${user.password} </td>
        </tr>
    </c:forEach>
</table>
<p>Добавить пользователя:</p>
<form action="" method="POST">
    Login: <input type="text" name="login">
    Password: <input type="password" name="password">
    <input type="submit" value="добавить">
</form>
<p>Удалить пользователя по id:</p>
<form action="./delete" method ="POST">
    Id: <input type="number" name="id">
    <input type="submit" value="удалить">
</form>
<p>Изменить пользователя по id:</p>
<form action="./update" method ="POST">
    Id: <input type="number" name="id">
    Login: <input type="text" name="login">
    Password: <input type="password" name="password">
    <input type="submit" value="изменить">
</form>
</body>
</html>
