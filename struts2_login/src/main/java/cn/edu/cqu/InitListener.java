package cn.edu.cqu;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ognl.OgnlRuntime;
import cn.edu.cqu.dao.DaoUtils;


/**
 * To allow works Struts 2 with Google App Engine
 */
public class InitListener implements ServletContextListener {

    public InitListener() {
    }

    public void contextInitialized(ServletContextEvent sce) {
        OgnlRuntime.setSecurityManager(null);
        DaoUtils.init();
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

}
