<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.format.DateTimeFormatter"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<body>

<%
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    out.println(dtf.format(now));
%>

</body>
</html>
