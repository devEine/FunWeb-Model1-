<%@page import="com.itwillbs.member.MemberDAO"%>
<%@page import="com.itwillbs.member.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request 한글 처리 
	request.setCharacterEncoding("UTF-8");	
	//MemberBean객체생성
	MemberBean mb = new MemberBean();
	//id pass name email regdate
	mb.setId(request.getParameter("id"));
	mb.setPw(request.getParameter("pw"));
	mb.setName(request.getParameter("name"));
	mb.setEmail(request.getParameter("email"));
	
	//MemberDAO객체생성
	MemberDAO dao = new MemberDAO();
	//insert(mb)메서드 호출
	dao.insertMember(mb);
	
	//login.jsp 페이지 이동 
	response.sendRedirect("login.jsp");
%>