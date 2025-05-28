import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.List;

@WebServlet(urlPatterns = {"/Servlet"}, description = "form")
@MultipartConfig
public class Servlet extends HttpServlet {

    enum Gender {
        male, female
    }

    void processRequest(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = null;
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
                        }  else if (item.getFieldName().equals("date")) {
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        date = LocalDate.parse(item.getString(), formatter);
                        } else if (item.getFieldName().equals("plan")) {
                            plan = item.getString();
                        } else if (item.getFieldName().equals("agree")) {
                            if(item.getString().equals("0")){
                                agree = false;
                            }else {
                                agree = true;
                            }
                        }

                    } else {
                        item.write(new File(item.getName()));
                    }
                }
            }
            out.println("<h1>You entered</h1>");
            out.println("<p> Your first name is " + first_name + "</p>");
            out.println("<p> Your last name is " + last_name + "</p>");
            assert gender != null;
            out.println("<p>Your gender is: " + gender.toString() + "</p>");
            out.println("<p>Your plan is: " + plan + "</p>");
            assert date != null;
            out.println("<p>Your date of birth is: " + date + "</p>");
            if (agree) {
                out.println("<p>You agree to the plan!</p>");
            } else {
                out.println("<p>You don't agree to the plan!</p>");
            }

        } catch (IOException | FileUploadException e) {
            System.err.println("Error in processRequest: " + e.getMessage());
            e.printStackTrace();

        } catch (Exception e) {
            throw new RuntimeException(e);
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
        return "Form processing servlet";
    }
}
