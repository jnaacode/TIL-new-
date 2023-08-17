<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<c:set var="boardName" value="${map.boardName}"/>
<c:set var="pagination" value="${map.pagination}"/>
<c:set var="boardList" value="${map.boardList}"/>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>공지사항</title>

    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
   integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    crossorigin="anonymous">
    <link rel="stylesheet" href="${contextPath}/resources/css/boardList.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/qnaList.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">

</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    
    <main>
    <c:if test="${!empty param.select}">
        <c:set var="searchUrl" value="&select=${param.select}&sContent=${param.sContent}"/>
    </c:if>

    <jsp:include page="/WEB-INF/views/common/boardSidebar.jsp"/>

    <section class="board-list">

    <h1 class="board-name-list">공지사항</h1>
    
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
                    </thead>


                <c:forEach var="board" items = "${boardList}">

                <c:set var="memberId" value="${board.memberId}"/>

                    <tbody>
                        
                        <td>${board.boardNo}</td>
                        <td> <a href="${contextPath}/admin/AdminBoardList/detail?no=${board.boardNo}">${board.boardTitle}</a></td>
                        <td></td>
                        <td>${board.boardDate}</td>
                    </tbody>
                     

                </c:forEach>

</section>
                    </table>
                    
                    
                     <!-- 페이지네이션 -->
                    <div class="K-qna-page">
                        <c:set var="url" value="${contextPath}/board?type=1&cp="/>
                        <ul class="K-pagination">
                            <!-- 첫 페이지로 이동 -->
                            <li><a href="${url}1$${searchUrl}">&lt;&lt;</a></li>
                            <!-- 이전 목록 마지막 번호로 이동 -->
                            <li><a href="${url}${pagination.prevPage}${searchUrl}">&lt;</a></li>

                            <!-- 범위가 정해진 일반 for문 사용 -->
                            <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                                <c:choose>
                                    <c:when test="${i==pagination.currentPage}">
                                        <li><a class="K-current">${i}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${url}${i}${searchUrl}">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <!-- 다음 목록 시작 번호로 이동 -->
                            <li><a href="${url}${pagination.nextPage}${searchUrl}">&gt;</a></li>
                            <!-- 끝 페이지로 이동 -->
                            <li><a href="${url}${pagination.maxPage}${searchUrl}">&gt;&gt;</a></li>
                        </ul>

                    </div>

                </c:if>

            </div>

           
        </div>

    </div>

 
        </div>
    </main>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/boardList.js"></script>
</body>
</html>