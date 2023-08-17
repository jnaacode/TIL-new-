const checkbox1 = document.getElementsByName("updateTag")[0];
const checkbox2 = document.getElementsByName("updateTag")[1];
const checkbox3 = document.getElementsByName("updateTag")[2];
const checkbox4 = document.getElementsByName("updateTag")[3];
const checkbox5 = document.getElementsByName("updateTag")[4];
const checkbox6 = document.getElementsByName("updateTag")[5];

const inputF = document.getElementById("J-reviewImage2");

const star5 = document.getElementById("5-stars");
const star4 = document.getElementById("4-stars");
const star3 = document.getElementById("3-stars");
const star2 = document.getElementById("2-stars");
const star1 = document.getElementById("1-star");


document.getElementById("J-cancle").addEventListener("click", function(){

    confirm("이전페이지로 돌아가시겠습니까?"); // if문 안에 조건문으로 넣으세요!
})

/* 이거 할 거면 reviewValidate()안에 넣으세요  */
/* document.getElementById("J-alter").addEventListener("click", function(){

    confirm("수정을 완료 하시겠습니까?");
})
 */
const inputImage = document.getElementsByName("JreviewImage")[0];
const preview = document.getElementById("J-reviewImage3"); // 수정될 이미지
const preview2 = document.getElementById("J-reviewImage4"); // 수정 전 리뷰 이미지



inputImage.addEventListener("change", function(){ // 수정될 이미지

    if(inputImage.files != undefined){
        const reader = new FileReader(); // 선택된 파일을 읽을 객체 생성
        reader.readAsDataURL(this.files[0]);

        reader.onload = function(e){ //reader가 파일을 다 읽어온 경우

            preview.setAttribute("src", e.target.result);

        } 
        
    }else{ // 파일이 선택되지 않았을 때
        preview.removeAttribute("src");
    }
})

inputImage.addEventListener("change", function(){ // 수정 전 리뷰 이미지

    if(inputImage.files != undefined){
        const reader = new FileReader(); // 선택된 파일을 읽을 객체 생성
        reader.readAsDataURL(this.files[0]);

        reader.onload = function(e){ //reader가 파일을 다 읽어온 경우

            preview2.setAttribute("src", e.target.result);

        } 
        
    }else{ // 파일이 선택되지 않았을 때
        preview.removeAttribute("src");
    }
})



// form태그 제출 방지
function reviewVaildate(){
    

    if(star1.checked == false && star2.checked == false && star3.checked == false && star4.checked == false &&star5.checked == false){
        alert("별점을 등록해주세요.");
        return false;
    }

    if(checkbox1.checked == false && checkbox2.checked == false &&checkbox3.checked == false &&checkbox4.checked == false &&checkbox5.checked == false){
        alert("태그를 선택해주세요.");
        return false;
    }

    if(document.getElementById("J-text1").value==""){
        alert("내용을 입력해주세요.");
        return false;
    }

    return true;
}


document.getElementById("J-delBtn").addEventListener("click",function(){

    const del = document.getElementById("J-delete");

    if(del.value == 0){ // 눌러지지 않은 상태

        // 1) 프로필 이미지를 지움
        document.getElementById("J-reviewImage3").setAttribute("src", "" + "");
        
        document.getElementById("J-reviewImage2").value = "";
    }
})