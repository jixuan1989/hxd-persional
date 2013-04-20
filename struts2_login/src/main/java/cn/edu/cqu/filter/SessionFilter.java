package cn.edu.cqu.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 用来过滤所有的url是否登录了的
 * @author hxd
 *
 */
public class SessionFilter implements Filter {
	static Logger logger =LoggerFactory.getLogger(SessionFilter.class);
	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain fc)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		String url = request.getContextPath();
		logger.debug(request.getRequestURL().toString());//根地址，比如 http://localhost:8080/tlxweb/lg/test.asp 就是 /tlxweb
		HttpSession session = request.getSession();
		if (null == session.getAttribute("currentuser")) {
			response.sendRedirect(url + "/login.asp");
			return ;
		}
		fc.doFilter(request, response);

	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

}
