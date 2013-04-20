<%-- <% response.sendRedirect("login.jsp"); %> --%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css"/>
<title><s:text name="loginPage" /></title>
</head>
<body>

	hello,tlx.
	<a href="<s:url action="login" method="execute"/>">登录</a>
</body>
</html>
