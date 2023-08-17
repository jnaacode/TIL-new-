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

    <link rel="stylesheet" href="${contextPath}/resources/css/hotelinfo2_3.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <title>호텔소개-당산</title>
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
                    <img src="${contextPath}/resources/images/hoteldangsan.png" alt="" id="L-hotel1">
                </div>
                <div>
                    <pre>
K호텔 당산은 서울에 머무는 국내외 비즈니스 고객과 관광객을 위한 객실특화형 프리미엄 비즈니스 호텔입니다. 
공항철도와 지하철을 비롯한 대중교통 이용이 매우 편리하며, 서울 도심 및 시내 관광지로 접근성이 뛰어납니다. 
특히 금융, 비즈니스 중심지구인 여의도 및 서울역으로부터 차로 10분 이내 거리에 위치하며, 
서울의 주요대학인 연세대, 서강대, 이화여대, 홍익대 등이 있는 젊음의 거리 신촌 인근에 위치하고 있습니다. 
K호텔 당산은 비즈니스 회의실, 피트니스센터 및 실내수영장을 포함한 5성급 호텔 수준의 최신시설과 
차별화된 서비스로 편안한 휴식과 성공적인 비즈니스를 위한 환경을 제공합니다.
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
                    <input type="hidden" name="hotelNm3" value="DANGSAN">
                    <!-- 찜하기 -->
                    <input type="hidden" id="Llike1" name="Llike1" value="0">
                    <input type="hidden" id="Llike2" name="Llike2" value="0">
                    <input type="hidden" id="Llike3" name="Llike3" value="0">


                    <!-- 객실1 -->
                    <div class="L-roompoint-border L-roomA" id="LroomG1">
                        <img src="${contextPath}/resources/images/Deluxe-Room_DangSan_3.jpg" class="L-roomimg" id="L-room1">
                        <!-- <button type="button" id="L-hbtn">찜하기♡</button> -->
                        <pre>
 <p>디럭스 룸</p> 침대타입 <span>|</span> 더블 / 트윈 사이즈 
 투숙인원 <span>|</span> 성인 2인 기준, 최대 3인 
 객실면적 <span>|</span> 39.7㎡
                        </pre>
                    </div>
                    <div class="L-roompoint-border L-roomA1" id="LroomG2">
                        <img src="${contextPath}/resources/images/standard-Room_DangSan_3.png" class="L-roomimg1" id="L-room2">
                        <!-- <button type="button" id="L-hbtn">찜하기♡</button> -->
                        <pre>
 <p>스탠다드 룸</p> 침대타입 <span>|</span> 더블 사이즈 
 투숙인원 <span>|</span> 성인 2인 기준, 최대 3인 
 객실면적 <span>|</span> 47.4㎡
                        </pre>
                    </div>
                    <div class="L-roompoint-border L-roomA" id="LroomG3">
                        <img src="${contextPath}/resources/images/suite-Room_DangSan_3.jpg" class="L-roomimg" id="L-room3">
                        <!-- <button type="button" id="L-hbtn">찜하기♡</button> -->
                        <pre>
 <p>스위트 룸</p> 침대타입 <span>|</span> 킹 사이즈 
 투숙인원 <span>|</span> 성인 2인 기준, 최대 3인 
 객실면적 <span>|</span> 97.4㎡
                        </pre>
                    </div>
                </div>
            </div>

            <!-- 오시는 길 -->
            <div class="L-roadmain">
                <div class="L-road">오시는 길</div>
                <div class="L-map-main">
                    <div class="L-map">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3163.894477525304!2d126.8945139112505!3d37.533984671930405!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357c9ec3afc88289%3A0x4b28dfe4dc325134!2z7ISc7Jq47Yq567OE7IucIOyYgeuTse2PrOq1rCDshKDsnKDrj5ky66GcIDU3!5e0!3m2!1sko!2skr!4v1690875590299!5m2!1sko!2skr" width="300" height="300" style="border:0;" allowfullscreen="" loading="lazy" referrerpolicy="no-referrer-when-downgrade"></iframe>
                    </div>
                    <div class="L-address">
                        <pre>
주소 : 서울특별시 영등포구 선유동2로 57
전화번호 : 1544-9970
                        </pre>
                    </div>
                </div>
            </div>


        </div>
    </div>


    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>






    <script src="${contextPath}/resources/js/hotelinfo2_3.js"></script>
</body>

</html>