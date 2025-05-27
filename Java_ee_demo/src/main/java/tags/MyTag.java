package tags;

import jakarta.servlet.jsp.JspException;
import jakarta.servlet.jsp.JspWriter;
import jakarta.servlet.jsp.PageContext;
import jakarta.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class MyTag extends SimpleTagSupport {
    private String color;
    private int font_size;
    private boolean is_uppercase;


    public void setIs_uppercase(boolean isUpperCase) {
        this.is_uppercase = isUpperCase;
    }

    public void setFont_size(int font_size) {
        this.font_size = font_size;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public boolean isIs_uppercase() {
        return is_uppercase;
    }

    public String getColor() {
        return color;
    }

    public int getFont_size() {
        return font_size;
    }

    //crearea tagului
    @Override
    public void doTag() throws JspException, IOException {
        try {
            PageContext pageContext = (PageContext) getJspContext();
            JspWriter out = pageContext.getOut();

            String style = "";
            if (is_uppercase) {
                style = "style=\"text-transform: uppercase; font-size:" + font_size + "px; color: " + color + ";\"";
            } else {
                style = "style=\"font-size:" + font_size + "px; color: " + color + ";\"";
            }
            out.print("<p " + style + ">");

            getJspBody().invoke(out);

            out.print("</p>");
        } catch (IOException e) {
            throw new JspException("Error in TextFormatHandler " + e);
        }
    }

}

