<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 변경</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/changePw.css">
</head>
<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div class="L-all">
        <jsp:include page="/WEB-INF/views/common/sidebar.jsp"/>

        <div class="L-main">
            <div class="L-title">비밀번호 변경</div>


            <form action="changePw" method="post" onsubmit="return changePw()">

                <div class="L-pw">
                    <label for="currentPw">현재 비밀번호</label>
                    <input type="password" name="currentPw" id="currentPw" maxlength="30" placeholder="현재 비밀번호를 입력해주세요.">
                </div>

                <span class="LM" id="LM1"></span>

                
                <div class="L-pw">
                    <label for="newPw">새 비밀번호</label>
                    <input type="password" name="newPw" id="newPw" maxlength="30" placeholder="대소문자, 특수문자 포함 8~15글자">
                </div>

                <span class="LM" id="LM2"></span>

                
                <div class="L-pw">
                    <label for="newPw2">새 비밀번호 확인</label>
                    <input type="password" name="newPwConfirm" id="newPw2" maxlength="30">
                </div>

                <span class="LM" id="LM3"></span>
                

                <button class="L-pw-btn" type="submit">비밀번호 변경하기</button>
            </form>

        </div>

    </div>
    
    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>


    <script src="${contextPath}/resources/js/changePw.js"></script>
</body>
</html>