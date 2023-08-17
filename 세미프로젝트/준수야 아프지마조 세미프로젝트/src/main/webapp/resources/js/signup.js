document.getElementsByClassName("J-H1-1")[0].addEventListener("click", function () {

    const input = document.getElementsByClassName("J-J1-1")[0];


})



document.getElementsByClassName("J-J1-1")[0].addEventListener("input", function () { // 아이디 정규식

    const regExp = /^\w{6,12}$/;

    const green = document.getElementsByClassName("J-J1-11")[0];


    if (regExp.test(this.value)) {

        green.innerText = "올바른 형식입니다.";
        green.style.color = "green";
        green.style.font.width = "bold";


    } else {

        green.innerText = "알맞지 않는 형식입니다.";
        green.style.color = "red";
    }

    if (this.value == "") {
        green.innerHTML = "";
    }
})


document.getElementsByClassName("J-J1-2")[0].addEventListener("input", function () { // 비밀번호 정규식

    const regExp = /^([A-Z]|[a-z]|[0-9]|[~\!\@\$]){8,15}$/;

    const green = document.getElementById("J-H2-1");

    if (regExp.test(this.value)) {

        green.innerText = "올바른 형식입니다.";
        green.style.color = "green";
        green.style.font.width = "bold";
    } else {

        green.innerText = "비밀번호 형식이 유효하지 않습니다.";
        green.style.color = "red";
    }

    if (this.value == "") {
        green.innerText = "";
    }

})

/* document.getElementById("J-H3-1").addEventListener("click", function () {

    const pw1 = document.getElementsByClassName("J-J1-2")[0];
    const pw2 = document.getElementsByClassName("J-J1-3")[0];

    if (pw1.value == "" | pw2.value == "") {
        alert("비밀번호 혹은 비밀번호 확인을 입력해주세요.");
    } else if (pw1.value == pw2.value) {
        alert("비밀번호가 일치합니다.");
    } else {
        alert("비밀번호가 일치하지 않습니다.");
        return false;
    }

}) */


document.getElementsByClassName("J-J1-3")[0].addEventListener("input", function () {

    const pw1 = document.getElementsByClassName("J-J1-2")[0];
    const pw2 = document.getElementById("J-J3-1");
    if (pw1.value.trim().length > 8 | this.value.trim().length > 8) {
        pw1.style.color = "black";
    }

    if (this.value == pw1.value) {
        pw2.innerHTML = "비밀번호가 일치 합니다.";
        pw2.style.color = "green";
    } else {
        pw2.innerHTML = "비밀번호가 일치하지 않습니다.";
        pw2.style.color = "red";
    }

    if (this.value == "") {
        pw2.innerHTML = "";
    }

})


document.getElementsByClassName("J-J1-2")[0].addEventListener("input", function () {

    const pw1 = document.getElementsByClassName("J-J1-3")[0];
    const pw2 = document.getElementById("J-J3-1");

    if (this.value.trim().length >= 8) {


        if (this.value.trim() == pw1.value.trim()) {
            pw2.innerHTML = "비밀번호가 일치 합니다.";
            pw2.style.color = "green";
        } else {
            pw2.innerHTML = "비밀번호가 일치하지 않습니다.";
            pw2.style.color = "red";
        }
    } else {
        pw2.innerHTML = "";
    }



})



/* -------------------------------------------------------------------------- */
function sample6_execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function (data) {
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
            if (data.userSelectedType === 'R') {
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
                    extraAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if (data.buildingName !== '' && data.apartment === 'Y') {
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if (extraAddr !== '') {
                    extraAddr = ' (' + extraAddr + ')';
                }

            } else {
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('J-sample6_postcode').value = data.zonecode;
            document.getElementById("J-sample6_address").value = addr;
            // 커서를 상세주소 필드로 이동한다.
            document.getElementById("J-sample6_detailAddress").focus();
        }
    }).open();
}
/* --------------------------------------------------------------------------- */
const memberTel = document.getElementsByName("memberTel")[0];





const input = document.getElementById("J-signUpBtn");

input.addEventListener("click", function () { // 빈칸 있을 시 가입 안됨

    const input2 = document.getElementsByClassName("J-A");

    for (let item of input) {

        if (item.value == "") {

            alert("빈칸이 존재합니다. 다시 입력해주세요.")

            item.focus();

            return false;
        }
    }
})

const id = document.getElementsByClassName("J-J1-1")[0];
const pw1 = document.getElementsByClassName("J-J1-2")[0];

const pw2 = document.getElementsByClassName("J-J1-3")[0];

const tel = document.getElementsByClassName("J-Tel")[0];

