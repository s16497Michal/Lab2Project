<%--
  Created by IntelliJ IDEA.
  User: Loevenheart
  Date: 2019-03-27
  Time: 22:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String backURL = "/";

    if (session.getAttribute("user") == null)
        response.sendRedirect(backURL);
%>

<%
    String backURL2 = "afterLogin/welcome_new.jsp";
    Boolean check = false;

    if (session.getAttribute("premium") == check)
        response.sendRedirect(backURL2);
%>
<html>
<head>
    <title>Witaj użytkowniku premium</title>
</head>
<body>
 <h1>Jesteś zalogowanym użytkownikiem premium!</h1>
</body>
</html>
