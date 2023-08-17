
// 새 비밀번호 입력 정규표현식 확인
document.getElementById("newPw").addEventListener("keyup", function(){

    const LM2= document.getElementById("LM2");
    const newPw2 = document.getElementById("newPw2");
    const LM3 = document.getElementById("LM3");
    

    const regExp = /^([A-Z]|[a-z]|[0-9]|[\~\!\@\$]){8,15}$/;

    if(regExp.test(this.value)){
        LM2.innerText = "올바른 비밀번호 형식입니다.";
        LM2.classList.remove("red");
        LM2.classList.add("green");
    } else{
        LM2.innerText = "올바르지 않은 비밀번호 형식입니다.";
        LM2.classList.remove("green");
        LM2.classList.add("red");
    }

    if(this.value == ""){
        LM2.innerText = "";
    }

    if(this.value == newPw2.value){
        LM3.innerText = "비밀번호가 일치합니다.";
        LM3.classList.remove("red");
        LM3.classList.add("green");
    }else{
        LM3.innerText = "비밀번호가 일치하지 않습니다.";
        LM3.classList.remove("green");
        LM3.classList.add("red");
    }

    if(newPw2.value == ""){
        LM3.innerText = "";
    }
    
});


// 새 비밀번호 확인 
document.getElementById("newPw2").addEventListener("keyup", function(){

    const newPw = document.getElementById("newPw");
    const LM3 = document.getElementById("LM3");

    if(this.value == newPw.value){
        LM3.innerText = "비밀번호가 일치합니다.";
        LM3.classList.remove("red");
        LM3.classList.add("green");
    } else{
        LM3.innerText = "비밀번호가 일치하지 않습니다.";
        LM3.classList.remove("green");
        LM3.classList.add("red");
    }

    if(this.value == ""){
        LM3.innerText = "";
    }

});



    // 비밀번호 변경하기 버튼 빈칸일때 누를시 이벤트
// document.getElementsByClassName("L-pw-btn")[0].addEventListener("click", function(){
    

//     const currentPw = document.getElementById("currentPw");
//     const newPw = document.getElementById("newPw");
//     const newPw2 = document.getElementById("newPw2");

//     if(currentPw.value.trim().length == 0){
//         alert("현재 비밀번호를 입력해주세요.");
//         return;
//     }

//     if(newPw.value.trim().length == 0){
//         alert("새 비밀번호를 입력해주세요.");
//         return;
//     }

//     if(newPw2.value.trim().length == 0){
//         alert("새 비밀번호 확인을 입력해주세요.");
//         return;
//     }

// });


// 버튼 타입 submit, 온서밋 이용해서 정규식 검사 한번 더 진행
function changePw(){
    
    const currentPw = document.getElementById("currentPw");
    const newPw = document.getElementById("newPw");
    const newPw2 = document.getElementById("newPw2");

    const regExp = /^([A-Z]|[a-z]|[0-9]|[\~\!\@\$]){8,15}$/;


    if(currentPw.value.trim().length == 0){
        alert("현재 비밀번호를 입력해주세요.");
        return false;
    }

    if(newPw.value.trim().length == 0){
        alert("새 비밀번호를 입력해주세요.");
        return false;
    }

    if(newPw2.value.trim().length == 0){
        alert("새 비밀번호 확인을 입력해주세요.");
        return false;
    }

    
    if(!regExp.test(newPw.value)){
        alert("올바르지 않은 비밀번호 형식입니다. 다시 입력해주세요.")
        return false;
    }

    if(newPw.value != newPw2.value){
        alert("비밀번호 확인이 일치하지 않습니다. 다시 입력해주세요.")
        return false;
    }
    
    return confirm("비밀번호를 변경하시겠습니까?");

};


    
