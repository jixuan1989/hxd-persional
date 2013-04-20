package cn.edu.cqu.actions;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.edu.cqu.dao.DaoUtils;
import cn.edu.cqu.domains.User;
import cn.edu.cqu.utils.MD5;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
//@InterceptorRefs({
//	//@InterceptorRef("validation"), 
//	//@InterceptorRef("defaultStack")}
//)
@Actions({
	//这里的url是去掉namespace之后的。。
	@Action(value="login")//这里写的是action的名字，不需要加后缀
	//,
	//@Action("/")
})

@Results({
	@Result(name =  com.opensymphony.xwork2.Action.SUCCESS, location = "lg/welcome",type="redirectAction"),
	@Result(name =  com.opensymphony.xwork2.Action.INPUT, location = "login.jsp"),
	@Result(name =  com.opensymphony.xwork2.Action.ERROR, location = "login.jsp")
})
public class LoginAction extends ActionSupport {
	private static final long serialVersionUID = 1030294046920869257L;
	private String username;
	private String password;
	static Logger logger=LoggerFactory.getLogger(LoginAction.class);
	// 处理用户请求的execute方法
	public String execute() throws Exception {
		logger.debug("login.jsp");
		if (isInvalid(getUsername()))
			return INPUT;

		if (isInvalid(getPassword()))
			return INPUT;
		EntityManager em=DaoUtils.getEntityManager();
		TypedQuery<User> query=em.createQuery("from User where loginName=?1 and pwd=?2",User.class);
		query.setParameter(1, username);
		query.setParameter(2, password);
		User user=null;
		try{
			user=query.getSingleResult();
		}catch (javax.persistence.NoResultException e){
			addActionError("Invalid user name or password! Please try again!"); 
			logger.info("wrong user:"+getUsername() + "----" + getPassword());
			return ERROR;
		}finally{
			DaoUtils.closeEntityManager(em);
		}
		if (user !=null) {
			// 通过ActionContext对象访问Web应用的Session
			String md5pass=MD5.getMD5(password.getBytes());
			ActionContext.getContext().getSession().put("pass",md5pass );
			logger.info(getUsername() + "----" + md5pass);
			user.setPwd(md5pass);
			ActionContext.getContext().getSession().put("currentuser",user);
			return SUCCESS;
		} else {
			addActionError("Invalid user name or password! Please try again!"); 
			logger.info("wrong user:"+getUsername() + "----" + getPassword());
			return ERROR;
		}
	}

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	public String add() {
		return SUCCESS;
	}

	public String show() {
		return SUCCESS;
	}

	public String qurey() {
		return SUCCESS;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
