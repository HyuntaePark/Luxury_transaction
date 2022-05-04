<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">공지사항 관리 > 공지사항 상세 조회</h1>
	</div>

	<!-- Content Row -->
	<div class="container">
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
	&nbsp
	<a class="btn btn-primary btn-sm" href="/admin/noticeManage/update?noticeNo=${nvo.noticeNo}"
			role="button">공지사항 수정</a>
			&nbsp &nbsp 
	<a class="btn btn-danger btn-sm" href="/admin/noticeManage/delete?noticeNo=${nvo.noticeNo}" 
		role="button">공지사항 삭제</a>
	
	</div>

</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->
<%@include file="footer.jsp"%>