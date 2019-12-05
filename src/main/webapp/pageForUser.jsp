<%--
  Created by IntelliJ IDEA.
  User: darkprado
  Date: 02.12.2019
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>
</head>
<body>
    <p>Your login: ${requestScope.login}<br>
    Your password: ${requestScope.password}<br>
    You is ${requestScope.role}</p>
</body>
</html>
