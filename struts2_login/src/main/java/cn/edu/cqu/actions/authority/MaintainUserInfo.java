package cn.edu.cqu.actions.authority;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.cqu.domains.User;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
@Action(value="maintainUserInfo")
@Results({
    @Result(name = "getUserInfoResult", location = "userBasicInfo.jsp")
})
public class MaintainUserInfo extends ActionSupport {
	private User user;
	static Logger logger=LoggerFactory.getLogger(MaintainUserInfo.class);
//	public String execute() throws Exception {
//		System.out.println("main");
//        return SUCCESS;
//    }
	public String getUserInfo(){
		user=(User) ActionContext.getContext().getSession().get("currentuser");
		logger.debug("user[]"+user.getLoginName());
		return "getUserInfoResult";
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
