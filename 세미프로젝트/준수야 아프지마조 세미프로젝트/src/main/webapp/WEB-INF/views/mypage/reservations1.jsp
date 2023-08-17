<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>현재예약내역</title>

            <link rel="stylesheet" href="${contextPath}/resources/css/reservations1.css">

            <script src="https://code.jquery.com/jquery-3.7.0.min.js"
                integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>





        </head>

        <body>

            <main>

                <jsp:include page="/WEB-INF/views/common/header.jsp" />

                <div class="J-BODY">
                
                        <jsp:include page="/WEB-INF/views/common/sidebar.jsp" />

                    <div class="J-BODY3">

                        <div class="J-J">
                            <div class="J-J1">
                                현재 예약 내역

                            </div>

                            <div class="J-J2" id="J-body">

                                <c:if test="${empty rvList}">
                                <div>현재 예약이 없습니다.</div>
                                 </c:if>
                                <c:forEach var="list" items="${rvList}">
                                    <form action="reviewCancel" method="get" onsubmit="return reservationcheck()">
                                    <div class="accordion test" id="accordionExample">
                                        
                                        <div class="accordion-item">
                                            <h2 class="accordion-header" id="headingOne">
                                                <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                                    data-bs-target="#collapseOne" aria-expanded="true"
                                                    aria-controls="collapseOne">
                                                    예약 번호 : <input type="text" value="${list.bookNo}" name="bookNo" readonly>
                                                </button>
                                            </h2>
                                            <div id="collapseOne" class="accordion-collapse collapse show"
                                                aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                                                <div class="accordion-body">
                                                    
                                                    <div class="J-PIC">
                                                        <img src="${contextPath}${list.roomImage}">
                                                    </div>
                                                    <div class="J-text">
                                                        <input type="" placeholder="호텔지점" value="${list.hotelName}"
                                                            name="hotelName" readonly>
                                                        <input type="" placeholder="객실명" value="${list.roomName}"
                                                            name="roomName" readonly>
                                                        <input type="" placeholder="체크인 날짜" value="${list.checkInTime}"
                                                            name="checkIn" readonly>
                                                        <input type="" placeholder="체크 아웃 날짜"
                                                            value="${list.checkOutTime}" name="checkOut" readonly>
                                                        <c:if test="${list.calSt == 'Y'}">
                                                            <input type="" placeholder="체크 아웃 날짜" value="결제 상태 : 결제완료"
                                                                name="checkOut" readonly>
                                                        </c:if>
                                                        <c:if test="${list.calSt == 'N'}">
                                                            <input type="" placeholder="체크 아웃 날짜" value="결제 상태 : 대기 중"
                                                                name="checkOut" readonly>
                                                        </c:if>
                                                        <button type="submit" id="J-btn">예약 취소</button>
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


                <jsp:include page="/WEB-INF/views/common/footer.jsp" />


            </main>




            <script src="${contextPath}/resources/js/reservations1.js"></script>
        </body>

        </html>