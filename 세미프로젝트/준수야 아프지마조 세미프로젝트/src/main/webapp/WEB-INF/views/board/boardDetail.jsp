<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>
 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>질문게시판 상세페이지</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <link rel="stylesheet" href="${contextPath}/resources/css/boardDetail.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/reply.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>

    <c:set var="bmi" value="${board.memberId}"/>
    <c:set var="length" value="${fn:length(bmi)}"/>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    
    <div class="L-main">

        <div class="L-title1">질문게시판 상세페이지</div>
        
        <form class="L-form-main" method="POST" action="${contextPath}/board/qna/update?type=2&cp=${param.cp}&no=${param.no}">

            <div class="L-title L-detail">
                <div>제목</div>
                <div>${board.boardTitle}</div>
            </div>

            <div class="L-person L-detail">
                <div>작성자</div>
                <div><input type="text" name="L-input-person" value="***${fn:substring(bmi,3,length)}" disabled></div>
                
                <div>작성일</div>
                <div><input type="text" name="L-date" value="${board.boardDate}"disabled></div>
            </div>


            <div class="L-text L-detail">
                <div>내용</div>
                <div>${board.boardContent}</div>
            </div>

            <div class="L-btn">
                <div><button type="button" onclick="location.href='${contextPath}/board/qna?type=2&cp=1'">목록으로</button></div>

                <c:if test="${loginMember.memberId == board.memberId || loginMember.memberAdmin == 'Y'.charAt(0)}">
                    <div><button type="submit">게시글 수정</button></div>
                    <div><button type="button" id="LdeleteBtn">게시글 삭제</button></div>
                </c:if>

            </div>

            <input type="hidden" name="boardTitle" value="${board.boardTitle}">
            <input type="hidden" name="boardContent" value="${board.boardContent}">
            <input type="hidden" name="boardDate" value="${board.boardDate}">
            <input type="hidden" name="memberId" value="${board.memberId}">
        </form>

        <jsp:include page="/WEB-INF/views/board/reply.jsp"/>


    </div>

    ${loginMember.memberAdmin}

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>





    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/boardDetail.js"></script>
    
    <script>
        
        // 최상위 주소
        const contextPath = "${contextPath}";
        
        // 게시글 번호
        const boardNo = "${board.boardNo}";
        
        // 로그인한 회원 번호
        const loginMemberNo = "${loginMember.memberNo}";

        // 관리자 코드넘겨주기
        const loginAdmin = "${loginMember.memberAdmin}";
        
        </script>

    <script src="${contextPath}/resources/js/reply.js"></script>
</body>
</html>