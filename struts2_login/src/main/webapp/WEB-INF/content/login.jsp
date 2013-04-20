<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<link href="<s:url value="/resources/css/login.css"/>" rel="stylesheet" type="text/css"/>
<title><s:text name="loginPage" /></title>
</head>
<body>
	<!-- 使用form标签生成表单元素 -->
	<s:form action="login" validate="true" namespace="/">
		<tr>
			<td colspan="2">
			<s:actionerror /> 
			<s:fielderror />
			</td>
		</tr>
		<s:textfield name="username" label="%{getText('user')}" />
		<s:textfield name="password" label="%{getText('pass')}" />
		<s:submit value="%{getText('login')}" />
	</s:form>
	<a href="<s:url action="register" method="execute"/>">注册用户</a>
</body>
</html>
