<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">공지사항 관리 > 공지사항 상세 조회 > 삭제하기</h1>
	</div>

	<!-- Content Row -->
	<div class="container">
		<table class="table table-bordered" border="1">
		<th class="deleteHead" style="width: 170px;">
		<a>공지사항 삭제</a>
		</th>
		<td>
		<p style="color:#f00"><i class="fas fa-exclamation-triangle"></i>정말 삭제하시겠습니까?</p>
		<form action="/admin/noticeManage/delete" method="post">
			공지사항 번호: <input type="number" name="noticeNo" value="${nvo.noticeNo}">
			<input type="hidden" name="noticeNo" value="${nvo.noticeNo}">
			<input type="submit" value="삭제">
		</form>
		</td>
		</table>
		<br>
		<p style="color:#f00">아래의 내용이 맞는지 확인하세요.</p>
		<table class="table table-bordered">
		<tr>
			<th class="thead" style="width:170px;">공지사항번호</th>
			<td>${nvo.noticeNo}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${nvo.noticeTitle}</td>
		</tr>
		<tr>
			<th>작성자</th>
			<td>${nvo.noticeUserId}</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><fmt:formatDate value="${nvo.noticeDate}" pattern="yy/MM/dd"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${nvo.noticeDescription}</td>
		</tr>
	</table>
	
		<br>
		<br>
		<br>
		<br>
	</div>

</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->
<%@include file="footer.jsp"%>