<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 변경</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/rerePw.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js" integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>
<body>


    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <div class="L-all">

        <c:set var="memberId" value="${memberId}" />

        <div class="L-main">
            <div class="L-title">비밀번호 변경</div>
            <form action="reMain" method="POST" class="L-form-pw" onsubmit="return pwValidate()">
                
                <div class="L-pw">
                    <label>새 비밀번호</label>
                    <input type="password" name="newPw" id="newPw" maxlength="30">
                </div>
                <div id="k-message"></div>
                <input type="text" name="memberId" value="${memberId}">
                <div class="L-pw-2">
                    <label>새 비밀번호 확인</label>
                    <input type="password" name="newPwConfirm" id="newPwConfirm" maxlength="30">
                </div>

                <button class="L-pw-btn">비밀번호 변경하기</button>

            </form>
        </div>

    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="${contextPath}/resources/js/rerePw.js"></script>
</body>
</html>