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
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">

	window.onload = function(){
		// 컨트롤러에서 데이터 받기
		var jsonData = JSON.parse('${category}');
		var cateArr = new Array();
		var cateObj = new Object();

		// 1차 분류 셀렉트 박스에 삽입할 데이터 준비
		for (var i = 0; i < jsonData.length; i++) {
			cateObj = new Object(); //초기화
			cateObj.category_no = jsonData[i].category_no;
			cateObj.category_name = jsonData[i].category_name;
			cateArr.push(cateObj);
		}

		var cateSelect = $("select.category");

		for (var i = 0; i < cateArr.length; i++) {
			cateSelect.append("<option value='" + cateArr[i].category_no + "'>"
					+ cateArr[i].category_name + "</option>");
		}
		console.log(cateSelect);
		
	}
	</script>
</head>
<body>
	<!-- HEADER -->
	<header>
		<%@include file="header/topHeader_nonMember.jsp"%>
		<%@include file="header/header_noSearchBar.jsp"%>
	</header>
	<!-- /HEADER -->


	<!-- BREADCRUMB -->
	<div id="breadcrumb" class="section">
		<!-- container -->
		<div class="container">
			<!-- row -->
			<div class="row">
				<div class="col-md-12">
					<h3 class="breadcrumb-header">상품등록</h3>
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
			<div class="col-xs-12" style="padding-left: 15%; padding-right: 15%;">
				<!-- 회원정보 입력 -->
				<div class="section-title">
					<h3 class="title">상품 정보 입력</h3>
				</div>
				<form action="/insert" method="post" id="regForm">
					<div class="form-group">
						<label>Categories</label> <select class="category"
							id="productCategoryNo" name="productCategoryNo">
							<option value="">ALL</option>
						</select>
						<div class="form-group">
							<input class="input" type="text" id="productName"
								name="productName" placeholder="상품명">
						</div>
						<div class="form-group">
							<input class="input" type="text" id="productPrice"
								name="productPrice" placeholder="상품 가격"><br>
						</div>
						<div class="form-group">
							<input class="input" type="text" id="productDescription"
								name="productDescription" placeholder="상품 설명">
						</div>
				</form>
				<div>
					<button class="primary-btn order-submit"
						style="margin-top: 5%; margin-bottom: 20%" type="button"
						id="submit">상품 등록</button>
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
