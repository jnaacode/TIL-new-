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
        if (initNickname == memberNickname.value) {
            memberNickname.removeAttribute("style");
            return;

        } else {
            // 정규표현식으로 유효성 검사 
            const regEx = /^[가-힣\w\d]{2,10}$/;

            if (regEx.test(memberNickname.value)) {
                memberNickname.style.color = "green";
            } else {
                memberNickname.style.color = "red";
            }
        }


    });

    //전화번호 유효성 검사 
    memberTel.addEventListener("input", () => {

        if (initTel == memberTel.value) {
            memberTel.removeAttribute("style");
            return

        } else {

            const regEx = /^01[0-9]\d{3,4}\d{4}$/;

            if (regEx.test(memberTel.value)) {
                memberTel.style.color = "green";
            } else {
                memberTel.style.color = "red";
            }

        }

    });

    // form 태그 제출 시 유효하지 않은 값이 있으면 제출 x
    // 함수 이름이 없다 (익명함수)
    updateInfo.addEventListener("submit", e => {

        //닉네임이 유효하지 않을 경우
        if (memberNickname.style.color == "red") {
            alert("닉네임이 유효하지 않습니다");
            memberNickname.focus();
            e.preventDefault();
            return;
        }

        //전화번호가 유효하지 않을 경우
        if (memberTel.style.color == "red") {
            alert("전화번호가 유효하지 않습니다");
            memberTel.focus();
            e.preventDefault();
            return;
        }

    })

}// if문 끝

// 비밀번호 변경 제출 시 
const changePwFrm = document.getElementById("changePwFrm");
const currentPw = document.getElementById("currentPw");
const newPw = document.getElementById("newPw");
const newPwConfirm = document.getElementById("newPwConfirm");

