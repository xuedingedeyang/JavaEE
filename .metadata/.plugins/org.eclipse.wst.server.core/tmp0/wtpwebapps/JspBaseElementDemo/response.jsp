<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	/*注意response对象获得的writer对象，向客户端打印的时候总是先于内置的out对象,想解决这个问题可以调用内置out输出流的
	flush()方法强制将缓冲区的内容打印*/
	response.setContentType("text/html;charset=utf-8");//设置响应的MIME类型
	out.println("<h1>response内置对象</h1>");
	out.println("<hr>");
	//out.flush();
	
	PrintWriter outer = response.getWriter();
	outer.println("我是response生成的printer对象输出流");
	//response.sendRedirect("reg.jsp");//请求重定向
	//请求重定向
	//response.sendRedirect("request.jsp");
	//请求转发
	request.getRequestDispatcher("request.jsp").forward(request,response);
%>