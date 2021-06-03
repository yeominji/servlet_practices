<%@page import="java.time.LocalDateTime"%>
<%@page import="com.douzone.guestbook.dao.GuestbookDao"%>
<%@page import="com.douzone.guestbook.vo.GuestbookVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String Name = request.getParameter("name");
	String Password = request.getParameter("password");
	String Message = request.getParameter("message");

	GuestbookVo vo = new GuestbookVo();
	
	vo.setName(Name);
	vo.setPassword(Password);
	vo.setMessage(Message);
	vo.setRegDate(LocalDateTime.now().toString());
	
      new GuestbookDao().insert(vo);
	response.sendRedirect(request.getContextPath());
%>

