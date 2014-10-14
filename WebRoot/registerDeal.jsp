<%@page import="com.web.model.*,com.web.service.*,com.web.service.impl.*"%>
<%@ page language="java" import="java.util.* ,java.sql.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

String username=request.getParameter("username");
String password=request.getParameter("password");
String password2=request.getParameter("password2");
if(password2==null||password==null||!password.equals(password2)){
	response.sendRedirect("registerFail.jsp");
	
	System.out.println("password "+password+" password2 "+password2);
	return;
}
User user=new User();
user.setUsername(username);
user.setPassword(password);

UserManager userManager=new UserManagerImpl();
boolean exist=userManager.exists(user);
if(exist){
	response.sendRedirect("registerFail.jsp");
	return;
}
userManager.add(user);
response.sendRedirect("registerSuccess.jsp");
%>
