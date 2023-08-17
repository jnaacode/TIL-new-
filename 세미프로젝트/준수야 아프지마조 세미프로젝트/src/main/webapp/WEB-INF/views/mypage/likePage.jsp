<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="pagination" value="${map.pagination}"/>
<c:set var="likeList" value="${map.likeList}"/>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>찜목록</title>
    <link rel="stylesheet" href="${contextPath}/resources/css/couponList.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>   

   
</head>

<body>
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div class="C-body-container">
        <div class="C-body-coupon">
            <jsp:include page="/WEB-INF/views/common/sidebar.jsp"/>
            <div class="C-body-couponlist">
                <div class="C-couponlist-div">
                    <div class="C-couponlist-title">찜 목록</div>

                     <c:if test="${empty likeList}">
	                    <div class="C-coupon-null">
	                       찜하신 객실이 없습니다. 
	                    </div>
                    </c:if>
                    
                     <c:if test="${!empty likeList}"> 
                        <c:forEach var="like" items="${likeList}">
					
                            <div class="C-likelist-inner">
                                <div class="C-innerlike-img">
                                    <img src="${contextPath}${like.roomImage}" class="C-like-img">
                                </div>
                                <div class="C-inner-text">
                                    <ul>
                                        <li> 호텔 지점명 : ${like.hotelName}</li>
                                        <li></li>
                                        <li> 객실명 : ${like.roomName}</li>
                                        <li></li>
                                        <li> 객실 가격 : ${like.roomPrice}</li>
                                    </ul>
                                </div>
                            </div>
                         </c:forEach>  
                     </c:if> 



                </div>
                 <div class="c-coupon-page">
                        <c:set var="url" value="${contextPath}/member/mypage/likePage?cp="/>

                        <ul class="c-pagination">
                            <!-- 첫 페이지로 이동 -->
                            <li><a href="${url}1$${searchUrl}">&lt;&lt;</a></li>
                            <!-- 이전 목록 마지막 번호로 이동 -->
                            <li><a href="${url}${pagination.prevPage}${searchUrl}">&lt;</a></li>

                            <!-- 범위가 정해진 일반 for문 사용 -->
                            <c:forEach var="i" begin="${pagination.startPage}" end="${pagination.endPage}">
                                <c:choose>
                                    <c:when test="${i==pagination.currentPage}">
                                        <li><a class="c-current">${i}</a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li><a href="${url}${i}${searchUrl}">${i}</a></li>
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
    </div>
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
 
       
        
</body>

</html>