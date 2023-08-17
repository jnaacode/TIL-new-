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
    <title>질문게시판(Q/A)</title>

    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
   integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
    crossorigin="anonymous">
    <link rel="stylesheet" href="${contextPath}/resources/css/qnaList.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">

</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <c:if test="${!empty param.select}">
        <c:set var="searchUrl" value="&select=${param.select}&sContent=${param.sContent}"/>
    </c:if>

    <div id="k-qList-content">


        <jsp:include page="/WEB-INF/views/common/boardSidebar.jsp"/>
        
        <div class="k-qna">

            <div>

                <div>질문게시판</div>

                <div>
                        <button id="q-btn"  onclick="location.href='write?mode=insert&type=${param.type}&cp=${param.cp}'"   >게시글 작성</button>
                </div>
            </div>

            <div class="K-qnaList"> <!-- 질문게시판 목록 -->

                
                <c:if test="${empty boardList}">
                    <div id="K-none">게시글이 존재하지 않습니다.</div>
                </c:if>
                
                <c:if test="${!empty boardList}">
                    <div class="k-q-list k-title">
                        <div>No</div>
                        <div>글 제목</div>
                        <div></div>
                        <div>작성자</div>
                        <div>작성일</div>
                    </div>

                    <div id="k-empty"></div>

                    <c:forEach var="board" items = "${boardList}">

                    <c:set var="memberId" value="${board.memberId}"/>

                        <a href="${contextPath}/board/qna/boardDetail?type=2&cp=${pagination.currentPage}&no=${board.boardNo}${searchUrl}" style="text-decoration: none;">
                            <div class="k-q-list">
                                <div>${board.boardNo}</div>
                                <div>${board.boardTitle}</div>
                                <div></div>
                                <div>${fn:substring(memberId, 0, fn:length(memberId) - 3)}***</div>
                                <div>${board.boardDate}</div>
                            </div>
                        </a>

                    </c:forEach>

                     <!-- 페이지네이션 -->
                    <div class="K-qna-page">
                        <c:set var="url" value="${contextPath}/board/qna?type=2&cp="/>

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

           
            <form action="${contextPath}/board/qna" id="K-search-form" onsubmit="return searchValidate()">
                <input type="hidden" name="type" value="${param.type}">
                <div class="k-search-div"> <!-- 하단 검색 부분 -->
                    <div>
                        <select name="select" id="k-search">
                            <option value="1">제목 + 내용</option>
                            <option value="BOARD_TITLE">제목</option>
                            <option value="BOARD_CONTENT">내용</option>
                        </select>
                    </div>
                    <div><input type="search" name="sContent" id="k-search-c"></div>
                    <div><img src="${contextPath}/resources/images/search.png"></div>
                    <div>
                        <button id="k-search-btn">검색</button>
                    </div>
                </div>
            </form>
        </div>

    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
      
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/qnaList.js"></script>
</body>
</html>