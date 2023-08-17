const hotel_choice = document.getElementById("C-hotel-choice");
const room_choice = document.getElementById("C-room-choice");
const adult = document.getElementById("C-adult");
const child = document.getElementById("C-children");
const checkIn = document.getElementById("C-start");
const checkOut = document.getElementById("C-end");
const deluxeImg = document.getElementById("deluxeImg");
const standardImg = document.getElementById("standardImg");
const suiteImg = document.getElementById("suiteImg");




/* 오늘 날짜로 기본 값 세팅  */
var today = new Date();
var dd = String(today.getDate()).padStart(2, '0');
var mm = String(today.getMonth() + 1).padStart(2, '0'); 
var yyyy = today.getFullYear();

today = yyyy + '-' + mm + '-' + dd;

// input 요소의 값을 설정
document.getElementById("C-start").value = today;
document.getElementById("C-end").value = today;

hotel_choice.addEventListener("change",function(){
   
   if(this.value == "GANGNAM"){
      const gangnamDeluxeImg = contextPath + "/resources/images/Deluxe-Room_1.jpg";
      const gangnamStandardImg = contextPath + "/resources/images/standard-Room_1.jpg";
      const gangnamSuiteImg = contextPath + "/resources/images/suite-Room_1.jpg";
     

      deluxeImg.src = gangnamDeluxeImg;
      standardImg.src = gangnamStandardImg;
      suiteImg.src = gangnamSuiteImg;
                              /* ${contextPath}/resources/images/suite-Room_1.jpg */

   }else if(this.value == "JONGRO"){
      const jongroDeluxeImg = contextPath + "/resources/images/Deluxe-Room_JongRo_1.jpg";
      const jongroStandardImg = contextPath + "/resources/images/standard-Room_JongRo_2.jpg";
      const jongroSuiteImg = contextPath + "/resources/images/suite-Room_JongRo_2.jpg";

      deluxeImg.src = jongroDeluxeImg;
      standardImg.src = jongroStandardImg;
      suiteImg.src = jongroSuiteImg;

   }else if(this.value == "DANGSAN"){
      const dangsanDeluxeImg = contextPath + "/resources/images/Deluxe-Room_DangSan_3.jpg";
      const dangsanStandardImg = contextPath + "/resources/images/standard-Room_DangSan_3.png";
      const dangsanSuiteImg = contextPath + "/resources/images/suite-Room_DangSan_3.jpg";

      deluxeImg.src = dangsanDeluxeImg;
      standardImg.src = dangsanStandardImg;
      suiteImg.src = dangsanSuiteImg;
   }


});

/* 체크인 이벤트 발생 시 오늘 날짜보다 전 날짜를 선택한다면  */
checkIn.addEventListener("change", function(){
   if(this.value < today){ 
      alert("이전 날짜로는 예약을 진행하실 수 없습니다");

      this.value = today;
   } 
   if(this.value > checkOut.value){
      alert("체크인 날짜 이전으론 선택 할 수 없습니다.");

      this.value = today;
   }
});

checkOut.addEventListener("change", function(){

   if(this.value < checkIn.value){
      alert("체크인 날짜 이전으론 예약을 진행하실 수 없습니다");
   
      checkOut.value = today;
   }
   
});


/* 체크아웃 이벤트 발생 시 몇박인지 계산 */
document.getElementById("C-end").addEventListener("change",function(){
   const day = document.getElementById("C-countdate");
   var date1 = new Date(document.getElementById("C-start").value);
   var date2 = new Date(document.getElementById("C-end").value);
   
   var differenceInTime = date2.getTime() - date1.getTime();
   var differenceInDays = differenceInTime / (1000 * 3600 * 24);

   day.innerHTML = differenceInDays + "박";
})

var i = 0; /* 성인 버튼 카운트 변수 */
var j = 0; /* 어린이 버튼 카운트 변수 */

/* 성인 +버튼 이벤트 발생 시 인원수 출력 */
document.getElementById("C-Aplusbutton").addEventListener("click",function(){
   
   if( i < 6){
       i++
   }
   adult.value = i;
})

/* 성인 -버튼 이벤트 발생 시 인원수 출력 */
document.getElementById("C-Aminusbutton").addEventListener("click",function(){

   if( i < 7 && i > 0){
       i--
   }
   adult.value = i;
})

/* 어린이 +버튼 이벤트 발생 시 인원수 출력 */
document.getElementById("C-Cplusbutton").addEventListener("click",function(){
   
   if( j < 6){
       j++
   }
   child.value = j;
})

/* 어린이 -버튼 이벤트 발생 시 인원수 출력 */
document.getElementById("C-Cminusbutton").addEventListener("click",function(){
   if( j < 7 && j > 0){
       j--
   }
   child.value = j;
})


function reservation(){
   if (hotel_choice.value == "none") {
      alert("호텔을 선택해 주시길 바랍니다.");
      return false;
   }else if (room_choice.value == "none") {
      alert("객실을 선택해 주시길 바랍니다.");
      return false;
   }else if (checkIn.value == today) {
      alert("당일 예약은 전화 문의로만 가능합니다. 다른 날짜를 선택해 주시길 바랍니다.");
      return false;
   }else if (checkOut.value == today) {
      alert("체크아웃 날짜를 선택해 주시길 바랍니다.");
      return false;
   }else if(checkIn.value == checkOut.value){
      alert("체크인날짜와 체크아웃 날짜가 같습니다. 다시 선택해 주세요.");
      return false;
   }else if (adult.value == 0 && child.value == 0) {
      alert("인원을 선택해 주시길 바랍니다.");
      return false;
   }else if(adult.value == 0 && child.value > 0){
	  alert("미성년자는 보호자 동반 예약 진행하셔야 합니다.");
	  return false;	
   }else {

      return confirm("예약을 진행하시겠습니까?");
   }

}

const one =document.getElementById("collapseOne");
const two = document.getElementById("collapseTwo");
const three = document.getElementById("collapseThree");

document.getElementById("C-room-choice").addEventListener("click", function(){

   if(this.value == "DELUXE"){

      one.classList.add("show");
      two.classList.remove("show");
      three.classList.remove("show");

      
   }else if(this.value == "STANDARD"){
      
      one.classList.remove("show");
      two.classList.add("show");
      three.classList.remove("show");

   }else if(this.value == "SUITE"){

      one.classList.remove("show");
      two.classList.remove("show");
      three.classList.add("show");
   }else{
      one.classList.remove("show");
      two.classList.remove("show");
      three.classList.remove("show");
   }

})








/*------------------------------------객실 선택 시작----------------------------------------- */ 
/*------------------------------------객실 선택 끝----------------------------------------- */ 