<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>이벤트 상세 조회</title>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>

    <link rel="stylesheet" href="${contextPath}/resources/css/eventShow.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div class="K-all">
        <div>이벤트</div>
        <div>${event.eventTitle}</div>
        <div>
            <div>
                ${event.eventContent}
            </div>

            <!-- <img src="${contextPath}${event.imageList[0].imageRename}" alt="사진"> -->

            <div>
                <c:forEach var="i" begin="0" end="${fn:length(event.imageList)-1}">
                    <div class="boardImg">
                        <c:if test="${event.imageList[i].imageLevel != 0}">
                            <img src="${contextPath}${event.imageList[i].imageRename}" alt="사진">
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        <button id="K-list-btn" type="button" onclick="location.href='${contextPath}/event'">목록으로</button>
        <c:if test="${loginMember.memberAdmin.toString() eq 'Y'}">
            <div>
                <button type="button" id="K-updateBtn" class="K-btn">수정</button>
                <button id="K-deleteBtn" class="K-btn">삭제</button>
            </div>
        </c:if>
        
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>
    

    <script src="${contextPath}/resources/js/eventShow.js"></script>
</body>
</html>