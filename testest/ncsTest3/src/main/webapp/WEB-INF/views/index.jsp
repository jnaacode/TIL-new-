<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<title>아이디 중복 체크 테스트</title>

</head>

<body>

	<h3>아이디 중복 체크 확인</h3>

	<label>ID : </label>
	<input type="text" name="id">
	<h3 id="checkId"></h3>

	<script>
		$("input[name=id]").on("input", function() {

			console.log($("input[name=id]").val());

			$.ajax({
				url : "idDupCheck",
				data : {
					id : $("input[name=id]").val()
				},
				type : "post",
				success : function(result) {

					console.log(result);

					if (result == "true") {

						$("#checkId").text("사용 가능한 아이디 입니다.");

					} else {

						$("#checkId").text("사용할 수 없는 아이디 입니다.");

					}

				},

				error : function(e) {

					$("#checkId").text("ajax 통신 실패");

				}

			});

		});
	</script>

</body>