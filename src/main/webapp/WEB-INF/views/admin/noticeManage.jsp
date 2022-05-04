<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">공지사항 관리</h1>
		<a class="btn btn-primary" href="/admin/noticeManageInsert"
			role="button">공지사항 등록</a>
	</div>

	<!-- Content Row -->
	<div class="container">
	<table class="table table-striped table-hover">
	<thead>
		<tr>
			<th>공지사항번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="nvo" items="${noticeList}">
			<tr>
				<td class="no">${nvo.noticeNo}</td>
				<td><a href="/admin/noticeManage/${nvo.noticeNo}">${nvo.noticeTitle}</td>
				<td>${nvo.noticeUserId}</td>
				<td>
					<fmt:formatDate value="${nvo.noticeDate}" pattern="yy/MM/dd"/>
				</td>
			</tr>
		</c:forEach>
	</tbody>
	</table>
	</div>

</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->
<%@include file="footer.jsp"%>