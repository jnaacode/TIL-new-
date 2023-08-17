<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initiaP-scale=1.0">
            <title>리뷰게시판</title>
            <link rel="stylesheet" href="../resources/css/mypage(wirte).css">
            <link rel="stylesheet" href="${contextPath}/resources/css/reviewMain.css">
            <link rel="stylesheet" href="${contextPath}/resources/css/reviewShow.css">
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

            <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
        </head>

        <body>

            <c:set var="pagination" value="${map.pagination}" />
            <c:set var="boardList" value="${map.boardList}" />

            <jsp:include page="/WEB-INF/views/common/header.jsp" />

            <div class="P-pay-main">
                <!-- 사이드바 -->
                <jsp:include page="/WEB-INF/views/common/boardSidebar.jsp" />

                <div class="P-pay-main2">

                    <!-- 메인 테이블 -->
                    <table class="P-pay-table">

                        <tr class="P-pay-title">
                            <td colspan="6">리뷰게시판</td>
                        </tr>

                        

                        <tr class="P-pay-tr1">
                            <th>리뷰번호</th>
                            <th>호텔지점</th>
                            <th>객실명</th>
                            <th>작성자</th>
                            <th>작성일</th>
                            <th>상세내역</th>
                        </tr>


                        <c:choose>
                            <c:when test="${empty boardList}">
                                <!-- 게시글 목록 조회 결과가 비어있다면 -->
                                <tr>
                                    <th colspan="7">게시글이 존재하지 않습니다.</th>
                                </tr>
                            </c:when>


                            <c:otherwise>
                                <!-- 게시글이 있는 경우 -->
                                <!-- 게시글 리스트 -->
                                <c:forEach var="board" items="${boardList}">


                                <c:set var="revMi" value="${board.memberId}"/>
                                <c:set var="length" value="${fn:length(revMi)}"/>

                                    <tr class="P-pay-tr">
                                      
                                            <td>${board.boardNo}</td>
                                            <td>${board.hotelTitle}</td>
                                            <td>${board.roomName}</td>
                                            <td>***${fn:substring(revMi,3,length)}</td>
                                            <td>${board.boardDate}</td>
                                            <td><button class="Pbtn1" onclick="location.href='${contextPath}/board/review/show?no=${board.boardNo}'" >상세보기</button></td>
                                            
                                    </tr>
                                </c:forEach>

                            </c:otherwise>
                        </c:choose>




                    </table>

                    <div class="c-coupon-page">
                        <c:set var="url" value="${contextPath}/board/review/show?cp=" />

                        <ul class="c-pagination">
                            <!-- 첫 페이지로 이동 -->
                            <li><a href="${url}1${searchUrl}">&lt;&lt;</a></li>
                            <!-- 이전 목록 마지막 번호로 이동 -->
                            <li><a href="${url}${pagination.prevPage}${searchUrl}">&lt;</a></li>

                            <!-- 범위가 정해진 일반 for문 사용 -->
                            <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                                <c:choose>
                                    <c:when test="${i==pagination.currentPage}">
                                        <li><a class="c-current">${i}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${url}${i}">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <!-- 다음 목록 시작 번호로 이동 -->
                            <li><a href="${url}${pagination.nextPage}${searchUrl}">&gt;</a></li>
                            <!-- 끝 페이지로 이동 -->
                            <li><a href="${url}${pagination.maxPage}${searchUrl}">&gt;&gt;</a></li>
                        </ul>

                    </div>

                </div>

            </div>

            <jsp:include page="/WEB-INF/views/common/footer.jsp" />






            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>
        </body>

        </html>