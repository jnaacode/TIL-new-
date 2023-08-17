<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>footer</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>

    <footer>

        <div class="F-first-div">
            <div class="F-f-container">
                <div class="F-f-container1">
                    <img src="${contextPath}/resources/images/logo_w_2.png" class="F-logo">
                </div>
                <div class="F-f-container2">
                    <span class="F-f-container2-1">호텔소식</span>
                    <span> | </span>
                    <span class="F-f-container2-1">갤러리</span>
                    <span> | </span>
                    <span class="F-f-container2-1">고객문의</span>
                </div>
                <div id="F-sns">
                    <div>
                        <a href="https://blog.naver.com/lotte_hotels/">
                            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/common/footer/footer-sns-blog.png" class="F-sns-img">
                        </a>
                    </div>
                    <div id="F-sns1">
                        <a href="https://www.instagram.com/shillastay_official/">
                            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/common/footer/footer-sns-instagram.png" class="F-sns-img">
                        </a>
                    </div>
                    <div>
                        <a href="https://www.youtube.com/user/LotteHotels">
                            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/common/footer/footer-sns-youtube.png" class="F-sns-img">
                        </a>
                    </div>
                    <div>
                        <a href="https://www.facebook.com/shillastay">
                            <img src="https://www.lottehotel.com/content/dam/lotte-hotel/common/footer/footer-sns-facebook.png" class="F-sns-img">
                        </a>
                    </div>
                    
                </div>
            </div>
        </div>

        <div class="F-second-div">
            <div class="F-second-div1">
                <div class="F-second-div11">
                    <span class="F-second-div1-1">케이호텔 소개</span>
                    <span> | </span>
                    <span class="F-second-div1-1">사이트맵</span>
                    <span> | </span>
                    <span class="F-second-div1-1">개인정보처리방침</span>
                    <span> | </span>
                    <span class="F-second-div1-1">이메일무단수집금지</span>
                    <span> | </span>
                    <span class="F-second-div1-1">윤리경영(부정제보)</span>
                </div>
            </div>
        </div>

        <div class="F-third-div">
            <div class="F-third-div1">
                <div>케이호텔(주) 서울특별시 강남구 테헤란로 14길 6</div>
                <div>TEL 1544-9970</div>
                <div>Copyright © 2023 khotel.co.,Ltd. All rights reserved.</div>
            </div>
            <div class="F-third-div2">
                <img src="${contextPath}/resources/images/copyright.png" class="F-third-div2-1">
            </div>
        </div>


    </footer>

    <%-- session에 message 속성이 존재하는 경우 alert 창으로 해당 내용을 출력 --%>

    <c:if test="${ !empty sessionScope.message }">
        <script>
            alert("${message}");

            // EL 작성 시 scope 지정하지 않으면
            // page -> request -> session -> application 순서로 검색하여
            // 일치하는 속성이 있으면 출력한다.
        </script>

        <%-- message 1회 출력 후 session에서 제거 --%>
        <c:remove var="message" scope="session" />

    </c:if>
    
</body>
</html>