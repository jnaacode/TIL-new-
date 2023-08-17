<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${contextPath}/resources/css/hotelroominfo.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
    <title>객실소개 - 강남</title>
</head>
<body>
    
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div class="C-maindisplay">
       <jsp:include page="/WEB-INF/views/common/hotelSidebar.jsp"/>
        <div class="C-main">
            <div>객실 소개 - 강남</div>
            <div class="C-hotelroominfo">
                <div class="C-info-img">
                    <div class="C-hotelroom-img">
                        <img src="${contextPath}/resources/images/Deluxe-Room_1.jpg">
                    </div>
                </div>
                <div class="C-info-text">
                    <pre>
편안하고 클래식한 느낌의 객실로 2면의 전면 유리창을 통해 
서울의 아름다운 뷰 그리고 아름다운 석양을 감상할 수 있습니다.
                    </pre>
                    <ul>
                        <li>
                            위치: 3층 / 5층
                        </li>
                        <br>
                        <li>
                            침대 타입: 더블 사이즈
                        </li>
                        <br>
                        <li>
                            전망: 한강뷰
                        </li>
                        <br>
                        <li>
                            객실 면적: 43.5㎡ (1침실, 1욕실)
                        </li>
                        <br>
                        <li>
                            최대인원: 성인 2인 기준, 최대 3인
                        </li>
                    </ul>
        
                </div>
            </div>
            <div class="C-hotelroominfo">
                <div class="C-info-text">
                    <pre>
전면 유리창을 통해 펼쳐지는 서울을 그림처럼 감상할 수 있는 
최고의 전망을 가진 객실로서 우아한 인테리어와 침실과 거실,
다이닝 등 편안한 휴식을 선사하는 최고의 객실입니다.
                    </pre>
                    <ul>
                        <li>
                            위치: 5층
                        </li>
                        <br>
                        <li>
                            침대 타입: 더블 사이즈
                        </li>
                        <br>
                        <li>
                            전망: 시티뷰
                        </li>
                        <br>
                        <li>
                            객실 면적: 57.4㎡ (1침실, 1거실, 1욕실, 1화장실, 1다이닝)
                        </li>
                        <br>
                        <li>
                            최대인원: 성인 2인 기준, 최대 3인
                        </li>
                    </ul>
                </div>
                <div class="C-info-img">
                    <div class="C-hotelroom-img">
                        <img src="${contextPath}/resources/images/standard-Room_1.jpg">
                    </div>
                </div>
            </div>
            <div class="C-hotelroominfo">
                <div class="C-info-img">
                    <div class="C-hotelroom-img">
                        <img src="${contextPath}/resources/images/suite-Room_1.jpg">
                    </div>
                </div>
                <div class="C-info-text">
                    <pre>
스위트는 서울의 파노라믹한 도시 전망을 감상할 수 있는 
현대적인 디자인으로 대형 공간에 들어서면 K 호텔이 자랑하는 
한강과 남산의 전경을 360도로 감상할 수 있다.        
                    </pre>
                    <ul>
                        <li>
                            위치: 5층
                        </li>
                        <br>
                        <li>
                            침대 타입: 킹 사이즈
                        </li>
                        <br>
                        <li>
                            전망: 한강, 시티뷰
                        </li>
                        <br>
                        <li>
                            객실 면적: 97.4㎡ (3침실, 2거실, 3욕실, 3화장실, 2다이닝)
                        </li>
                        <br>
                        <li>
                            최대인원: 성인 2인 기준, 최대 3인
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        </div>
        
        
        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
        
        <script src="${contextPath}/resources/js/hotelinfo.js"></script>
        </body>
        
        </html>