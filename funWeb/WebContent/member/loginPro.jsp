<%@page import="com.itwillbs.member.MemberDAO"%>
<%@page import="com.itwillbs.member.MemberBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberBean mb = new MemberBean();

	mb.setId(request.getParameter("id"));
	mb.setPw(request.getParameter("pw"));
	
	MemberDAO dao = new MemberDAO();
	
	int result = dao.loginMember(mb);
		if(result==0){
			%>
			<script type="text/javascript">
				alert('비밀번호 오류');
				history.back();
			</script>
			<%
		}else if(result==1){
			%>
			<script type="text/javascript">
				alert('아이디 오류');
				history.back();
			</script>
			<%
		}else{
			//아이디 비밀번호 일치 -> 로그인 성공 
			//세션값 생성 
			session.setAttribute("loginID",mb.getId());
			//이동 main.jsp
			response.sendRedirect("../main/main.jsp");
		}
%>