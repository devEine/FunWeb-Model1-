<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/default.css" rel="stylesheet" type="text/css">
<link href="./css/subpage.css" rel="stylesheet" type="text/css">
<!--[if lt IE 9]>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE9.js" type="text/javascript"></script>
<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/ie7-squish.js" type="text/javascript"></script>
<script src="http://html5shim.googlecode.com/svn/trunk/html5.js" type="text/javascript"></script>
<![endif]-->
<!--[if IE 6]>
 <script src="../script/DD_belatedPNG_0.0.8a.js"></script>
 <script>
   /* EXAMPLE */
   DD_belatedPNG.fix('#wrap');
   DD_belatedPNG.fix('#main_img');   

 </script>
 <![endif]-->
</head>
<body>
<div id="wrap">
<!-- 헤더들어가는 곳 -->
<header>
<div id="login"><a href="../member/login.html">login</a> | <a href="../member/join.html">join</a></div>
<%
	//세션값 가져오기
	String loginID = (String)session.getAttribute("loginID");
	if(loginID ==null){
		//로그인 안한 상태 -> 세션값 (loginID) 없음
		%>
	<div id="login"><a href="../member/login.jsp"></a>
					<a href="../member/join.jsp"></a></div>	
		<%
	}else{
		//로그인 성공 -> 세션값 있음 
		%>
	<div id="login"><a href="../member/update.jsp"></a>
					<a href="../member/update.jsp"></a></div>
		<%
	}

%>
<div class="clear"></div>
<!-- 로고들어가는 곳 -->
<div id="logo"><img src="./images/logo.gif" width="265" height="62" alt="Fun Web"></div>
<!-- 로고들어가는 곳 -->
<nav id="top_menu">
<ul>
	<li><a href="../main/main.html">HOME</a></li>
	<li><a href="../company/welcome.html">COMPANY</a></li>
	<li><a href="#">SOLUTIONS</a></li>
	<li><a href="../center/notice.html">CUSTOMER CENTER</a></li>
	<li><a href="#">CONTACT US</a></li>
</ul>
</nav>
</header>
<!-- 헤더들어가는 곳 -->

<!-- 본문들어가는 곳 -->
<!-- 본문메인이미지 -->
<div id="sub_img_member"></div>
<!-- 본문메인이미지 -->
<!-- 왼쪽메뉴 -->
<nav id="sub_menu">
<ul>
<li><a href="#">Join us</a></li>
<li><a href="#">Privacy policy</a></li>
</ul>
</nav>
<!-- 왼쪽메뉴 -->
<!-- 본문내용 -->
<article>
<h1>Login</h1>
<form action="./MemberLoginAction.me" id="join" method="post">
<fieldset>
<legend>Login Info</legend>
<label>User ID</label>
<input type="text" name="id"><br>
<label>Password</label>
<input type="password" name="pw"><br>
</fieldset>
<div class="clear"></div>
<div id="buttons">
<input type="submit" value="Submit" class="submit">
<input type="reset" value="Cancel" class="cancel">
</div>
</form>
</article>
<!-- 본문내용 -->
<!-- 본문들어가는 곳 -->

<div class="clear"></div>
<!-- 푸터들어가는 곳 -->
<footer>
<hr>
<div id="copy">All contents Copyright 2011 FunWeb 2011 FunWeb 
Inc. all rights reserved<br>
Contact mail:funweb@funwebbiz.com Tel +82 64 123 4315
Fax +82 64 123 4321</div>
<div id="social"><img src="./images/facebook.gif" width="33" 
height="33" alt="Facebook">
<img src="./images/twitter.gif" width="34" height="34"
alt="Twitter"></div>
</footer>
<!-- 푸터들어가는 곳 -->
</div>
</body>
</html>