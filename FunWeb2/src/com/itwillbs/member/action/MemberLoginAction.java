package com.itwillbs.member.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.itwillbs.member.db.MemberBean;
import com.itwillbs.member.db.MemberDAO;

public class MemberLoginAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberBean mb = new MemberBean();

		mb.setId(request.getParameter("id"));
		mb.setPw(request.getParameter("pw"));
		
		MemberDAO dao = new MemberDAO();
		
		int result = dao.loginMember(mb);
			if(result==0){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('비밀번호 오류!');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				return null;
			}else if(result==-1){
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('아이디 오류!');");
				out.println("history.back();");
				out.println("</script>");
				out.close();
				return null;
			}else{
			 //아이디 비밀번호 일치
			 //세션값 생성
				HttpSession session = request.getSession();
				//request에서 세션값 받아서 객체생성한 뒤 저장해야 session 사용 가능
				 session.setAttribute("loginID", mb.getId());
				 
				//페이지 이동정보 저장(리턴)
				ActionForward forward = new ActionForward();
				//로그인완료되면 Main페이지로 이동(가상주소)
				forward.setPath("./Main.me");
				forward.setRedirect(true);
				return forward;
			 }
	}
}
