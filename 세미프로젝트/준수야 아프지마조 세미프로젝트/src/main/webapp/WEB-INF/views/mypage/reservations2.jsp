<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이전예약내역</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/reservations2.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>





</head>
<body>

    <main>

        <jsp:include page="/WEB-INF/views/common/header.jsp"/>

        <div class="J-BODY">

                <jsp:include page="/WEB-INF/views/common/sidebar.jsp"/>

            <div class="J-BODY3">

                <div class="J-J">
                    <div class="J-J1">
                        이전 예약 내역

                    </div>

                    <div class="J-J2"  id="J-body">
                        
                        <c:if test="${empty rvList}">
                            <div>현재 예약이 없습니다.</div>
                        </c:if>
                        
                        <c:forEach var="list" items="${rvList}">
                        <form action="review" method="POST">
                        <div class="accordion test" id="accordionExample" >
                            <div class="accordion-item">
                                <h2 class="accordion-header" id="headingOne">
                                    <div class="accordion-button" type="" data-bs-toggle="" data-bs-target=""
                                    aria-expanded="true" aria-controls="collapseOne">
                                        예약 번호 : <input type="text" value="${list.bookNo}" name="bookNo" readonly>
                                    </div>
                                </h2>
                                <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne"
                                    data-bs-parent="#accordionExample">
                                    <div class="accordion-body">
                                        <div class="J-PIC">
                                            <img src="${contextPath}${list.roomImage}">
                                        </div>
                                        <div class="J-text">
                                           <input type="" placeholder="호텔지점"      value="${list.hotelName}" name="hotelName" readonly>
                                           <input type="" placeholder="객실명"        value="${list.roomName}" name="roomName" readonly>
                                           <input type="" placeholder="체크인 날짜"    value="${list.checkInTime}" name="checkIn" readonly>
                                           <input type="" placeholder="체크 아웃 날짜" value="${list.checkOutTime}" name="checkOut" readonly>
                                           <button type="submit" id="J-btn">리뷰 작성</button>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                            
                        </div>
                </form>
                    </c:forEach>
                    </div>
                    
                        
                    </div>

                    




                </div>


            </div>


            
        </div>







        <jsp:include page="/WEB-INF/views/common/footer.jsp"/>



        
        
    </main>








    

    <script src="../resources/js/reservations2.js"></script>
</body>
</html>