<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>공지사항</title>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
	crossorigin="anonymous">
<link rel="stylesheet" href="${contextPath}/resources/css/boardList.css">
<link rel="stylesheet" href="${contextPath}/resources/css/qnaList.css">
<link rel="stylesheet" href="${contextPath}/resources/css/header.css">

</head>
<body>

	<jsp:include page="/WEB-INF/views/admin/AdminHeader.jsp" />

	<main>
		<c:if test="${!empty param.select}">
			<c:set var="searchUrl"
				value="&select=${param.select}&sContent=${param.sContent}" />
		</c:if>

		<jsp:include page="/WEB-INF/views/common/adminSidebar.jsp" />

		<section class="board-list">
			<h1 class="board-name">공지사항</h1>
			<div class="list-wrapper">
				<table class="list-table">
					<div class="main">

						<c:if test="${empty boardList}">
							<div id="">게시글이 존재하지 않습니다.</div>
						</c:if>

						<c:if test="${!empty boardList}">
							<thead>
								<th>글 번호</th>
								<th>제목</th>
								<th></th>
								<th>작성일</th>
								<th>작성자</th>
							</thead>

							<c:forEach var="board" items="${boardList}">

								<tbody>
									<td>${board.boardNo}</td>
									<td><a href="${contextPath}/admin/AdminBoardList/detail?no=${board.boardNo}">${board.boardTitle}</a></td>
									<td></td>
									<td>${board.boardDate}</td>
									<td>${member.memberName}</td>
								</tbody>
								
	
							</c:forEach>
							<div class="btn-area">
								<button id="insertBtn"
									onclick="location.href='${contextPath}/admin/AdminBoardList/write'">글쓰기</button>
							</div>
						</c:if>
					</div>
				</table>
			</div>
		</section>
	</main>

 <jsp:include page="/WEB-INF/views/common/footer.jsp" />
	<script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/boardList.js"></script>
</body>
</html>