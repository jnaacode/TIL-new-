const PopupOutBtn = document.getElementById("P-popup-outbtn");  /* x 버튼 */
const PopupDeclar = document.getElementById("P-popup-Declar"); /* 신고하기창 */
const PrsDeclarBtn = document.getElementById("P-rs-Declar-btn"); /* 신고버튼 */



function fn_find() {
  $("#search").show();
}


document.getElementById("P-popup-outbtn").addEventListener("click", function () {

  PopupDeclar.style.display = "block"


})

/* 신고버튼 눌렀을때 창 뜨기 */
document.getElementById("P-rs-Declar-btn").addEventListener("click", function () {

  PopupDeclar.style.display = "block"

})

/* x 눌렀을때 눌렀을때 창 뜨기 */
document.getElementById("P-popup-outbtn").addEventListener("click", function () {

  PopupDeclar.style.display = "none"

})

const Pdeclarbtn = document.getElementById("P-declar-btn"); /* 신고하기 창 신고 내용 작성 */
const Ppcontent = document.getElementById("P-popup-content"); /* 신고하기 창 신고하기 버튼 */


const boardNo = document.getElementsByName("boardNo")[0];
const memberNo = document.getElementsByName("memberNo")[0];
// 신고하기 내용 DB에 저장하기 
Pdeclarbtn.addEventListener("click", function () {

  if (Ppcontent.value.trim().length == 0) {
    alert("신고 내용을 작성한 후 버튼을 주세요.")
    Ppcontent.focus();
  }

  $.ajax({

      url: "declar",
      data: {
        "Ppcontent": Ppcontent.value,
        "boardNo": boardNo.value,
        "memberNo": memberNo.value
      },
      success: function (result) {

        if(result>0){
          alert("신고되었습니다.")

        }else{
          alert("신고 등록이 실패되었습니다.")
        }


      },
      error: function (req, status, error) {
        console.log("신고실패")

      }


  })

})


function appendText() {
  const tagTop2Elements = document.querySelectorAll(".P-tag-top2");

  for (let i = 0; i < tagTop2Elements.length; i++) {
      tagTop2Elements[i].style.visibility = "visible";
  }
}