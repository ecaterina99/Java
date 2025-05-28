import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = {"/Servlet2"}, description = "form")
@MultipartConfig
public class Servlet2 extends HttpServlet {

    enum Gender {
        male, female
    }

    void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out=null;
        try {
            String first_name = "";
            String last_name = "";
            String plan = "";
            Gender gender = null;
            LocalDate date = null;
            boolean agree = false;

            out = response.getWriter();
            if (ServletFileUpload.isMultipartContent((javax.servlet.http.HttpServletRequest) request)) {

                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);

                List items = upload.parseRequest((javax.servlet.http.HttpServletRequest) request);
                Iterator itr = items.iterator();

                while (itr.hasNext()) {

                    FileItem item = (FileItem) itr.next();
                    if (item.isFormField()) {

                        //logic
                        if (item.getFieldName().equals("first_name")) {
                            first_name = item.getString();
                        } else if (item.getFieldName().equals("last_name")) {
                            last_name = item.getString();
                        } else if (item.getFieldName().equals("gender")) {
                            gender = Gender.valueOf(item.getString());
                        } else if (item.getFieldName().equals("date")) {
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            date = LocalDate.parse(item.getString(), formatter);
                        } else if (item.getFieldName().equals("plan")) {
                            plan = item.getString();
                        } else if (item.getFieldName().equals("agree")) {
                            String agreeStr = item.getString("UTF-8");
                            agree = "on".equals(agreeStr) || "true".equals(agreeStr) || "1".equals(agreeStr);
                        }

                    } else {
                        if (item.getName() != null && !item.getName().isEmpty()) {
                            try {
                                item.write(new File("upload_" + item.getName()));
                            } catch (Exception e) {
                                System.out.println("error uploading file " + e.getMessage());
                            }
                        }
                    }
                }
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset='UTF-8'>");
            out.println("<title>Form Results</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>You entered</h1>");
            out.println("<p> Your first name is " + first_name + "</p>");
            out.println("<p> Your last name is " + last_name + "</p>");
            assert gender != null;
            out.println("<p>Your gender is: " + gender.toString() + "</p>");
            out.println("<p>Your plan is: " + plan + "</p>");
            assert date != null;
            out.println("<p>Your date of birth is: " + date.toString() + "</p>");
            if (agree) {
                out.println("<p>You agree to the plan!</p>");
            } else {
                out.println("<p>You don't agree to the plan!</p>");
            }
            out.println("<br><a href='index.html'>Go back to form</a>");
            out.println("</body>");
            out.println("</html>");

        } catch (IOException | FileUploadException e) {
            System.err.println("Error in processRequest: " + e.getMessage());
            e.printStackTrace();

            if (out != null) {
                out.println("<!DOCTYPE html>");
                out.println("<html><body>");
                out.println("<h1>Ошибка обработки формы</h1>");
                out.println("<p>Произошла ошибка при обработке вашего запроса.</p>");
                out.println("<p>Детали ошибки: " + e.getMessage() + "</p>");
                out.println("<a href='index.html'>Вернуться к форме</a>");
                out.println("</body></html>");
            }
        } catch (Exception e) {
            System.err.println("Неожиданная ошибка: " + e.getMessage());
            e.printStackTrace();

            if (out != null) {
                out.println("<!DOCTYPE html>");
                out.println("<html><body>");
                out.println("<h1>Неожиданная ошибка</h1>");
                out.println("<p>Произошла неожиданная ошибка.</p>");
                out.println("<a href='index.html'>Вернуться к форме</a>");
                out.println("</body></html>");
            }
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
        public String getServletInfo () {
            return "Form processing servlet";
        }
    }
