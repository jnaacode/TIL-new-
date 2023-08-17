<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>관리자 FAQ 리스트</title>


            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We"
                crossorigin="anonymous">
            <link rel="stylesheet" href="${contextPath}/resources/css/AdminFaqList.css">
            <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
            <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
            <link rel="stylesheet" href="${contextPath}/resources/css/boardSidebar.css">
        </head>

        <body>



            <jsp:include page="/WEB-INF/views/common/header.jsp" />

            <div id="k-qList-content">

                <jsp:include page="/WEB-INF/views/common/boardSidebar.jsp" />

                <div class="k-qna">


                    <div>FAQ</div>

                    <div class="k-faq"> <!-- faq -->

                        <c:if test="${empty boardList}">
                            <div class="K-none">게시글이 존재하지 않습니다.</div>
                        </c:if>

                        <c:if test="${!empty boardList}">



                            <c:forEach var="board" items="${boardList}">
                                <div class="k-faq-slide">
                                    <span>${board.boardTitle}</span>
                                    <div class="k-arrow-img"></div>
                                    <!-- <img src="../images/arrow_down.png" class="k-arrow"> -->
                                </div>
                                <div class="k-faq-content">
                                    <div>
                                        ${board.boardContent}
                                    </div>
                                    <form action="admin/FAQUpate?no=${board.boardNo}" method="post">
                                        <input type="hidden" name="boardNo" value="${board.boardNo}">

                                        <c:if test="${loginMember.memberAdmin.toString() eq 'Y'}">
                                            <div class="k-btns">
                                                    <button type="submit" class="k-mod-btn">수정</button>
                                                    <input type="hidden" name="title" value="${board.boardTitle}">
                                                    <input type="hidden" name="content" value="${board.boardContent}">
                                                <button type="button" onclick="deleteFaq(${board.boardNo}, this)"
                                                    class="k-del-btn">삭제</button>
                                            </div>
                                        </c:if>
                                    </form>
                                </div>
                            </c:forEach>

                        </c:if>

                    </div>


                </div>

            </div>

            



            <jsp:include page="/WEB-INF/views/common/footer.jsp" />

            <script>
                const contextPath = "${contextPath}";
                const type = "${param.type}"
            </script>


            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj"
                crossorigin="anonymous"></script>
            <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
            <script src="${contextPath}/resources/js/AdminQnaList.js"></script>
        </body>

        </html>