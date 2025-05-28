
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="javax.servlet.http.Cookie" %>

<html>
<%
    session.setAttribute("color","red");
%>
<a href="page.jsp">Go to page! </a>
</html>