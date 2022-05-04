<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<div class="d-sm-flex align-items-center justify-content-between mb-4">
		<h1 class="h3 mb-0 text-gray-800">공지사항 관리 > 공지사항 상세 조회 > 수정하기</h1>
	</div>

	<!-- Content Row -->
	<div class="container">

		<form action="/admin/noticeManage/update" method="post">
			<table class="table table-bordered" border="1">
				<tr>
					<th class="thead" style="width: 170px;">공지사항번호</th>
					<td><input type="number" name="noticeNo" value="${nvo.noticeNo}"></td>
				</tr>
				<tr>
					<th>작성자</th>
					<td>${nvo.noticeUserId}</td>
				</tr>
				<tr>
					<th>작성일</th>
					<td><fmt:formatDate value="${nvo.noticeDate}"
							pattern="yy/MM/dd" /></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="noticeTitle" style="width:550px"" value="${nvo.noticeTitle}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="15" cols="60" name="noticeDescription">${nvo.noticeDescription}</textarea><br></td>
				</tr>

				<tr>
					<th>&nbsp;</th>
					<td>
					<input type="reset" value="취소">
					 &nbsp &nbsp
					<input type="submit" value="수정하기"> 
					</td>
				</tr>
			</table>
		</form>
		<br>
		<br>
		<br>
	</div>

</div>
<!-- /.container-fluid -->
</div>
<!-- End of Main Content -->
<%@include file="footer.jsp"%>