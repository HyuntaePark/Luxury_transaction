<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

        <!-- Begin Page Content -->
        <div class="container-fluid">

          <!-- Page Heading -->
          <div class="d-sm-flex align-items-center justify-content-between mb-4">
            <h1 class="h3 mb-0 text-gray-800">공지사항 등록</h1>
          </div>

          <!-- Content Row -->
		<div class="container">
          	<form class="notice" action="/admin/noticeManageInsert" method="post">
			<table class="table table-bordered" border="1">
				<tr>
					<th class="thead" style="width: 170px;">공지사항 제목</th>
					<td><input type="text" name="noticeTitle" style="width:550px">
					</td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="15" cols="60" name="noticeDescription"></textarea><br></td>
				</tr>

				<tr>
					<th>&nbsp;</th>
					<td>
					<input type="hidden" name="noticeUserId" value="${userId}">
            	<input type="submit" class="btn btn-primary btn-user" value="등록"> 
					</td>
				</tr>
			</table>
			</form>
          </div>

        </div>
        <!-- /.container-fluid -->

      </div>
      <!-- End of Main Content -->
            
            
  <%@include file="footer.jsp" %>