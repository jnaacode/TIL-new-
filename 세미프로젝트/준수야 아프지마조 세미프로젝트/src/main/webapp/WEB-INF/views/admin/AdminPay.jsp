<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="LPagination" value="${map.LPagination}" />
<c:set var="boardList" value="${map.boardList}" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 결제 관리</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/AdminPay.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/AdminHeader.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
</head>
<body>
    
    <jsp:include page="/WEB-INF/views/admin/AdminHeader.jsp"/>



    <div class="L-pay-main">
        <!-- 사이드바 -->
        <jsp:include page="/WEB-INF/views/common/adminSidebar.jsp"/>

        <div class="L-pay-main2">

            <!-- 메인 테이블 -->
            <table class="L-pay-table">
                
                <tr class="L-pay-title">
                    <td colspan="6">결제관리</td>
                </tr>
                
                <tr class="L-pay-tr1">
                    <th>결제번호</th>
                    <th>결제수단</th>
                    <th>결제금액</th>
                    <th>결제자</th>
                    <th>예약번호</th>
                    <th>체크인 날짜</th>
                    <th>승인</th>
                </tr>
            

                <c:choose>
                    <c:when test="${empty boardList}">
                        <!-- 게시글 목록 조회 결과가 비어있다면 -->
                        <tr>
                            <th colspan="7">게시글이 존재하지 않습니다.</th>
                        </tr>
                    </c:when>


                    <c:otherwise>
                        <!-- 게시글이 있는 경우 -->
                        <!-- 게시글 리스트 -->
                        <c:forEach var="board" items="${boardList}">
                            <tr class="L-pay-tr">
                                <td>${board.calculateNo}</td>
                                <td>${board.calculateWay}</td>
                                <td>${board.calculatePrice}</td>
                                <td>${board.memberId}</td>
                                <td>${board.bookNo}</td>
                                <td>${board.checkInDt}</td>
                                <td class="L-pay-btn"> 
                                    <button onclick="AgreePay(${board.calculateNo})">승인</button>
                                </td>
                            </tr>

                            <input type="hidden" name="calNo" value="${board.calculateNo}">
                            <input type="hidden" name="type" value="8">
                        </c:forEach>
                    
                    </c:otherwise>
                </c:choose>
                
                
                
                
            </table>
        
            <div class="L-pagination-area">
                
                <c:set var="url" value="pay?type=8&cp="/>
                <!-- 나중에 링크에 type 설정해주고 el태그로 변경해줘야함  -->
                
                
                <ul class="L-pagination">
                    <li><a href="${url}1">&lt;&lt;</a></li>
                    
                    <li><a href="${url}${LPagination.prevPage}">&lt;</a></li>
                    

                    <c:forEach var="i" begin="${LPagination.startPage}" end="${LPagination.endPage}" step="1">

                        <c:choose>
                            <c:when test="${i == LPagination.currentPage}">
                                <li><a class="L-current">${i}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="${url}${i}">${i}</a></li>
                            </c:otherwise>
                            
                        </c:choose>
                        
                    </c:forEach>

                    
                    <!-- 뒷페이지 + 1 -->
                    <li><a href="${url}${LPagination.nextPage}">&gt;</a></li>
                    
                    <!-- 맨뒤페이지 -->
                    <li><a href="${url}${LPagination.maxPage}">&gt;&gt;</a></li>
                    
                </ul>
                
            </div>
        
        </div>
        
    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    
    <script src="${contextPath}/resources/js/AdminPay.js"></script>
</body>
</html>