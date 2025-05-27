import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = {"/HelloServlet"}, description = "add two numbers")
public class HelloServlet extends HttpServlet {

    void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        // String msg = LocalDateTime.now().toString();

        String msg = null;

        try {
            int a, b, c;
            a = Integer.parseInt(request.getParameter("a"));
            b = Integer.parseInt(request.getParameter("b"));
            c = a + b;

            msg = a + " + " + b + " = " + c;
        } catch (NumberFormatException e) {
            msg = e.getMessage();
        }

        out.println("<html><body><h2>");
        out.println(msg);
        out.println("</h2></body></html>");

    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}


/* Tags JSP
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


 */