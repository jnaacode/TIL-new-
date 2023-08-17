<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- map에 저장된 값을 각각 변수에 저장 -->
<c:set var="boardName" value="${map.boardName}" />
<c:set var="LAdminPagination" value="${map.LAdminPagination}" />
<c:set var="boardList" value="${map.boardList}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자페이지 신고목록</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/AdminHeader.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/report(admin).css">
    <link rel="stylesheet" href="${contextPath}/resources/css/boardSidebar.css">

</head>
<body>

    <jsp:include page ="/WEB-INF/views/admin/AdminHeader.jsp"/>

    <div class="L-report-main">
        <jsp:include page="/WEB-INF/views/common/adminSidebar.jsp"/>

        <div class="L-report-main2">
            <!-- 메인 테이블 -->
            <table class="L-report-table">

                <tr class="L-report-title">
                    <td colspan="6">리뷰신고목록</td>
                </tr>

                <tr class="L-report-tr">
                    <th>게시글 번호</th>
                    <th>신고내용</th>
                    <th>게시글작성자</th>
                    <th>게시글작성일</th>
                    <th>신고자</th>
                    <th>버튼</th>
                </tr>


                <c:choose>
                    <c:when test="${empty boardList}">
                        <!-- 게시글 목록 조회 결과가 비어있다면 -->
                        <tr>
                            <th colspan="6">게시글이 존재하지 않습니다.</th>
                        </tr>
                    </c:when>


                    <c:otherwise>
                        <!-- 게시글이 있는 경우 -->
                        <!-- 게시글 리스트 -->
                        <c:forEach var="board" items="${boardList}">
                            <tr class="L-report-tr">
                                <td>${board.boardNo}</td>
                                <td>
                                    <textarea readonly>${board.reportContent}</textarea>
                                </td>
                                <td>${board.reportPerson}</td>
                                <td>${board.reportDt}</td>
                                <td>익명</td>
                                <td>
                                    <button onclick="location.href='${contextPath}/board/review/show?no=${board.boardNo}'">
                                        리뷰<br>
                                        확인
                                    </button>
                                </td>
                            </tr>
                        </c:forEach>
                    
                    </c:otherwise>
                </c:choose>

                

                
            </table>


            <div class="L-pagination-area">

                <c:set var="url" value="report?type=6&cp="/>
                <!-- 나중에 링크에 type 설정해주고 el태그로 변경해줘야함  -->

                
                <ul class="L-pagination">
                    <!-- 맨앞페이지 -->
                    <li><a href="${url}1">&lt;&lt;</a></li>

                    <!-- 앞페이지 - 1-->
                    <li><a href="${url}${LAdminPagination.prevPage}">&lt;</a></li>


                    <!-- for문으로 페이지네이션 만들기 -->
                    <!-- 현재 페이지에 있을때 -->
                    <c:forEach var="i" begin="${LAdminPagination.startPage}" end="${LAdminPagination.endPage}" step="1">

                        <c:choose>
                            <c:when test="${i == LAdminPagination.currentPage}">
                                <li><a class="L-current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${url}${i}">${i}</a></li>
                            </c:otherwise>
                            
                        </c:choose>
                        
                    </c:forEach>
                        
                        <!-- 뒷페이지 + 1 -->
                        <li><a href="${url}${LAdminPagination.nextPage}">&gt;</a></li>
                        
                        <!-- 맨뒤페이지 -->
                        <li><a href="${url}${LAdminPagination.maxPage}">&gt;&gt;</a></li>
                        
                </ul>



            </div>
        </div>
        
    </div>
    


    <jsp:include page ="/WEB-INF/views/common/footer.jsp"/>
    
    <script src="${contextPath}/resources/js/report(admin).js"></script>
</body>
</html>