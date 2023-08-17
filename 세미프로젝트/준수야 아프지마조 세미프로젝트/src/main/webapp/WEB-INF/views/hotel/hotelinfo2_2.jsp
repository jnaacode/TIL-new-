<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/hotelSidebar.css">

    <link rel="stylesheet" href="${contextPath}/resources/css/hotelinfo2_2.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <title>호텔소개-종로</title>
</head>

<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>


    <div class="L-maindisplay">
        <!-- 사이드바 -->
        <!-- <div class="L-side">
            <ul class="L-sidelist">
                <li>K-호텔 소개</li>
                <a href="#">
                    <li>강남점</li>
                </a>
                <a href="#">
                    <li>종로점</li>
                </a>
                <a href="#">
                    <li>당산점</li>
                </a>
            </ul>
        </div> -->

        <jsp:include page="/WEB-INF/views/common/hotelSidebar.jsp"/>

        <!-- 호텔 소개 -->
        <div class="L-main">

            <!-- 지점 소개 -->
            <div class="L-hotelpoint">
                <div>지점 소개</div>
                <div>
                    <img src="${contextPath}/resources/images/hoteljongro.png" alt="" id="L-hotel1">
                </div>
                <div>
                    <pre>
K호텔 종로는 서울 시내 비즈니스와 쇼핑의 중심지인 명동과 서울의 오아시스인 청계천 근처에 위치하고 있으며, 
27층 규모의 탁 트인 전망과 435개의 객실과 
뷔페 레스토랑, 미팅룸, 피트니스 등을 갖춘 프리미엄 비즈니스 호텔입니다. 
성공적인 비즈니스와 만족스런 여행을 위한 최고의 실용성과 차별화된 서비스, 
합리적인 가격으로 휴식이 필요한 비즈니스 고객과 여행객 모두에게 잊지 못할 추억을 선사합니다.
                    </pre>
                </div>
            </div>

            <!-- 객실 소개 -->
            <div class="L-roompoint-main">
                <div class="L-roompoint">객실 소개</div>
                <div class="L-roompoint-1">

                    <!-- 파라미터로 넘겨줄 값 설정 -->
                    <input type="hidden" name="memberNo" value="${loginMember.memberNo}">
                    <!-- 객실명 -->
                    <input type="hidden" name="roomNm1" value="DELUXE">
                    <input type="hidden" name="roomNm2" value="STANDARD">
                    <input type="hidden" name="roomNm3" value="SUITE">
                    <!-- 호텔명 -->
                    <input type="hidden" name="hotelNm2" value="JONGRO">
                    <!-- 찜하기 -->
                    <input type="hidden" id="Llike1" name="Llike1" value="0">
                    <input type="hidden" id="Llike2" name="Llike2" value="0">
                    <input type="hidden" id="Llike3" name="Llike3" value="0">


                    <!-- 객실1 -->
                    <div class="L-roompoint-border L-roomA" id="LroomG1">
                        <img src="${contextPath}/resources/images/Deluxe-Room_JongRo_1.jpg" class="L-roomimg" id="L-room1">
                        <!-- <button type="button" id="L-hbtn">찜하기♡</button> -->
                        <pre>
 <p>디럭스 룸</p> 침대타입 <span>|</span> 더블/트윈 사이즈 
 투숙인원 <span>|</span> 성인 2인 기준, 최대 3인 
 객실면적 <span>|</span> 46.3㎡
                        </pre>
                    </div>
                    <div class="L-roompoint-border L-roomA1" id="LroomG2" >
                        <img src="${contextPath}/resources/images/standard-Room_JongRo_2.jpg" class="L-roomimg1" id="L-room2">
                        <!-- <button type="button" id="L-hbtn">찜하기♡</button> -->
                        <pre>
 <p>스탠다드 룸</p> 침대타입 <span>|</span> 더블 사이즈
 투숙인원 <span>|</span> 성인 2인 기준, 최대 3인 
 객실면적 <span>|</span> 57.0㎡
                        </pre>
                    </div>
                    <div class="L-roompoint-border L-roomA" id="LroomG3">
                        <img src="${contextPath}/resources/images/suite-Room_JongRo_2.jpg" class="L-roomimg" id="L-room3">
                        <!-- <button type="button" id="L-hbtn">찜하기♡</button> -->
                        <pre>
 <p>스위트 룸</p> 침대타입 <span>|</span> 킹 사이즈 
 투숙인원 <span>|</span> 성인 2인 기준, 최대 3인 
 객실면적 <span>|</span> 124.4㎡
                        </pre>
                    </div>
                </div>
            </div>

            <!-- 오시는 길 -->
            <div class="L-roadmain">
                <div class="L-road">오시는 길</div>
                <div class="L-map-main">
                    <div class="L-map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d50599.26710986499!2d126.91093802167967!3d37.5679212!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357ca2eee632d73f%3A0x15cc2733ad91fd28!2zS0gg7KCV67O06rWQ7Jyh7JuQ!5e0!3m2!1sko!2skr!4v1690875092970!5m2!1sko!2skr" width="300" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                    <div class="L-address">
                        <pre>
주소 : 서울특별시 중구 남대문로 120
전화번호 : 1544-9970
                        </pre>
                    </div>
                </div>
            </div>


        </div>
    </div>


    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>






    <script src="${contextPath}/resources/js/hotelinfo2_2.js"></script>
</body>

</html>