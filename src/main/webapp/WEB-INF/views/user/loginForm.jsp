<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인</h1>
	<%
		if (session.getAttribute("login") != null) {
			String userName = (String) session.getAttribute("name");
			String userId = (String) session.getAttribute("userId");
	%><h1><%=userName%>님, 환영합니다.</h1>
		<form action="logout">
			<input type="submit" value="로그아웃">
		</form>
		<form action="update/${userId }">
			<input type="submit" value="회원정보수정">
		</form>
		<form action="delete/${userId }">
			<input type="submit" value="회원정보삭제">
		</form>
		
	<%
		} else {
	%>
	<form action="login" method="post">
		<input type="text" name="userId" placeholder="아이디"><br>
		<input type="password" name="userPassword" placeholder="비밀번호"><br>
		<input type="submit" value="로그인">
	</form>
	<%
		}
	%>


	<c:if test="${msg == false}">
		<p style="color: red;">로그인에 실패했습니다. 아이디 또는 패스워드를 다시 입력하세요.</p>
	</c:if>
</body>
</html>