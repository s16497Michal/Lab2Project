<%--
  Created by IntelliJ IDEA.
  User: Loevenheart
  Date: 2019-03-27
  Time: 22:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String backURL = "/";

    if (session.getAttribute("user") == null)
        response.sendRedirect(backURL);
%>
<html>
<head>
    <title>Witaj</title>
</head>
<body>
    <h1>Witaj użytkowniku!</h1><br/>
    <form method="post" action="go-to-premium">
        <input type="submit" value="Przejdź do premium">
    </form>
</body>
</html>
