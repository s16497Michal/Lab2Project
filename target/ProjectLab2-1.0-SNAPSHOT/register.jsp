<%--
  Created by IntelliJ IDEA.
  User: Loevenheart
  Date: 2019-03-27
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rejstracja</title>
</head>
<body>
<h1>Rejstracja</h1><br/>
<form action="newacct" method="post">
    <label>Nazwa użytkownika: <input type="text" id="username" name="username" value="michu"></label><br/>
    <label>Hasło: <input type="password" id="pass" name="pass" value="michu"></label><br/>
    <label>Potwierdź hasło: <input type="password" id="confrimPass" name="confrimPass" value="michu"></label><br/>
    <label>Email: <input type="text" id="email" name="email" value="michu@michu.com"></label><br/>
    <label><input type="submit" value="Zarejstruj się"></label><br/>
</form>
</body>
</html>
