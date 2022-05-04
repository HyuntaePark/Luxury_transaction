<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>Electro - HTML Ecommerce Template</title>

<!-- Google font -->
<link
	href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700"
	rel="stylesheet">

<!-- Bootstrap -->
<link type="text/css" rel="stylesheet"
	href="/user/css/bootstrap.min.css" />

<!-- Slick -->
<link type="text/css" rel="stylesheet" href="/user/css/slick.css" />
<link type="text/css" rel="stylesheet" href="/user/css/slick-theme.css" />

<!-- nouislider -->
<link type="text/css" rel="stylesheet"
	href="/user/css/nouislider.min.css" />

<!-- Font Awesome Icon -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="/user/css/font-awesome.min.css">

<!-- Custom stlylesheet -->
<link type="text/css" rel="stylesheet" href="/user/css/style.css" />

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->

</head>
<body>
	<!-- HEADER -->
	<header>
		<%@include file="header/topHeader_member.jsp"%>
		<%@include file="header/header_searchBar.jsp"%>
	</header>
	<!-- /HEADER -->


	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12"
					style="padding-top: 7%; padding-left: 17%; padding-right: 17%;">
					<div class="section-title" style="text-align: center">
						<h3 class="title">LOGIN</h3>
					</div>
					<!-- 
							<div class="form-group">
								<input class="input" type="text" name="userId" placeholder="아이디">
							</div>
							<div class="form-group" style="padding-bottom:50px">
								<input class="input" type="password" name="password" placeholder="패스워드">
							</div>
							 -->
					<%
						if (session.getAttribute("login") != null) {
							String userName = (String) session.getAttribute("name");
							String userId = (String) session.getAttribute("userId");
					%><h1><%=userName%>님, 환영합니다.</h1>
					
					<%
						} else {
					%>
					<form action="login" method="post">
						<div class="form-group">
						<input class="input"  type="text" name="userId" placeholder="아이디">
						</div>
						<div class="form-group">
						<input class="input"  type="password" name="userPassword" placeholder="비밀번호">
						</div>
						<input type="submit" value="로그인" class="primary-btn order-submit col-xs-12"
						style="margin-bottom: 15px; padding-left: 10%; padding-right: 10%;">
					</form>
					<%
						}
					%>


					<c:if test="${msg == false}">
						<p style="color: red;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력하세요.</p>
					</c:if>
					<!--  
					<a href="#" class="primary-btn order-submit col-xs-12"
						style="margin-bottom: 15px; padding-left: 10%; padding-right: 10%;">로그인</a>-->
					<a href="/join" class="primary-btn order-submit col-xs-12"
						style="margin-bottom: 15%">회원가입</a>
				</div>
			</div>
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /SECTION -->



	<!-- FOOTER -->
	<footer id="footer">
		<%@include file="footer/footer.jsp"%>
	</footer>
	<!-- /FOOTER -->

	<!-- jQuery Plugins -->
	<script src="/user/js/jquery.min.js"></script>
	<script src="/user/js/bootstrap.min.js"></script>
	<script src="/user/js/slick.min.js"></script>
	<script src="/user/js/nouislider.min.js"></script>
	<script src="/user/js/jquery.zoom.min.js"></script>
	<script src="/user/js/main.js"></script>

</body>
</html>
