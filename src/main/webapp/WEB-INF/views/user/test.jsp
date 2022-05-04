<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
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
	<h1>회원가입</h1>

	<form action="/insert" method="post" id="regForm">

		<input type="text" id="userId" name="userId" placeholder="아이디">
		<button type="button" id="idCheck" value="N"
			onclick="btn_idCheck();">중복확인</button>
		<br> <input type="password" id="userPassword" name="userPassword" placeholder="비밀번호"><br>
		<input type="password" id="userPassword2" placeholder="비밀번호 확인"><br>
		<input
			type="text" id="userName" name="userName" placeholder="이름"><br>

		<input type="date" id="userBirth" name="userBirth" placeholder="생년월일"><br>

		<input type="text" id="userAddress" name="userAddress"
			placeholder="주소"><br> <input type="text" id="userPhone"
			name="userPhone" placeholder="휴대전화"><br>

	</form>
	<button type="button" id="submit">회원가입</button>
</body>
</html>