<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>카테고리 테스트</h1>
<a href="/all">All</a>
<a href="/clothes">clothes</a>
<a href="/shoes">Shoes</a>
<a href="/bag">Bag</a>
<a href="/accessories">Accessories</a>

<h1>검색박스 테스트</h1>
<form action="search">
<input type="text" name="searchbox">
<input type="submit" value="like 검색">
</form>


<table border="1">

<c:forEach var="list" items="${productList}">
<tr>
	<td>${list.productNo}</td>
	<td>${list.productName}</td>
	<td>${list.productPrice}</td>
</tr>
</c:forEach>

</table>

</body>
</html>