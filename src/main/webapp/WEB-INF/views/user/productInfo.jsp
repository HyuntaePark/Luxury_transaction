<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		 <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

		<title>Product Detail</title>

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

    </head>
	<body>
		<!-- HEADER -->
		<header>
			<%@include file ="header/topHeader_nonMember.jsp" %>
			<%@include file ="header/header_searchBar.jsp" %>
		</header>
		<!-- /HEADER -->


<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<!-- Product main img -->
					<div class="col-md-6 col-md-push-2">
						<div id="product-main-img">
							<c:forEach var="file" items="${uploadFile}">
								<div class="product-preview">
									<img src='<c:url value="/img/${file.fileNo}"/>' width="150px">
								</div>
							</c:forEach>
						</div>
					</div>
					<!-- /Product main img -->

					<!-- Product thumb imgs -->
					<div class="col-md-2 col-md-pull-6">
						<div id="product-imgs">
							<c:forEach var="file" items="${uploadFile}">
								<img src='<c:url value="/img/${file.fileNo}"/>' style="width:100px">
							</c:forEach>
						</div>
					</div>
					<!-- /Product thumb imgs -->
					
					<!-- seller details -->
					<div class="col-md-12" style="border-bottom: 1px solid black; height:45px; margin-bottom:20px ">
						<div class="product-details" style="margin-bottom:2%">
							<ul class="product-links">
								<li style="font-weight:bold">판매자:</li>
								<li>${productInfo.sallerUserId}</li>
								<li style="font-weight:bold">연락처:</li>
								<li>${userInfo.userPhone}</li>
							</ul>
						</div>
					</div>
					<!-- /Product details -->

					<!-- Product details -->
					<div class="col-md-12">
						<div class="product-details">
							<a href="/addwishlist" ><i class="fa fa-heart-o" ></i> add to wishlist</a>
							<h2 class="product-name" style="margin-top:15px">${productInfo.productName}</h2>
								<a href="#">${categoryName}</a>
							<div>
								<h3 class="product-price">${productInfo.productPrice} 원</h3>
							</div>
							<p>${productInfo.productDescription}</p>

						</div>
					</div> 
					<!-- /Product details -->

		
				</div>
				<!-- /row -->
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
