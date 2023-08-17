<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>이벤트</title>
            <link rel="stylesheet" href="resources/css/event.css">
            <link rel="stylesheet" href="resources/css/eventSidebar.css">

            <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

            <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
            <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
                integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
                crossorigin="anonymous">
        </head>

        <body>

            <!-- 해더 -->
            <jsp:include page="/WEB-INF/views/common/header.jsp" />

            <div class="P-top">

                <!-- 사이드바 -->
                <jsp:include page="/WEB-INF/views/common/eventSidebar.jsp" />

                <div class="P-maindisplay">


                    <div class="P-main">
                        <div class="P-blank1">진행 중인 이벤트</div>

                        <div class="P-eventmain">

                            <div class="P-eventmain1">
                                <div class="P-event-list">
                                    <a href="${contextPath}/event/bingo" class="P-event">
                                        <img src="${contextPath}/resources/images/빙고 게임 이미지.png" alt="빙고 썸넬 사진"  onclick="return JeventFL()"> 
                                        <div class="P-event1">
                                            <div class="P-event-name">빙고 게임</div>
                                        </div>
                                    </a>

                                </div>

                                <div class="P-event-list">
                                    <a href="${contextPath}/event/updown" class="P-event">
                                        <img src="${contextPath}/resources/images/업다운게임_이미지.jpg" alt="업다운 썸넬 사진">
                                        <div class="P-event1">
                                            <div class="P-event-name">업다운 게임</div>
                                        </div>
                                    </a>

                                </div>

                                <c:forEach var="Img" items="${eventList}">
                                    <div class="P-event-list">
                                        <a href="${contextPath}/event/detail?no=${Img.eventNo}" class="P-event">
                                            <img src="${contextPath}${Img.imgRename}">
                                            <div class="P-event1">
                                                <div class="P-event-name">${Img.eventTitle}</div>
                                            </div>
                                        </a>

                                    </div>
                                </c:forEach>
                            </div>
                        </div>

                        <div class="P-blank2"></div>

                    </div>

                </div>
                

            </div>
            </div>


            <jsp:include page="/WEB-INF/views/common/footer.jsp" />

        

           

            <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
                crossorigin="anonymous"></script>

                <script src="${contextPath}/resources/js/event.js"></script>
        </body>

        </html>