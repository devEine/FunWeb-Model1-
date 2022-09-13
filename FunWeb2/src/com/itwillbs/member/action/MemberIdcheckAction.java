package com.itwillbs.member.action;

import java.io.PrintWriter;
import java.lang.reflect.Member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.db.MemberBean;
import com.itwillbs.member.db.MemberDAO;

public class MemberIdcheckAction implements Action{
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
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
		//결과 출력만 함
		response.setContentType("text/html; charset=UTF-8");
		//join.jsp페이지 상단의 데이터 타입 참고 
		PrintWriter out = response.getWriter();
		//reponse영역 데이터 출력 권한을 PrintWriter데이터타입의 변수 out에 위임
		out.println(result);
		/*out.println("<script>");
		out.println("alert('자바스크립트')");
		out.println("</script>");*/
		out.close();
		
		return null;
		//이동은 안홤 -> return null
		//ajax통신은 이동은 안하고 결과값 출력만 함 
	}
}
