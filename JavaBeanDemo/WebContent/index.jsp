<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.po.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		User user = new User();
		user.setUsername("admin");
		user.setPassword("123456");
	%>
	<h1>使用普通方式创建JavaBean的实例</h1>
	<hr>
	用户名:<%=user.getUsername() %><br>
	密码:<%=user.getPassword() %><br>
</body>
</html>