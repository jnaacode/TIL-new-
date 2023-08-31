<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

<title>Insert title here</title>
</head>
<body>

<h1>실시간 지진해일 긴급 대피장소</h1>

	<button id="btn2">실시간 지진해일 긴급 대피장소 정보</button>
	<br>
	<br>

	<table border="1" id="result2">
		<thead>
			<tr>
				<th>시도명</th>
				<th>시군구명</th>
				<th>대피지구명</th>
				<th>대피장소명</th>
				<th>주소</th>
				<th>경도</th>
				<th>위도</th>
				<th>수용가능인원수</th>
				<th>대피소 분류명</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	
	<script>
	$(function(){
		
		$("#btn2").click(function(){
			
			.ajax({
				
				url : "air",
				date : {"location" : $("#location").val()},
				success : function(result){
					
				},
				error :function(){
					console.log("통신오류")
				}
			
				
			})
			
			
		})
		
		
	})
	
	
	
	
	
	
	</script>

</body>
</html>