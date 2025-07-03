
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@page import="javax.servlet.http.Cookie" %>

<html>
<%
    session.setAttribute("color","red");
%>
<a href="page.jsp">Go to page! </a>

<br /><br /><form name="Login" action="" method="post"><br />    Account: <input type="text" name="Account" size="10"><br/><br />    Password: <input type="password" name="Password" size="10"><br/><br />  <input type="submit" name="SubmitButton" value="Submit"><br /></form>

<br /><br /><form name="Login" action="welcome.jsp" method="post"><br />    Account: <input type="text" name="Account" size="10"><br/><br />    Password: <input type="password" name="Password" size="10"><br/><br />  <input type="submit" name="SubmitButton" value="Submit"><br /></form>
</html>

