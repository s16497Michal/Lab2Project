<%--
  Created by IntelliJ IDEA.
  User: Loevenheart
  Date: 2019-03-27
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Logowanie</title>
</head>
<body>
<h1>Logowanie</h1><br/>
<form action="goInside" method="post">
    <label>Nazwa użytkownika<input type="text" name="username" id="username"></label><br/>
    <label>Hasło<input type="password" name="pass" id="pass"></label><br/>
    <label><input type="submit" value="Zaloguj się"></label><br/>
</form>
</body>
</html>
