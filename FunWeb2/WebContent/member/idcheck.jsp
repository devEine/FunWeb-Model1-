<%@page import="com.itwillbs.member.MemberBean"%>
<%@page import="com.itwillbs.member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//파라미터 값으로 id 받아옴 
	String id = request.getParameter("id");
	//memberDAO객체 생성
	MemberDAO dao = new MemberDAO();
	//getMember(id) 메서드호출
	MemberBean mb = dao.getMember(id);
	String result="";
	if(mb.getId()!=null){
		//아이디 있음, 아이디 중복
		result="아이디 중복";
	}else{
		//아이디 없음, 아이디 사용가능
		result="아이디 사용가능";
	}

%>
<%=result %>
