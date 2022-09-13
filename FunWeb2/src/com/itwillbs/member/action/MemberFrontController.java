package com.itwillbs.member.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itwillbs.member.action.ActionForward;

public class MemberFrontController extends HttpServlet{
//주소 매핑하는 파일 => 컨트롤러 (서블릿)
//web.xml에서 주소 매핑하는 파일인 컨트롤러로 이동함
	

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doProcess()실행");
		//가상주소 뽑아오는 부분 
		System.out.println("\n 1.가상주소 계산 시작");
		//1.가상주소 계산--------------------------------------------------
			//req.getRequestURL();
			//URL: http://localhost:8088/Model2/board2.bo
			String requestURI = request.getRequestURI();
			//URI:/Model2/board2.bo
			System.out.println("C:requestURI :"+requestURI); //URI주소 확인
								//C: Controller의 의미 
			
			String ctxPath = request.getContextPath();
			System.out.println("C: ctxPath :"+ctxPath);
			
			//URI의 /Model2 부분 삭세
			String command = requestURI.substring(ctxPath.length());
			//substring : 데이터 자르기
			//ctxPath의 길이만큼 데이터를 잘라서 가져오겠다는 뜻 
			System.out.println("C: command :"+command);
		//1.가상주소 계산--------------------------------------------------
			System.out.println("\n 1.가상주소 계산 끝");
			
			System.out.println("\n 2.가상주소 매핑 시작");
		//2.가상주소 매핑--------------------------------------------------
			Action action = null;
			ActionForward forward = null;
			
			if(command.equals("/MemberInsert.me")){
				//가상주소는 Controller에서 정해주는 것 
				// 글쓰기 페이지 보여주기 (DB정보 필요없음)
				System.out.println(" C : /MemberInsert.me 호출 ");
				System.out.println(" C : DB정보가 필요없음-view페이지로 이동 ");
				
				forward = new ActionForward();
				forward.setPath("./member/join.jsp");
				forward.setRedirect(false);
			}else if(command.equals("/MemberInsertAction.me")){
				System.out.println(" C : /MemberInsertAction.me 호출 ");
				System.out.println(" C : DB작업 o, 페이지 이동");
				
				// MemberInsertAction() 객체 생성
				//MemberInsertAction miAction = new MemberInsertAction();
				action = new MemberInsertAction();
				try {
//				    forward = miAction.execute(request, response);
					forward = action.execute(request, response);
					//저장된 데이터 보여줌 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("/MemberIdheck.me")){
				System.out.println(" C : /MemberIdcheck.me 호출 ");
				System.out.println(" C : DB작업 o, ajax:페이지 이동 안함");
					action = new MemberIdcheckAction();
				try {
//				    forward = miAction.execute(request, response);
					forward = action.execute(request, response);
					//저장된 데이터 보여줌 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("/MemberLogin.me")){
				//로그인  페이지 보여주기(DB정보 필요없음)
				System.out.println(" C: /MembeLogin.me 호출");
				System.out.println(" C: DB정보가 필요 없음 - View페이지 이동");
				
				forward = new ActionForward();
				forward.setPath("./member/login.jsp");
				forward.setRedirect(false);
			}else if(command.equals("/MemberLoginAction.me")){
				System.out.println(" C : /MemberLoginAction.me 호출 ");
					action = new MemberLoginAction();
				try {
//				    forward = miAction.execute(request, response);
					forward = action.execute(request, response);
					//저장된 데이터 보여줌 
				} catch (Exception e) {
					e.printStackTrace();
				}
			}else if(command.equals("/Main.me")){
				//메인 페이지 보여주기(DB정보 필요없음)
				System.out.println(" C: /Main.me 호출");
				System.out.println(" C: DB정보가 필요 없음 - View페이지 이동");
				
				forward = new ActionForward();
				forward.setPath("./main/main.jsp");
				forward.setRedirect(false);
			}else if(command.equals("/MemberLogoutAction.me")){
				System.out.println(" C : /MemberLogoutAction.me 호출 ");
				action = new MemberLogoutAction();
			try {
//			    forward = miAction.execute(request, response);
				forward = action.execute(request, response);
				//저장된 데이터 보여줌 
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
			
			System.out.println("\n  3. 가상주소 이동 - 시작");
		//3.가상주소 이동--------------------------------------------------
		if(forward != null){
			if(forward.isRedirect()){
				//true -> sendRedirect 방식으로 움직임
				//주소 변경되면서 이동(가상 주소)
				System.out.println("C : true"+forward.getPath()+"이동, sendRedirect방식 ");
				
				response.sendRedirect(forward.getPath());
			}else{
				//false -> forward 방식으로 움직임 
				//페이지는 이동했지만 주소 변동 없이 request값을 가지고 이동(jsp페이지 이동)
				System.out.println("C : true"+forward.getPath()+"이동, forward방식 ");
				RequestDispatcher dis
				= request.getRequestDispatcher(forward.getPath());
				dis.forward(request, response);
			}
		}
	
	//3.가상주소 이동--------------------------------------------------
		System.out.println("\n 3.가상주소 이동 끝");
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get방식 요청 자동으로 출력 
		System.out.println("GET 방식 호출 - doGET()실행");
		doProcess(request, response);
	}
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post방식 요청 자동으로 출력 
		System.out.println("POST 방식 호출 - doPOST()실행");
		doProcess(request, response);
		}
}
