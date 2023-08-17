const pwInput = document.getElementById("deleteMember-password-check");
const checkbox = document.getElementById("agree");
function deleteMember(){

    if(pwInput.value.trim().length == 0){
        alert("회원의 비밀번호를 입력해주시기 바랍니다.");
        return false;
    }else if(!checkbox.checked){
        alert("약관 동의에 체크해주시기 바랍니다.");
        return false;
    }else{
       return confirm("탈퇴를 진행하시겠습니까? (주의!!보유하신 쿠폰 및 개인 정보가 전부 사라집니다.)");
    }
}
