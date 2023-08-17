<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원 탈퇴</title>

 
    <link rel="stylesheet" href="${contextPath}/resources/css/deleteMember.css">
</head>

<body>
    <!-- 헤더 -->
    <jsp:include page="/WEB-INF/views/common/header.jsp"/>
    <!-- 헤더 -->
    <!-- 바디 -->
    <form action="deleteMember" method="post" onsubmit="return deleteMember()">
        <div class="C-deleteMember-container">
            <div class="C-deleteMember-body">
                <jsp:include page="/WEB-INF/views/common/sidebar.jsp"/>
                <div class="C-delete-main">
                    <div class="C-delete-main-div">
                        <div class="C-delete-title">회원탈퇴</div>
                        <div class="C-delete-title2">회원님의 정보를 안전하게 보호하기 위해 비밀번호를 다시 한번 확인합니다.</div>
                        <div class="C-delete-inputpassword-div">
                            <div class="C-deleteMemberpassword-div">
                                <div class="C-deleteMember-table">
                                    <div>비밀번호 입력 :  </div>
                                    <div>
                                        <input type="password" name="C-deleteMember-Pw" id="deleteMember-password-check">
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="C-secession-div">
                            
                            <div class="C-secession-title">회원 탈퇴 약관</div>
                            <pre id="secession-terms">
제1장 총칙
제1조 (목적)
이 약관은 전기통신사업법령 및 정보통신망이용촉진 및 정보보호 등에 관한 법률에 
따라 K-HOTEL에서 제공하는 모든 서비스(이하 `서비스`)의 이용절차,조건등 
서비스 이용과 회사와 회원의 권리 및 의무에 관련된 사항을 규정함을 목적으로 함.

제2조 (약관의 효력과 변경)
1.본 약관은 회원이 신규 가입 시 "약관에 동의합니다"라는 물음에 회원이 "동의" 
버튼을 클릭 하는 것으로 효력이 발생됩니다.

2.회사는 필요한 경우 약관을 변경할 수 있으며, 변경된 약관은 적용일 전 7일간 
온라인 상의 공지나 전자 우편 등의 방법을 통해 회원에게 공지되고 적용일에 효력
이 발생됩니다.

3.회원은 변경된 약관에 동의하지 않을 경우, 서비스 이용을 중단하고 탈퇴할 
수 있습니다.

4.약관이 변경된 이후에도 계속적으로 서비스를 이용하는 경우에는 회원이 약관의 
변경 사항에 동의한 것으로 봅니다.

제3조 (약관 외 준칙)
1.이 약관에 명시되지 않은 사항이 전기통신기본법, 전기통신사업법, 기타 
관계법령에 규정 되어 있을 경우에는 그 규정에 따릅니다.

2.회사는 약관 이외에 개별 서비스에 대한 세부적인 사항을 정할 수 있으며, 
그 내용은 해당 서비스의 이용안내 및 별도의 이용 동의 절차를 통해 공지합니다.

제2장 회원 가입과 서비스 이용

제4조 (이용계약)
서비스 이용계약은 회원이 회사가 정한 약관에 동의하고, 회사에 가입 및 
서비스 이용을 신청하며, 회사가 이를 허락하는 것 으로 이루어집니다.

제5조 (이용신청)
1.본 서비스를 이용하기 위해서는 회사가 정한 소정의 가입신청서에 
이용자의 정보를 기록해야 합니다.

2.가입신청 양식에 기재된 모든 이용자 정보는
반드시 실제 정보와 동일해야 합니다.
실제 정보를 입력하지 않거나 사실과 다른 정보를 입력한 사용자는
법적인 보호를 받을 수 없습니다.

제6조 (이용신청의 승낙)
1.회사는 회원이 모든 사항을 정확히 기재하여 
신청할 경우 서비스 이용을 승낙합니다.
단, 아래의 경우는 승낙을 거부하거나 취소할 수 있습니다.

a .실명이 아닌 경우

b .본인의 주민등록번호가 아닌 경우

c .이용신청 시 필요내용을 허위로 기재하여 신청한 경우

d .사회의 안녕 질서 또는 미풍양속을 저해할 목적으로 신청한 경우

e .전기통신기본법, 전기통신사업법, 
정보통신 윤리강령, 정보통신 윤리위원회 심의규정

, 프로그램 보호법 및 기타관련 법령과 약관이 금지하는 행위를 한 경우

f .마호에 해당하는 사유로 형사처벌을 받은 경우

g .마호에 해당하는 사유로 다른 서비스제공회사로부터 
서비스 이용이 거절된 경력이 있는 경우

h .기타 회사가 정한 이용신청 요건에 맞지 않을 경우

i .만14세 미만의 아동이 부모 등의 법정대리인의 동의를 얻지 않은 경우
2.회사는 기술적인 이유나 정책 등의 이유로 인해
이용신청의 승낙을 보류할 수 있습니다.

3.회사는 회원 가입을 위하여 필요한 정보를 요구할 수 있으며, 
회원가입 이후에도 추가정보의 입력을 요구할 수 있습니다.

4.회사는 회원이 온/오프라인 이벤트에 참여하거나, 상품 구매시에
제출 또는 취득한 개인정보를 보유할 수 있으며,동 정보를 회원이 
가입시 입력한 회원의 정보에 추가 또는 수정할 수 있습니다.

5.4 항의 내용에 따라 추가 또는 수정하여 보유할 수 있는 
개인정보는 다음과 같습니다.
전자우편주소, 우편번호, 주소,전화번호, 이동전화번호, 이벤트 응모일, 
상품 구매일, 상품 구매내역, 자동차보험 만기일

제7조 (회원 아이디 관리)
1.회원의 아이디와 비밀번호에 관한 모든 관리책임은 회원에게 있습니다.

2.회원이 등록한 아이디 및 비밀번호에 의하여 발생되는 사용상의 과실 
제 3자에 의한 부정사용 등에 대한 모든 책임은 해당 회원에게 있습니다.

제8조 (계약 사항의 변경)
회원은 서비스이용 신청 시 기재한 사항이 변경되었을 경우,
즉시 수정하여야 합니다.

부칙
본 약관의 적용일자 이전 가입자 또한, 본 약관의 적용을 받습니다.                   
                            </pre>
                        </div>
                        <div class="C-deleteMember-checkbox">
                            <input type="checkbox" name="agree" id="agree">
                            <label>위 약관에 동의합니다.</label>
                            <button id="info-update-btn">탈퇴</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </form>
    <!-- 바디 -->
    <!-- 풋터 -->
    <footer>

	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>

    </footer>
    <!-- 풋터 -->

    <script>
        const loginMemberPw = "${loginMember.memberPw}";

    </script>

    <script src="${contextPath}/resources/js/deleteMember.js"></script>
</body>

</html>