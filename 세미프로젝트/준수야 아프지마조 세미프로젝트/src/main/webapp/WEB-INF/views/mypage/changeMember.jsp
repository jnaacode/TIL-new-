<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 정보 수정</title>

    <link rel="stylesheet" href="${contextPath}/resources/css/header.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/footer.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/changeMember.css">
    <link rel="stylesheet" href="${contextPath}/resources/css/sidebar.css">

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"
        integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g=" crossorigin="anonymous"></script>
</head>

<body>

    <jsp:include page="/WEB-INF/views/common/header.jsp"/>

    <div class="K-all">

        <jsp:include page="/WEB-INF/views/common/sidebar.jsp"/> <!-- 사이드바 -->

        <div class="L-main">

            <form action="changeMember" class="L-form" method="post" onsubmit = "return changeMember()">
                <div class="K-content"> <!-- 찐 내용 -->
                    <div>회원 정보 수정</div>
                    <div>회원님의 정보를 쉽게 확인하실 수 있습니다.</div>

                    <c:set var="memberPno" value="${loginMember.memberPno}"/>
                    <c:set var="addr" value="${fn:split(loginMember.memberAddress, ',,') }"></c:set>

                    <div>
                        <table>
                            <tr>
                                <td><label for="L-name">이름</label></td>
                                <td colspan="2"><input type="text" placeholder="수정할 이름" class="L-input" id="L-name" name="L-name" autocomplete="off" value="${loginMember.memberName}"></td>
                            </tr>
                            <tr>
                                <td>주민등록번호</td>
                                <td colspan="2">${fn:substring(memberPno, 0,8)}******</td>
                            </tr>
                            <tr>
                                <td><label for="L-id">아이디</label></td>
                                <td colspan="2">${loginMember.memberId}</td>
                            </tr>
                            <tr>
                                <td><label for="L-email">이메일</label></td>
                                <td colspan="2"><input type="text" placeholder="수정할 이메일" class="L-input" id="L-email" name="L-email" autocomplete="off" value="${loginMember.memberEmail}"></td>
                            </tr>
                            <tr>
                                <td><label for="L-tel">휴대전화</label></td>
                                <td colspan="2"><input type="text" placeholder="수정할 휴대전화 번호" class="L-input" id="L-tel" name="L-tel" autocomplete="off" value="${loginMember.memberTel}"></td>
                            </tr>
                            <tr>
                                <td><label for="L-address">주소</label></td>
                                <td><input type="text" placeholder="수정할 우편번호" class="L-input" name="L-address" id="L-address1" value="${addr[0]}"></td>
                                <td><button class="L-searchBtn" onclick="L_addBtn()">우편번호 찾기</button></td> <!-- 우편번호 -->
                            </tr>
                            <tr>
                                <td name="L-addressTd"></td>
                                <td colspan="2"><input type="text" placeholder="수정할 주소" class="L-input" name="L-address" id="L-address2"  value="${addr[1]}"></td>
                            </tr>
                            <tr>
                                <td name="L-addressTd"></td>
                                <td colspan="2"><input type="text" placeholder="수정할 상세주소" class="L-input" name="L-address" id="L-address3" autocomplete="off" value="${addr[2]}"></td>
                            </tr>
                        </table>

                        <div class="K-agree">
                            <div>
                                <span>개인정보 마케팅 활용 동의</span> <br>
                                <span>K-Hotel에서의 개인정보 마케팅 활용에 동의하시겠습니까?</span>
                            </div>
                            <div>
                                <button class="K-agree-btn" type="button">약관 확인</button>
                            </div>
                        </div>
                        <div class="K-agree-confirm">
                            <label for="K-agree1">동의함</label><input type="radio" id="K-agree1" name="K-agree1" checked>
                            <label for="K-disagree1">동의하지 않음</label><input type="radio" id="K-disagree1" name="K-agree1"
                                disabled>
                                <!-- checked, disabled부분은 값을 가져와 함수로 바꿔서 유동적으로 바뀔 수 있게 해야함 -->
                        </div>
                        <div class="K-agree">
                            <div>
                                <span>개인정보 제3자 제공 동의</span> <br>
                                <span>K-Hotel서비스 제공을 위한 개인정보 제3자 제공에 동의하시겠습니까?</span>
                            </div>
                            <div>
                                <button class="K-agree-btn1" type="button">약관 확인</button>
                            </div>
                        </div>
                        <div class="K-agree-confirm">
                            <label for="K-agree2">동의함</label><input type="radio" id="K-agree2" name="K-agree2" checked>
                            <label for="K-disagree2">동의하지 않음</label><input type="radio" id="K-disagree2" name="K-agree2"
                                disabled>
                        </div>
                    </div>

                    <div>
                        <button type="submit" id="K-update-btn">개인 정보 수정</button>
                    </div>
                </div>

                <div class="K-popup"></div>
                <div class="K-pop">
                    <div>
                        <a href="#">
                            <button type="button" class="K-pop-btn">X</button>
                        </a>
                    </div>
                    <div>
                        <pre>
전자적 전송매체(SMS/MMS/이메일)를 통해, K-HOTEL
이 제공하는 이벤트/혜택 등 다양한 정보(뉴스레터 포함)
를 수신하실 수 있고, 기타 유용한 과옥나 정보를 수신
하실 수 있습니다.

본 마케팅 활용 및 광고성 정보수신 동의 항목은 선택
사항이므로 동의를 거부하는 경우에도 K-HOTEL 서비스
의 이용에는 영향이 없습니다. 다만 거부시 동의를 통해
제공 가능항 각종 혜택을 받아 보실 수 없습니다.
                            </pre>
                    </div>
                </div>
                <div class="K-popup"></div>
                <div class="K-pop1">
                    <div>
                        <button type="button" class="K-pop-btn">X</button>
                    </div>
                    <div>
                        <pre>
다음과 같이 개인정보를 제 3자에게 제공하고 있습니다.

K-호텔은 개인정보 보호법 제22조 제4항과 
제 39조의 3에 따라사용자의 광고성 정보 수신과 
이에 따른 개인정보 처리에 대한 동의를
받고 있습니다.

① 개인정보 수집 항목

-> 이름, 휴대폰 번호, 이메일, 생년월일, 주소

② 개인정보 수집 이용 목적

-> 이벤트 운영 및 광고성 정보 전송 및
   서비스 관련 정보 전송

③ 보유 및 이용 기간

-> 회원 탈퇴 시까지

④ 전송 내용

-> 혜택 정보, 이벤트 정보, 상품 정보, 신규 서비스 안내
   의 광고성 정보 제공
                            </pre>
                    </div>
                </div>
            </div>
        </form>
    </div>

    <jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
    <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
    <script src="${contextPath}/resources/js/confirmMember.js"></script>
    <script src="${contextPath}/resources/js/changeMember.js"></script>

</body>

</html>