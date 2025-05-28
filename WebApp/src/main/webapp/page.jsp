<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@page import="javax.servlet.http.Cookie" %>

<html>
<%
    out.print("<body ");
    out.print("bgcolor = " + session.getAttribute("color"));
    out.print("></body");
%>
</html>
