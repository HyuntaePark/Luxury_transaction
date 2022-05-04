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

	<body>
<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#submit").on("click", function() {
				var pwChkVal = $("#pwCheck").val();
				if (pwChkVal == "N") {
					alert("비밀번호 확인 버튼을 눌러주세요.");
				} else if (pwChkVal == "Y") {
					$("#delForm").submit();
				}
			});
		})

		function btn_pwCheck() {

			$.ajax({
				url : "/pwCheck",
				type : "post",
				dataType : "json",
				data : {
					"userId" : $("#userId").val(),
					"userPassword" : $("#userPassword").val()
				},
				success : function(data) {
					if (data == 1) {
						alert("비밀번호가 일치합니다. 삭제하시려면 삭제 버튼을 눌러주세요.");
						$("#pwCheck").attr("value", "Y");
					} else if (data == 0) {
						alert("비밀번호가 일치하지 않습니다.");
					}

				}
			})
		}
	</script>

	<!-- SECTION -->
	<div class="section">
		<!-- container -->
		<div class="container">
			<div class="col-xs-12" style="padding-left: 15%; padding-right: 15%;">
				<!-- 회원정보 입력 -->
				<div class="section-title">
					<h3 class="title">회원정보 삭제</h3><br><br>
					<p>${user.userName}님의 정보를 삭제합니다.
					<p style=color:red;>삭제 후 데이터는 복구될 수 없습니다.
					<p>삭제하시려면 비밀번호를 입력하세요.
				</div>
				<form action="/delete" method="post" id="delForm">
					<div class="form-group">
						<input type="hidden" id="userId" name="userId"
							value='${user.userId}'>
					</div>
					<div class="form-group">
						<input type="password" id="userPassword" name="userPassword">
						<button type="button" id="pwCheck" value="N"
							onclick="btn_pwCheck();">비밀번호 확인</button>
					</div>
				</form>
				<div>
					<button class="primary-btn order-submit"
						style="margin-top: 5%; margin-bottom: 20%" type="button"
						id="submit">회원정보 삭제</button>
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
</body></html>