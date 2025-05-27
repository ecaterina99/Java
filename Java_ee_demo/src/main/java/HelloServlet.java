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
        /* String msg = LocalDateTime.now().toString();

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

         */

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        Integer age;

        try {
            age = Integer.parseInt(request.getParameter("age"));
        } catch (Exception e) {
            response.sendRedirect("index.html");
            return;
        }

        if (age > 17) {
            out.println("<html><body>");
            out.println("<h1>You entered</h1>" +
                    "<p>Your first name: " + firstName + "</p>" +
                    "<p>Your last name: " + lastName + "</p>" +
                    "<p>Your age: " + age + "</p>");
            out.println("</body></html>");
        } else {
            out.println("<h1>Sorry, you must be older!</h1>");
        }
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
