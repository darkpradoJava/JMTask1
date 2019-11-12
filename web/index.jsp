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
<!--<h2>Добавление пользователя:</h2>
<form action="/" method="POST">
    Login: <input type="text" name="login">
    Password: <input type="password" name="password">
    <input type="submit" value="добавить">
</form>
-->
<h2>Список пользователей:</h2>
<table border="1">
    <c:forEach items="${requestScope.list}" var="user">
        <tr>
            <td> ${user.id} </td>
            <td> ${user.login} </td>
            <td> ${user.password} </td>
        </tr>
    </c:forEach>
</table>

<a href="/time">Узнать текущее время сервера</a>
</body>
</html>
