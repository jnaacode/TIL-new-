<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>내가 쓴 글(리뷰)</title>
            <link rel="stylesheet" href="${contextPath}/resources/css/mypage(wirte).css">
            <link rel="stylesheet" href="${contextPath}/resources/css/sidebar.css">
            <link rel="stylesheet" href="${contextPath}/resources/css/footer.css"><!-- 풋터 스타일 -->
            <link rel="stylesheet" href="${contextPath}/resources/css/header.css"> <!-- 헤더 스타일 -->
            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

            <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
        </head>

        <body>

            <jsp:include page="/WEB-INF/views/common/header.jsp" />

            <div class="P-top">
                <!--  사이드바 -->
                <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />

                <div class="P-maindisplay">
                    <!-- QNA 메인 글자 -->
                    <div class="P-main">
                        <div class="P-blank1">Reivew</div>

                        <!-- 드롭박스 -->
                        <!-- <div class="P-dropdown">
                            <select name="" id="" onchange="location.href=this.value">
                                <option value="">선택하세요</option>
                                <option value="${contextPath}/member/mypageQna">QnA</option>
                                <option value="${contextPath}/member/mypageWirte">Reivew</option>
                            </select>
                        </div> -->

                        <div class="P-dropdown"></div>

                        <!-- QnA 항목 이동 링크 -->
                        <div class="P-wirte-1">
                            <div class="P-wirte">
                                <div>게시글 번호</div>
                                <div>게시글 제목</div>
                                <div></div>
                                <div>작성시간</div>
                                <div>상세내역</div>
                            </div>

                            <c:forEach var="board" items="${boardList}">
                                <div class="P-wirte">
                                    <div>${board.boardNo}</div>
                                    <div>${board.boardTitle}</div>
                                    <div></div>
                                    <div>${board.boardDt}</div>
                                    <button class="P-wirte-btn" onclick="location.href='${contextPath}/board/review/show?cp=1&no=${board.boardNo}'">상세내역</button>
                                </div>
                            </c:forEach>



                        
                        </div>

                        

                    </div>
                </div>

            </div>

            </div>

            <jsp:include page="/WEB-INF/views/common/footer.jsp" />

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>
        </body>

        </html>