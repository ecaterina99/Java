<%@page import="java.util.Random"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>

<html>

<head>

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Random</title>

</head>

<body>

<%
    out.println("Random number: " + new Random().nextInt());
%>

</body>

</html>