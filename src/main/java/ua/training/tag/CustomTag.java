package ua.training.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CustomTag extends TagSupport{

    private String format;

    public void setFormat(String value){
        this.format = value;
    }

    @Override
    public int doStartTag() throws JspException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate today = LocalDate.now();
        String todayString = today.format(formatter);
        try{
            pageContext.getOut().print(todayString);
        } catch (IOException ex){
            ex.printStackTrace();
        }
        return SKIP_BODY;
    }
}
