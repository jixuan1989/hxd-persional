package cn.edu.cqu.interceptor;

import java.util.Map;

import org.apache.struts2.convention.annotation.InterceptorRef;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 暂时没有使用
 * @author hxd
 *
 */
public class AuthorityInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 1358600090729208361L;

	//拦截Action处理的拦截方法
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得请求相关的ActionContext实例
		ActionContext ctx=invocation.getInvocationContext();
		Map session=ctx.getSession();
		//取出名为user的session属性
		String user=(String)session.get("user");
		//如果没有登陆，或者登陆所有的用户名不是aumy，都返回重新登陆
		if(user!=null ){
			return invocation.invoke();
		}
		//没有登陆，将服务器提示设置成一个HttpServletRequest属性
		ctx.put("tip","您还没有登录，请登陆系统");
		return Action.LOGIN;		
	}
}

