<%--
  Created by IntelliJ IDEA.
  User: Loevenheart
  Date: 2019-03-27
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Witaj adminie</title>
</head>
<body>
<h1>Witaj adminie!</h1><br/>
<form action="user_access.jsp">
    <input type="submit" value="Przejdź do nadawania uprawnień">
</form>
<form action="showuseres" method="post">
    <input type="submit" value="Pokaż użytkowników">
</form>
</body>
</html>
