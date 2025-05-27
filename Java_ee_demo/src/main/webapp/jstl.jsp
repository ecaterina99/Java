
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<body>

<c:out value="Hello from my JSTL tag"></c:out>
<c:if test="${2==2}">
    <c:out value="this is true">
    </c:out>
</c:if>

<c:set var="a" value="3"></c:set>
<c:set var="b" value="3"></c:set>

<c:if test="${a==b}">
    <c:out value="a = b">
    </c:out>
</c:if>


<c:forEach items="America, Canada, Mexico" var="item">
    <div style="border: 1px solid brown; padding: 3px; margin: 5px;">
        ${item}
    </div>
</c:forEach>


</body>
</html>
