const checkObj = {
    "newPw": false,
    "newPwConfirm": false,
};

// 비밀번호 유효성 검사
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");
const message = document.getElementById("k-message");

newPw.addEventListener("input", function () {
    if (newPw.value.trim().length == 0) {
        message.innerText = "영어, 숫자, 특수문자,(!,@,#,-,_) 8~15글자 사이로 작성해주세요.";
        message.classList.remove("k-confirm", "k-error");
        checkObj.newPw = false;  // 유효 X 기록
        return;
    }

    const regExp = /^([A-Z]|[a-z]|[0-9]|[~\!\@\$]){8,15}$/;

    if (regExp.test(newPw.value)) {

        checkObj.newPw = true;

        if (newPwConfirm.value.trim().length == 0) {

            message.innerText = "유효한 비밀번호 형식입니다.";
            message.classList.add("k-confirm");
            message.classList.remove("k-error");

            newPwConfirm.addEventListener("input", checkPw)

            function checkPw() { // 비밀번호 일치 검사

                // 비밀번호 / 비밀번호 확인이 같을 경우
                if (newPw.value == newPwConfirm.value) {
                    message.innerText = "비밀번호가 일치합니다.";
                    message.classList.add("k-confirm");
                    message.classList.remove("k-error");
                    checkObj.newPwConfirm = true;  // 유효 O 기록

                } else {
                    message.innerText = "비밀번호가 일치하지 않습니다.";
                    message.classList.add("k-error");
                    message.classList.remove("k-confirm");
                    checkObj.newPwConfirm = false;  // 유효 X 기록
                }
            }

        } else {
            checkPw();
        }


    } else {
        message.innerText = "비밀번호 형식이 유효하지 않습니다.";
        message.classList.add("k-error");
        message.classList.remove("k-confirm");
        checkObj.newPw = false;  // 유효 X 기록
    }
})



function pwValidate() {

    let str;

    for (let key in checkObj) {

        if (!checkObj[key]) {

            switch (key) {
                case "newPw": str = "비밀번호가 "; break;
                case "newPwConfirm": str = "비밀번호 확인이 "; break;
            }

            str += "유효하지 않습니다.";

            alert(str);
            document.getElementById(key).focus();
            return false;
        }
    }
    return true;
}
