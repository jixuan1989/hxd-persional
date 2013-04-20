package cn.edu.cqu.actions;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.cqu.domains.ScholarshipType;
import cn.edu.cqu.domains.User;
import cn.edu.cqu.domains.UserType;

import com.opensymphony.xwork2.ActionSupport;

@Actions({
	//这里的url是去掉namespace之后的。。
	@Action(value="register")//这里写的是action的名字，不需要加后缀
})

@Results({
	@Result(name =  com.opensymphony.xwork2.Action.SUCCESS, location = "lg/welcome",type="redirectAction"),
	@Result(name =  com.opensymphony.xwork2.Action.INPUT, location = "register.jsp"),
	@Result(name =  com.opensymphony.xwork2.Action.ERROR, location = "register.jsp")
})
public class RegisterAction extends ActionSupport {

	private static final long serialVersionUID = 8000933993040673959L;
	private User user;
	private String inviteCode;
	static Logger logger=LoggerFactory.getLogger(LoginAction.class);
	
	public String execute() throws Exception {
		logger.debug("register.jsp");
		if (isInvalid()) {
			
		}
		return null;
	}
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	public String getInviteCode() {
		return inviteCode;
	}

	public void setInviteCode(String inviteCode) {
		this.inviteCode = inviteCode;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	


}
