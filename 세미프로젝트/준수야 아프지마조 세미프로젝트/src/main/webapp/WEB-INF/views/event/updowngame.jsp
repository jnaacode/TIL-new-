<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>업다운게임</title>

    <link href="https://cdn.jsdelivr.net/npm/bootsdivap@5.2.3/dist/css/bootsdivap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/7bc7245179.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/updowngame.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>

<body>

    <div class="P-top">

        <div>
            <a href="../index.jsp" class="J-header">
                <img src="../resources/images/logo_w_2.png" alt="" >
              </a>
        </div>

         <img
            src="https://media.istockphoto.com/id/1254770023/ko/%EB%B2%A1%ED%84%B0/%EC%95%84%EC%BC%80%EC%9D%B4%EB%93%9C-%EB%A8%B8%EC%8B%A0-%EC%8A%A4%ED%81%AC%EB%A6%B0-%EB%B3%B5%EA%B3%A0%ED%92%8D-%EB%B2%A1%ED%84%B0-%EB%B0%B0%EA%B2%BD.jpg?s=612x612&w=0&k=20&c=QtzUGG7fd4d6ciSpFfHqJogUQJBqKD_rs37QRmAtRpQ=">
        <div class="P-game">Up Down Game</div>

        
        
        <form action="${contextPath}/event" method="get" name="C-postWrite-main" onsubmit="return inputcheck()">
            <div class="P-udg-body" id="P-udg-body">
                <div class="P-udg-title" id="P-udg-title">업다운게임</div>

                <div>1~50 사이의 숫자를 맞히세요! 기회는 5번입니다.</div>
                
                <div class="P-udg" id="P-udg"></div>

                <div class="p-input-area" id="p-input-area">
                    <input type="text" id="p-udg-input2" name="p-udg-input2" placeholder="숫자를 입력하세요." autocomplete="off" required>

                    <button type="submit" id="p-udg-btn">입력</button>
                </div> <span class="p-udg-message" id="emailMessage"></span>

                
               
            </div>
        </form>
    </div>


    <script>

        const contextPath = "${contextPath}";
        
    </script>

    <script src="https://cdn.jsdelivr.net/npm/bootsdivap@5.2.3/dist/js/bootsdivap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
    <script src="${contextPath}/resources/js/header.js"></script> <!-- 헤더 js -->
    <script src="${contextPath}/resources/js/updown.js"></script>
</body>

</html>