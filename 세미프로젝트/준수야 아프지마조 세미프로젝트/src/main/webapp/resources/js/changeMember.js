

// 주소 카카오 오픈 api
function L_addBtn() {
    const Ladd1 = document.getElementById('L-address1');
    const Ladd2 = document.getElementById('L-address2');
    const Ladd3 = document.getElementById('L-address3');
    
    Ladd1.value = "";
    Ladd2.value = ""; 
    Ladd3.value = "";

    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var addr = ''; // 주소 변수
            var extraAddr = ''; // 참고항목 변수

            //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                addr = data.roadAddress;
            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                addr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
            if(data.userSelectedType === 'R'){
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraAddr !== ''){
                    extraAddr = ' (' + extraAddr + ')';
                }
                // 조합된 참고항목을 해당 필드에 넣는다.
            
            } else {
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            
            
            Ladd1.value = data.zonecode;
            Ladd2.value = addr;
            // 커서를 상세주소 필드로 이동한다.
            Ladd3.focus();
        }
    }).open();
}


// 정규표현식 실행
function changeMember(){

    // 이름 정규표현식
    const regExp2=/^([가-힣]|[A-z]){0,20}$/;

    // 전화번호 정규표현식
    const regExp=/^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/;

    // 이메일 정규표현식
    const regExp1=/^([a-z]|[A-Z]|[0-9]){1,10}\@([a-z]|[A-Z]|[0-9]){1,10}\.(kr|com|net)$/;
    

    const name = document.getElementById("L-name");
    const email = document.getElementById("L-email");
    const tel = document.getElementById("L-tel");
    const address1 = document.getElementById("L-address1");
    const address2 = document.getElementById("L-address2");
    const address3 = document.getElementById("L-address3");



    /* 이름 정규식 */
    if(!regExp2.test(name.value)){
        alert("올바르지 않은 이름 형식입니다. 다시 입력해주세요.")
        return false;
    }
    
    /* 이메일 정규식 */
    if(!regExp1.test(email.value)){
        alert("올바르지 않은 이메일 형식입니다. 다시 입력해주세요.")
        return false;
    }

    /* 전화번호 정규식 */
    if(!regExp.test(tel.value)){
        alert("올바르지 않은 전화번호 형식입니다. 다시 입력해주세요.")
        return false;
    }

    
   

    /* 수정 내용 빈칸일 시 진행 불가능 하도록 설정 */
    if(name.value.trim().length == 0){
        alert("수정할 이름을 입력해주세요.")
        return false;
    }

    if(email.value.trim().length == 0){
        alert("수정할 이메일을 입력해주세요.")
        return false;
    }

    if(tel.value.trim().length == 0){
        alert("수정할 전화번호를 입력해주세요.")
        return false;
    }

    // if(address1.value.trim().length == 0){
    //     alert("수정할 우편번호를 입력해주세요.")
    //     return false;
    // }

    // if(address2.value.trim().length == 0){
    //     alert("수정할 주소를 입력해주세요.")
    //     return false;
    // }

    // if(address3.value.trim().length == 0){
    //     alert("수정할 상세주소를 입력해주세요.")
    //     return false;
    // }

    if(address1.value.trim().length == 0){
        address1.focus();
        return false;
    }

    if(address2.value.trim().length == 0){
        address2.focus();
        return false;
    }

    if(address3.value.trim().length == 0){
        address3.focus();
        return false;
    }
    

    

    return confirm("회원정보를 수정 하시겠습니까?");


}


