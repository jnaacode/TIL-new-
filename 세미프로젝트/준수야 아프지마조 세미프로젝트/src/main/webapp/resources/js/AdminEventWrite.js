// 미리보기 관련 요소
const preview = document.getElementsByClassName("k-preview");
const inputImg = document.getElementsByClassName("k-inputImg");
const deleteImg = document.getElementsByClassName("k-deleteImg");

// 수정 시 삭제된 이미지 레벨 저장할 input 요소
const deleteList = document.getElementById("deleteList");

const deleteSet = new Set(); // 순서 상관없, 중복 X

// 파일 읽어서 미리보기 세팅
for (let i = 0; i < inputImg.length; i++) {

    inputImg[i].addEventListener("change", function () {

        if (this.files[0] != undefined) {

            const reader = new FileReader(); // 파일 읽는 객체 생성

            reader.readAsDataURL(this.files[0]); // 파일 읽고 result에 저장 -> url 통해서 이미지 볼 수 있음

            reader.onload = function (e) {

                preview[i].setAttribute("src", e.target.result); // 미리보기 img 태그 src 세팅

                deleteSet.delete(i);
            }


        } else { // 파일이 선택되지 않음 == 파일 선택했다가 확인이 아닌 취소가 눌렸을 때
            preview[i].removeAttribute("src");
        }



    });

    deleteImg[i].addEventListener("click", function(){

        if(preview[i].getAttribute != null) { // 미리보기가 원래 있다가 삭제한 경우에만 실행해라

            preview[i].removeAttribute("src"); // 미리보기 삭제

            inputImg[i].value=""; // 파일에 있는 value값 삭제

            deleteSet.add(i); // 삭제된 이미지레벨 추가
        }

    });
}
/* let Tdate = new Date();

let timeOff = new Date().getTimezoneOffset() * 60000;
let today = new Date(Tdate - timeOff).toISOString().split("T")[0];
document.getElementById("K-date").setAttribute("min", today); */
let Tdate = new Date();

let tomorrow = new Date(Tdate);
tomorrow.setDate(Tdate.getDate()+1);

let timeOff = new Date().getTimezoneOffset() * 60000;
let today = new Date(tomorrow - timeOff).toISOString().split("T")[0];
document.getElementById("K-date").setAttribute("min", today);


// 게시글 유효성 검사
function eventValidate(){
    
    const eventTitle = document.getElementsByName("K-title")[0];
    const eventContent = document.getElementsByName("K-content")[0];
    const first = document.getElementsByClassName("K-first")[0];
    const date = document.getElementById("K-date");
    const thumbnail = document.getElementById("k-img0");

    if(eventTitle.value.trim().length == 0) {
        alert("제목을 입력해주세요");
        eventTitle.value = "";
        eventTitle.focus();
        return false;
    }
    if(date.value == ""){
        alert("마감일을 설정해주세요");
        return false;
    }

    /* if(thumbnail.value == ""){
        alert("썸네일을 설정해주세요");
        return false;
    } */



    if(eventContent.value.trim().length == 0) {
        alert("내용을 입력해주세요");
        eventContent.value = "";
        eventContent.focus();
        return false;
    }

    deleteList.value = Array.from(deleteSet);

    return true;

}

document.getElementById("K-cancel").addEventListener("click", function(){
    if(confirm("작성을 취소하시겠습니까?")){
        const pathname = location.pathname; // /kHotel/admin/eventWrite
        let url = pathname.substring(0,pathname.indexOf("/", 1)); // /kHotel // 최상위주소

        url += "/admin/memberAdmin?type=1";

        location.href = url;
    }
})
