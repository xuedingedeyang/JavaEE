<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%request.setCharacterEncoding("utf-8"); %>
	<jsp:useBean id="myUser" class="com.po.User" scope="request"/>
	<h1>setProperty动作元素</h1> 
	<hr>
	<!-- 根据表单自动匹配所有的属性 -->
	<%-- <jsp:setProperty name="myUser" property="*" />
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br> --%>
	
	<!-- 根据表单匹配部分属性 -->
	<%-- <jsp:setProperty name="myUser" property="username" />
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br> --%>
	
	<!-- 与表单无关。手动给属性赋值 -->
	<%-- <jsp:setProperty name="myUser" property="username"  value="张三丰"/>
	<jsp:setProperty name="myUser" property="password" value="342242"/>
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br> --%>
	
	<!-- 通过URL参数给属性赋值 -->
	<%-- <jsp:setProperty name="myUser" property="password" param="myPass"/>
	用户名:<%=myUser.getUsername() %><br>
	密码:<%=myUser.getPassword() %><br> --%>
	
	<!-- 上面都是用表达式方式来获取用户名和密码，这里采用getProperty()动作标签方式来获取 -->
	<jsp:setProperty name="myUser" property="*" />
	用户名:<jsp:getProperty property="username" name="myUser"/><br>
	密码:<jsp:getProperty property="password" name="myUser"/><br>
	
	<!-- 当用scope为request时需要用请求重定向，否则用请求转发会形成一次新的请求得不到以前的值 -->
	<a href="test_scope.jsp">测试JavaBean的四个作用于范围</a>
	<%
		request.getRequestDispatcher("test_scope.jsp").forward(request,response);
	%>
</body>
</html>