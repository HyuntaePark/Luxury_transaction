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
<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#submit").on("click", function() {
				$("#updateForm").submit();
			});
		})

	</script>
<body>
	<!-- HEADER -->
	<header>
		<%@include file="header/topHeader_member.jsp"%>
		<%@include file="header/header_searchBar.jsp"%>
	</header>
	<!-- /HEADER -->
<body>

	<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
					<div class="col-xs-12" style="padding-left:15%; padding-right:15%;">
						<!-- 회원정보 입력 --> 
							<div class="section-title">
								<h3 class="title">수정할 회원 정보 입력</h3>
							</div>
							<form action="/update" method="post" id="updateForm">
								<div class="form-group">
									ID <input class="input" type="text" id="userId" name="userId" value="${user.userId}" readonly>
								</div>
								<div class="form-group">
									Password <input class="input" type="password" id="userPassword" name="userPassword" value="${user.userPassword }">
								</div>
								<div class="form-group">
									이름 <input class="input" type="text" id="userName"name="userName" value="${user.userName}">
								</div>
								<div class="form-group">
									주소 <input class="input" type="text" id="userAddress" name="userAddress" value="${user.userAddress}">
								</div>
								<div class="form-group">
									전화번호 <input class="input" type="text" id="userPhone" name="userPhone" value="${user.userPhone}">
								</div>
							</form>
								<div>
									<button class="primary-btn order-submit" style="margin-top:5%; margin-bottom:20%" type="button" id="submit">회원정보 수정</button>
								</div>
						<!-- /회원정보입력 -->
					</div>
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