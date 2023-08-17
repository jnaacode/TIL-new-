// 내 정보 (수정) 페이지 

const memberNickname = document.getElementById("memberNickname");
const memberTel = document.getElementById("memberTel");
const updateInfo = document.getElementById("updateInfo");

// jsp에서 memberNickname 속성 값이 많아서 
// 다른 곳에서 오류 날 수 있기에 아래와 같이 작성 할 수 있다. 
// if(memberNickname!=null){} 
// 아니면 아래와 같이 id 속성값을 줘서 작성할 수 있다.

// 내 정보 수정 form태그가 존재할 때 (내 정보 페이지)
if (updateInfo != null) {

    // 전역변수로 수정하기 전 닉네임/전화번호를 저장
    initNickname = memberNickname.value;
    initTel = memberTel.value;

    //닉네임 유효성 검사 
    memberNickname.addEventListener("input", () => {

        // 변경 전 닉네임과 입력 값이 값을 경우 
        if(initNickname == memberNickname.value){
            memberNickname.removeAttribute("style");
            return;
        
        }else{
            // 정규표현식으로 유효성 검사 
            const regEx = /^[가-힣\w\d]{2,10}$/;

            if(regEx.test(memberNickname.value)){
                memberNickname.style.color = "green";
            }else{
                memberNickname.style.color = "red";
            }
        }


    });

    //전화번호 유효성 검사 
    memberTel.addEventListener("input", () => {

        if(initTel==memberTel.value){
            memberTel.removeAttribute("style");
            return

        }else{

            const regEx =/^01[0-9]\d{3,4}\d{4}$/;
            
            if(regEx.test(memberTel.value)){
                memberTel.style.color="green";
            }else{
                memberTel.style.color="red";
            }

        }

    });

    // form 태그 제출 시 유효하지 않은 값이 있으면 제출 x
    // 함수 이름이 없다 (익명함수)
    updateInfo.addEventListener("submit", e => {

        //닉네임이 유효하지 않을 경우
    if(memberNickname.style.color=="red"){
        alert("닉네임이 유효하지 않습니다");
        memberNickname.focus();
        e.preventDefault();
        return;
    }

        //전화번호가 유효하지 않을 경우
    if(memberTel.style.color=="red"){
        alert("전화번호가 유효하지 않습니다");
        memberTel.focus();
        e.preventDefault();
        return;
    }

   })

}// if문 끝

// 비밀번호 변경 제출 시 
const changePwFrm = document.getElementById("changePwFrm") ;
const currentPw = document.getElementById("currentPw") ;
const newPw = document.getElementById("newPw") ;
const newPwConfirm = document.getElementById("newPwConfirm") ;

// 비밀번호 변경 페이지 인 경우 
if(changePwFrm != null){

    changePwFrm.addEventListener("submit",e=>{
        if(currentPw.value.trim()==""){
            alert("현재 비밀번호 입력 해주세요")
            e.preventDefault();
            currentPw.focus();
            currentPw.value="";
            return;
        }   

        //비밀번호 유효성 검사 
        const regEx = /^[A-Za-z\d\!\@\#\-\_]{6,20}$/

        if(!regEx.test(newPw.value)){
            alert("유효하지 않는 형식입니다.")
            newPw.focus();
            e.preventDefault();
            return;
        }

        //비밀번호 == 비밀번호 확인 
        if(newPw.value != newPwConfirm.value){
            alert("비밀번호가 일치하지 않습니다.")
            newPwConfirm.focus();
            newPwConfirm.value="";
            e.preventDefault();
            return;
        }
    })
  

}

// 회원 탈퇴 페이지인 경우 
const memberPw = document.getElementById("memberPw")
const agree = document.getElementById("agree");
const secessionFrm = document.getElementById("secessionFrm");

if(secessionFrm!=null){

    secessionFrm.addEventListener("submit",e=>{

        // 비밀번호 미작성
        if(memberPw.value.trim()==""){
            alert("비밀번호를 작성해주세요.")
            e.preventDefault();
            memberPw.value="";
            memberPw.focus();
            return;
        }

        // 동의 체크가 되지 않은 경우 
        if(!agree.checked){
            alert("약관동의를 체크해주세요")
            e.preventDefault();
            agree.focus();
            return;
        }

        //취소 클릭 시 
        if(!confirm("정말 탈퇴 하시겠습니까?")){
            alert("탈퇴 취소")
            e.preventDefault();
            return;
        }


    })


}
