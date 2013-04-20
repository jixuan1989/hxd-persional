package cn.edu.cqu.actions.authority;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 展示没有使用
 * <code>Set welcome message.</code>
 */
@Action(value="welcome")
@Results({
    @Result(name =  com.opensymphony.xwork2.Action.SUCCESS, location = "main.jsp"),
    @Result(name =  com.opensymphony.xwork2.Action.INPUT, location = "login.jsp"),
    @Result(name =  com.opensymphony.xwork2.Action.ERROR, location = "login.jsp")
})
public class WelcomeAction extends ActionSupport {
	Logger logger=LoggerFactory.getLogger(WelcomeAction.class);
	public String execute() throws Exception {
		//System.out.println("welcome");
		logger.debug("login back page.");
        setMessage(getText(MESSAGE));
        return SUCCESS;
    }

    /**
     * Provide default valuie for Message property.
     */
    public static final String MESSAGE = "hello.message";

    /**
     * Field for Message property.
     */
    private String message;

    /**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on HelloWorld page.
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
