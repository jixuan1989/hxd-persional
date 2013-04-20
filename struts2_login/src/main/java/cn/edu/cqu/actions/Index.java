package cn.edu.cqu.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Results({
//        @Result(name = Action.SUCCESS, location = "${redirectName}", type = "redirectAction")
//})
@Actions({
	//这里的url是去掉namespace之后的。。
//	@org.apache.struts2.convention.annotation.Action(value="/")//这里写的是action的名字，不需要加后缀
    //,
    //@Action("/")
//	,
	@org.apache.struts2.convention.annotation.Action("index")
  })
public class Index extends ActionSupport {
	static Logger logger=LoggerFactory.getLogger(Index.class);
	private String redirectName;
//	@org.apache.struts2.convention.annotation.Action("index")
	public String execute() {
		//这里应该写action的名字，不需要加后缀
		redirectName = "login";
		logger.info("index.jsp");
		return Action.SUCCESS;
	}

	public String getRedirectName() {
		return redirectName;
	}

}
