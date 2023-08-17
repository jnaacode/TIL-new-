 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

    <!DOCTYPE html>
    <html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Bingo</title>

        <link rel="stylesheet" href="${contextPath}/resources/css/Bingo.css">
        
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
        
    </head>
    
    <body>
        
        
        <form action="${contextPath}/event/bingoIn" method="post" onsubmit="return bingo()">
            
            <div class="J-1">
                
                <div>
                    <a href="../index.jsp" class="J-header">
                        <img src="../resources/images/logo_w_2.png" alt="" >
                      </a>
                </div>

                 <img
                    src="https://media.istockphoto.com/id/1254770023/ko/%EB%B2%A1%ED%84%B0/%EC%95%84%EC%BC%80%EC%9D%B4%EB%93%9C-%EB%A8%B8%EC%8B%A0-%EC%8A%A4%ED%81%AC%EB%A6%B0-%EB%B3%B5%EA%B3%A0%ED%92%8D-%EB%B2%A1%ED%84%B0-%EB%B0%B0%EA%B2%BD.jpg?s=612x612&w=0&k=20&c=QtzUGG7fd4d6ciSpFfHqJogUQJBqKD_rs37QRmAtRpQ=">

                <div class="J-game" >New Game</div>

                <div id="Jerror">
                    <span>※ 필독! 빙고 유의사항</span>  <br>
                    <span>1. 1~50 사이의 수를 입력해주세요</span> <br>
                    <span>2. 숫자만 입력해주세요.</span> <br>
                    <span>3. 빈문자를 입력하지 않게 주의하세요.</span> 

                    <br>
                    <br>
                    <br>

                    <span>
                        잘못 입력 하신 후 숫자 입력 횟수가 차감되어도 저희가 책임지지 않습니다. <br>
                        <br>
                        유의사항을 꼼꼼하게 읽어 보신 후 게임을 즐겨주세요. <br><br>
                        감사합니다.
                        
                    </span>
                </div>

                <table id="J-bingo">
                    <tr id="tr1">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr id="tr2">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr id="tr3">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr id="tr4">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr id="tr5">
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    
                </table>
                    <input type="text" name="input" id="J-input" autocomplete="off">
                    <button id="J-btn" >제출</button>
                    
                    <span id="J-span1">빙고 : </span><span id="J-span" name="result"></span>
                    <span id="J-count" class="J-cc1">남은 횟수 : </span><span id="J-count2" class="J-cc2">18</span>
                    
                    <input type="hidden" id="J-span2" name="result2">
                </form>
            </div>
            <input type="hidden" value="${event.bingoFl}">

            <script>

                const Jevent = "${event.bingoFl}";
            </script>


        <script src="${contextPath}/resources/js/Bingo.js"></script>
    </body>

    </html>