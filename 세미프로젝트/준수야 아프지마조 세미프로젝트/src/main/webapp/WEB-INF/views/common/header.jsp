<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>header</title>
    <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    

</head>

<body>
  <!-- 헤더 -->
        <div class="P-container">
            <div class="P-header">
    
                <div class="P-header_left">
                    <div class="P-blank">
                        
                    </div>
    
                    <div class="P-btn1">
                            <a href="${contextPath}/hotelinfo/main" >호텔소개 <i class="fa-solid fa-magnifying-glass"></i></a>
               
                            <a href="${contextPath}/book/roomChoice">예약 <i class="fa-solid fa-calendar-days"></i></a>
                    </div>
                </div>
     
                <!-- 로고 클릭 시 메인페이지로 이동 -->
                <div>
                    <a href="${contextPath}" class="P-header_middle">
                        <img src="${contextPath}/resources/images/logo_b_2.png" alt="">
                    </a>
                </div>
                
                <div class="P-header_right">
                    <!-- 로그인 -->
              
                        <div class="P-btn2">
                            <ul>
                                <c:if test="${! empty loginMember}">
                                    <a href="${contextPath}/member/logout">로그아웃</a>
                                    <span> | </span>
                                    <a href="${contextPath}/member/mypage">마이페이지</a>
                                    <span>${loginMember.memberName} 님 환영합니다.</span> <!-- 임시 -->
                                    <c:if test="${loginMember.memberAdmin.toString() eq 'Y'}">
                                        <a href="${contextPath}/admin/memberAdmin?type=1">
                                            <button>관리자</button>
                                        </a>
                                    </c:if>
                                 
                                </c:if>

                                <c:if test="${empty loginMember}">
                                    <a href="${contextPath}/member/login">로그인</a>
                                    <span> | </span>
                                    <a href="${contextPath}/member/signUp">회원가입</a>
                                </c:if>
                            </ul>
                        </div>
        
              
                        <div class="P-btn3">
                                <a href="${contextPath}/board?type=1">커뮤니티</a>
                               <a href="${contextPath}/event" >이벤트</a>
                            
                        </div>
         
    
                </div>
                
            </div>
        </div>

    


    </body>

</html>