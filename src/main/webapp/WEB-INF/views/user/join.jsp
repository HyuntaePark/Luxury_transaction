<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Electro - HTML Ecommerce Template</title>

 		<!-- Google font -->
 		<link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

 		<!-- Bootstrap -->
 		<link type="text/css" rel="stylesheet" href="/user/css/bootstrap.min.css"/>

 		<!-- Slick -->
 		<link type="text/css" rel="stylesheet" href="/user/css/slick.css"/>
 		<link type="text/css" rel="stylesheet" href="/user/css/slick-theme.css"/>

 		<!-- nouislider -->
 		<link type="text/css" rel="stylesheet" href="/user/css/nouislider.min.css"/>

 		<!-- Font Awesome Icon -->
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.13.0/css/all.min.css" rel="stylesheet">
		<link rel="stylesheet" href="/user/css/font-awesome.min.css">
		

 		<!-- Custom stlylesheet -->
 		<link type="text/css" rel="stylesheet" href="/user/css/style.css"/>

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
		  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
		  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
		<![endif]-->
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			$("#submit").on("click", function() {
				if ($("#userId").val() == "") {
					alert("아이디를 입력해주세요.");
					$("#userId").focus();
					return false;
				}
				if ($("#userPassword").val() == "") {
					alert("비밀번호를 입력해주세요.");
					$("#userPassword").focus();
					return false;
				}
				if ($("#userName").val() == "") {
					alert("이름을 입력해주세요.");
					$("#userName").focus();
					return false;
				}
				if ($("#userBirth").val() == "") {
					alert("생년월일을 입력해주세요.");
					$("#userBirth").focus();
					return false;
				}
				if ($("#userAddress").val() == "") {
					alert("주소를 입력해주세요.");
					$("#userAddress").focus();
					return false;
				}
				if ($("#userPhone").val() == "") {
					alert("전화번호를 입력해주세요.");
					$("#userPhone").focus();
					return false;
				}
				var idChkVal = $("#idCheck").val();
				if (idChkVal == "N") {
					alert("중복확인 버튼을 눌러주세요.");
				} else if (idChkVal == "Y") {
					$("#regForm").submit();
				}
			});
		})

		$(function() {
			$('#userPassword2').blur(function() {
				if ($('#userPassword').val() != $('#userPassword2').val()) {
					if ($('#userPassword2').val() != '') {
						alert("비밀번호가 일치하지 않습니다.");
						$('#userPassword2').val('');
						$('#userPassword2').focus();
					}
				}

			})
		});

		function btn_idCheck() {
			$.ajax({
				url : "/idCheck",
				type : "post",
				dataType : "json",
				data : {
					"userId" : $("#userId").val()
				},
				success : function(data) {
					if (data == 1) {
						alert("중복된 아이디입니다.");
					} else if (data == 0) {
						$("#idCheck").attr("value", "Y");
						alert("사용 가능한 아이디입니다.");
					}
				}
			})
		}
	</script>
    </head>
	<body>
	<!-- HEADER -->
		<header>
			<%@include file ="header/topHeader_nonMember.jsp" %>
			<%@include file ="header/header_noSearchBar.jsp" %>
		</header>
		<!-- /HEADER -->
	

		<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<h3 class="breadcrumb-header">회원가입</h3>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
					<div class="col-xs-12" style="padding-left:15%; padding-right:15%;">
						<!-- 회원정보 입력 --> 
							<div class="section-title">
								<h3 class="title">회원 정보 입력</h3>
							</div>
							<form action="/insert" method="post" id="regForm">
								<div class="form-group">
									<input class="input" type="text" id="userId" name="userId" placeholder="아이디">
									<button type="button" id="idCheck" value="N" onclick="btn_idCheck();">중복확인</button>
								</div>
								<div class="form-group">
									<input class="input" type="password" id="userPassword" name="userPassword" placeholder="비밀번호"><br>
								</div>
								<div class="form-group">	
									<input class="input" type="password" id="userPassword2" placeholder="비밀번호 확인"><br>
								</div>
								<div class="form-group">
									<input class="input" type="text" id="userName"name="userName" placeholder="이름">
								</div>
								<div class="form-group">
									<input class="input" type="date" id="userBirth" name="userBirth" placeholder="생년월일">
								</div>
								<div class="form-group">
									<input class="input" type="text" id="userAddress" name="userAddress" placeholder="주소">
								</div>
								<div class="form-group">
									<input class="input" type="text" id="userPhone" name="userPhone" placeholder="휴대전화">
								</div>
							</form>
								<div>
									<button class="primary-btn order-submit" style="margin-top:5%; margin-bottom:20%" type="button" id="submit">회원가입</button>
								</div>
						<!-- /회원정보입력 -->
					</div>
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->



		<!-- FOOTER -->
		<footer id="footer">
			<%@include file ="footer/footer.jsp" %>
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
