<%--
  Created by IntelliJ IDEA.
  User: Loevenheart
  Date: 2019-03-27
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nadawanie uprawnień</title>
</head>
<body>
<h1>Nadaj uprawnienia premium</h1><br/>
<form action="setAccess" method="post">
    <label>Nazwa użytkownika: <input type="text" name="username" id="username"></label><br/>
    <label><input type="submit" value="Nadaj/usuń uprawnienie"></label>
</form>
</body>
</html>