const check = document.getElementsByClassName("J-check0"); // 동의

const check2 = document.getElementsByClassName("J-check2"); // 전체

const check3 = document.getElementsByClassName("J-check3"); // 동의하지 않음


const pno1 = document.getElementsByClassName("J-pno")[0];

const pno2 = document.getElementsByClassName("J-pno2")[0];

const memberName = document.getElementsByClassName("J-name")[0];

const memberEmail = document.getElementsByClassName("J-memberEmail")[0];

const idBtn = document.getElementById("J-idBtn");

idBtn.value = 2;

pno1.addEventListener("input", function(){

    if(this.value.trim().length == 6){
        pno2.focus();
    }
})

function signUp() {
    const input = document.getElementsByTagName("input");


    const regExp = /^0(1[01679]|2|[3-6][1-5]|70)\d{3,4}\d{4}$/; /* 전화번호 정규식 */

    const regExp2 = /^[0-9]{6}$/; /* 주민번호 앞자리 */
    const regExp3 = /^[0-9]{7}$/; /* 주민번호 뒷자리 */
    const regExp4 = /^([가-힣]|[A-z]){0,20}$/; /* 이름 */
    const regExp5 = /^[\w\-\_]{4,}@[\w\-\_]+(\.\w+){1,3}$/; /* 이메일 형식 */
    const regExp6 = /^([A-Z]|[a-z]|[0-9]|[~\!\@\$]){8,15}$/; /* 비밀번호 정규식 */
    const regExp7 = /^\w{6,12}$/; /* 아이디 */

    if(idBtn.value == 1){
        alert("이미 사용중인 아이디 입니다. 다시 입력해주세요.");
        
        return false;
    }else if(!regExp7.test(id.value) ){
        alert("아이디 형식이 일치하지 않습니다. 다시 입력해주세요.");

        return false;

    }else if(!regExp6.test(pw1.value)){
        alert("비밀번호 형식이 일치하지 않습니다. 다시 입력해주세요.");

        return false;

    }else if (pw1.value != pw2.value) {

        alert("비밀번호와 비밀번호확인이 일치하지 않습니다. 다시 입력해주세요.");

        return false;

    }else if (!regExp4.test(memberName.value)) {
        alert("이름 형식이 올바르지 않습니다. 다시 입력주세요.");

        return false;

    }else if (!regExp2.test(pno1.value)) {
        alert("주민번호 앞자리를 다시 입력주세요.");

        return false;

    }else if (!regExp3.test(pno2.value)) {
        alert("주민번호 뒷자리를 다시 입력주세요.");

        return false;

    }else if (!regExp.test(tel.value)) {
        alert("전화번호 형식이 일치하지 않습니다. 다시 확인해주세요!");

        return false;

    }else if (!regExp5.test(memberEmail.value)) {
        alert("이메일 형식이 올바르지 않습니다. 다시 입력주세요.");

        return false;

    }else if(idBtn.value == 2){
        alert("아이디 중복 확인을 해주세요.");

        return false;
    }
   

        if (!check[0].checked == true && idBtn.value == 0) {
            alert("필수약관에 동의하셔야 가입이 가능합니다.");


            return false;

        }else if(!check[1].checked == true && idBtn.value == 0){
            alert("필수약관에 동의하셔야 가입이 가능합니다.");


            return false;
        }

        
    for (let item of input) {

        if (item.value.trim().length == 0) {
            alert("빈칸이 존재합니다. 다시 입력해 주세요.");

            return false;
        } else {

        }
        
    }
    
    return confirm("이대로 가입하시겠습니까?");






}


function duplication() {

    const id = document.getElementsByClassName("J-J1-1")[0];
    const regExp = /^\w{6,12}$/;

    $.ajax({
        url: contextPath + "/member/signUp/duplication",
        data: { "memberId": id.value },
        type: "GET",

        success: function (result) {

            if (result > 0) { // 아이디가 중복임

                if (id.value == "") {
                    alert("아이디를 입력해주세요.");
                       


                } else if (!regExp.test(id.value)) {

                    alert("아이디 형식이 올바르지 않습니다.");
                    

                } else {

                    alert("이미 사용중인 아이디 입니다. 다시 입력해주세요.");
                    idBtn.value = 1;
                    console.log(idBtn.value)

                    
                }

            } else {

                if (id.value == "") {
                    alert("아이디를 입력해주세요.");
                } else if (!regExp.test(id.value)) {

                    alert("아이디 형식이 올바르지 않습니다.");

                } else {

                    alert("사용 가능한 아이디 입니다.");
                    idBtn.value = 0; 
                }
            }
        }

    })


}