// 비밀번호 변경 페이지 인 경우 
if (changePwFrm != null) {

    changePwFrm.addEventListener("submit", e => {
        if (currentPw.value.trim() == "") {
            alert("현재 비밀번호 입력 해주세요")
            e.preventDefault();
            currentPw.focus();
            currentPw.value = "";
            return;
        }

        //비밀번호 유효성 검사 
        const regEx = /^[A-Za-z\d\!\@\#\-\_]{6,20}$/

        if (!regEx.test(newPw.value)) {
            alert("유효하지 않는 형식입니다.")
            newPw.focus();
            e.preventDefault();
            return;
        }

        //비밀번호 == 비밀번호 확인 
        if (newPw.value != newPwConfirm.value) {
            alert("비밀번호가 일치하지 않습니다.")
            newPwConfirm.focus();
            newPwConfirm.value = "";
            e.preventDefault();
            return;
        }
    })


}

// 회원 탈퇴 페이지인 경우 
const memberPw = document.getElementById("memberPw")
const agree = document.getElementById("agree");
const secessionFrm = document.getElementById("secessionFrm");

if (secessionFrm != null) {

    secessionFrm.addEventListener("submit", e => {

        // 비밀번호 미작성
        if (memberPw.value.trim() == "") {
            alert("비밀번호를 작성해주세요.")
            e.preventDefault();
            memberPw.value = "";
            memberPw.focus();
            return;
        }

        // 동의 체크가 되지 않은 경우 
        if (!agree.checked) {
            alert("약관동의를 체크해주세요")
            e.preventDefault();
            agree.focus();
            return;
        }

        //취소 클릭 시 
        if (!confirm("정말 탈퇴 하시겠습니까?")) {
            alert("탈퇴 취소")
            e.preventDefault();
            return;
        }


    })


}

//---------------------------------------------------------------------
// 프로필 이미지 추가/변경/삭제
const profileImage = document.getElementById("profileImage");//Img 태그
const deleteImage = document.getElementById("deleteImage");//x버튼
const imageInput = document.getElementById("imageInput");//input 태그

let initCheck; //초기 프로필 이미지 상태를 저장하는 변수
// false == 기본 이미지 , true == 이전 업로드 이미지 

let deleteCheck = -1;  // 프로필 이미지가 새로 업로드 되거나 삭제 되었음을 나타내는 변수 
// -1 == 초기값, 0 == 프로필 삭제(x버튼) 1== 새 이미지 업로드 

let originalImage; // 초기 프로필 이미지 파일 경로 저장                      

if (imageInput != null) { //화면에 imageInput이 있을 경우 (왜? myPage.js 는 다른 jsp랑도 연결해서 사용중이니까!)

    // 프로필 이미지가 출력되는 img 태그의 src 속성을 저장
    originalImage = profileImage.getAttribute("src");
    console.log(originalImage)
    // 회원 프로필 화면 진입 시 현재 회원의 프로필 이미지 상태를 확인
    if(originalImage == "/resources/images/user.png"){ // 기본 이미지인 경우
        // 기본 이미지인 경우
        initCheck = false;
    } else{
        initCheck = true;
    }

    // change : 값이 변했을 때
    // - input type = "file","checkbox","radio" 에서 많이 사용
    // - text/number 형식 사용 가능
    //   -> 이때 input 값 입력 후 포커스를 잃었을 때 
    //      이전 값과 다르면 change 이벤트 발생
    imageInput.addEventListener("change", e => {

        const maxSize = 1 * 1024 * 1024 * 2 // 파일의 최대 크기 (바이트단위) = 2MB최대 크기 제한

        console.log(e.target);//input 태그 나옴 
        console.log(e.target.value) // 업로드된 파일 경로
        console.log(e.target.files) // 업로드된 파일 정보가 담긴 배열 

        const file = e.target.files[0]; // 업로드한 파일의 정보가 담긴 객체 

        // 파일을 한번 선택한 후 취소 했을 때
        if (file == undefined) {
            console.log("파일 선택이 취소됨");
            deleteCheck = -1; // 취소 == 파일 없음 -== 초기상태
            // 취소 시 기존 프로필 이미지로 변경
            profileImage.setAttribute("src", originalImage);
            return;
        }

        if (file.size > maxSize) { // 선택된 파일의 크기가 최대 크기를 초과한 경우
            alert("2MB이하의 이미지를 선택해주세요");
            imageInput.value = ""; //(이렇게 안해주면 일단 올라가 있고 db에 반영 될 수 있따.)
            // input type = "file"태그에 대입할 수 있는 value 는 ""(빈칸) 뿐이다. 

            deleteCheck = -1; // 취소 == 파일 없음 -== 초기상태

            // 기존 프로필 이미지로 변경
            profileImage.setAttribute("src", originalImage);
            return;

        }


        // JS에서 파일을 읽는 객체 
        // - 파일을 읽고 클라이언트 컴퓨터에 파일을 저장할 수 있다. 
        const reader = new FileReader();

        reader.readAsDataURL(file);
        // 매개변수에 작성된 file을 읽어서 저장 후 
        // 파일을 나타내는 URL을 result 속성으로 얻어올 수 있게 함 (파일 읽어오고!url 주소로 반환)

        // 다 읽었을때 
        reader.onload = e => {
            console.log(e.target)
            console.log(e.target.result) //: 읽은 파일의 URL 

            const url = e.target.result;
            // 프로필 이미지 (img) 태그에 src 속성으로 추가 
            profileImage.setAttribute("src", url)
            deleteCheck = 1;

            // 결론 : 이미지는 url 형식이고 읽으면 result로 반환할 수 있따! 

        }

    });

    // x 버튼 클릭 시 
    deleteImage.addEventListener("click", () => {

        // 프로필 이미지를 기본 이미지로 변경
        profileImage.setAttribute("src", "/resources/images/user.png")
        imageInput.value = ""; // input type = "file"의 value삭제 
        deleteCheck = 0;
    });

    // #profileFrm이 제출 되었을때
    document.getElementById("profileFrm").addEventListener("submit", e => {

        // let initCheck; 
        // 초기 프로필 이미지 상태를 저장하는 변수
        // false == 기본 이미지, true == 이전 업로드 이미지

        // let deleteCheck = -1;
        // 프로필 이미지가 새로 업로드 되거나 삭제 되었음을 나타내는 경우
        // -1 == 초기값, 0 == 프로필 삭제(x버튼), 1 == 새 이미지 업로드

        let flag = true;

        // 프로필 이미지가 없다 -> 있다
        if(!initCheck && deleteCheck == 1){
            flag = false;
        }

        // 이전 프로필 이미지가 있다 -> 삭제
        if(initCheck && deleteCheck == 0){
            flag = false;
        }

        // 이전 프로필 이미지가 있다 -> 새 이미지
        if(initCheck && deleteCheck == 1){
            flag = false;
        }

        if(flag){ // fals == true -> 제출하면 안되는 경우
            e.preventDefault(); // form 기본 이벤트 제거
            alert("이미지 변경 후 클릭하세요.");
        }

        

    });

}