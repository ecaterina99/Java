<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.LocalDate" %>
<!--%@page contentType="text/html" pageEncoding="UTF8"%-->
<html>
<body>

<%-- JSP comment --%>

<%-- JSP code Java --%>
<%!
    public String hello(){
        return "hello world!";
    }

    class User  {
        public int id;
        public String fName;
        public String lName;

        public User(int id, String fName, String lName)  {
            this.id = id;
            this.fName = fName;
            this.lName = lName;
        }
    }

    User[] users = {
            new User(1, "Peter", "Jones"),
            new User(2, "Sarah", "Simmons"),
            new User(3, "Ruth", "Davis")
    };
%>


<table border="1">
    <tr>
        <td>id</td>
        <td>First name</td>
        <td>Last name</td>
    </tr>
    <%
        for(int i = 0; i < users.length; i++) {
    %>
    <tr>
        <td><%= users[i].id %></td>
        <td><%= users[i].fName %></td>
        <td><%= users[i].lName %></td>
    </tr>
    <%
        }
    %>
</table>



<%-- JSP current date --%>
<%
    out.println(java.time.LocalDate.now());
    out.println(hello());
%>

<%-- JSP expression only 1 line--%>
<%= hello()%>

</body>
</html>

<!-- index.html
<html>
<body>
<form action="HelloServlet" method="post">
    <input type="text"name="a">
    <br>
    <input type="text"name="b">
    <br>
    <input type="submit"value="add">
</form>

</body>
</html>
-->

