package cn.edu.cqu.filter;

import java.io.IOException;  
import javax.servlet.FilterChain;  
import javax.servlet.ServletException;  
import javax.servlet.ServletRequest;  
import javax.servlet.ServletResponse;  
import javax.servlet.http.HttpServletRequest;  

import org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter;
/*
 * Struts2的Filter会过滤到上传文件的request，封装为Struts2自己的MultiPartRequestWrapper，这个时候再到UEditor里的Uploader中用commons-fileupload组件解析request，就无法获取到正确的文件流，所以上传失败。
 */
public class UEditorFilter extends StrutsPrepareAndExecuteFilter {
public void doFilter(ServletRequest req, ServletResponse res,FilterChain chain) 
throws IOException, ServletException {  
       HttpServletRequest request = (HttpServletRequest) req;  
       //不过滤的url  
       String url = request.getRequestURI();
      String root= request.getContextPath();
      //System.out.println(url+"||"+root+"/ueditor/jsp/imageUp.jsp");
       if ((root+"/ueditor/jsp/imageUp.jsp").equals(url)) {  
          //其他 /jsp/ 下的几个路径我不常用，就没写了
        System.out.println("使用自定义的过滤器"+url);
        //request.get
           //chain.doFilter(req, res);  
           req.getRequestDispatcher("/ueditor/jsp/imageUp.jsp").forward(req, res);
       }else{  
           //System.out.println("使用默认的过滤器");  
           super.doFilter(req, res, chain);  
       }  
   }  
}