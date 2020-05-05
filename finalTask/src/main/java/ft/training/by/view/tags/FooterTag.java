package ft.training.by.view.tags;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class FooterTag extends TagSupport {
    private String address;

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().write("<hr><center>Copyright 2020, ©Account</center><br>");
            pageContext.getOut().write("<center>" + address + "</center><br>");
        } catch (IOException e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        return EVAL_PAGE;
    }
}
