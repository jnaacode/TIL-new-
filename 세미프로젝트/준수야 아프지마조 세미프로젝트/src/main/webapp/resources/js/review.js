
const inputImage = document.getElementsByName("JreviewImage")[0];
const preview = document.getElementById("J-reviewImage3");
const deleteBtn = document.getElementById("J-delBtn");
const inputF = document.getElementById("J-reviewImage2");

const star5 = document.getElementById("5-stars");
const star4 = document.getElementById("4-stars");
const star3 = document.getElementById("3-stars");
const star2 = document.getElementById("2-stars");
const star1 = document.getElementById("1-star");

const stars = document.getElementsByName("rating");

inputImage.addEventListener("change", function(){

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













function update(){
     return  confirm("작성을 완료하시겠습니까?");
}
/* document.getElementById("J-update").addEventListener("click", function(){

    confirm("작성을 완료 하시겠습니까?");
}) */

document.getElementById("J-delBtn").addEventListener("click",function(){

    const del = document.getElementById("J-delete");

    if(del.value == 0){ // 눌러지지 않은 상태

        // 1) 프로필 이미지를 지움
        document.getElementById("J-reviewImage3").setAttribute("src", "" + "");
        
        document.getElementById("J-reviewImage2").value = "";
    }
})

// 밑에 세 줄 주석처리된 건 필요하면 풀어서 써
//const star5 = document.getElementById("5-stars");

const star = document.getElementsByClassName("star2");
//const star2 = document.getElementsByClassName("star3")[0];


/* for(let i = 0 ; i < star.length ; i++){


        if(star[i].checked = true){

            star[0].value = 1;
            star[1].value = 2;
            star[2].value = 3;
            star[3].value = 4;
            star[4].value = 5;



                
        }

}
 */
const checkbox1 = document.getElementsByName("tag")[0];
const checkbox2 = document.getElementsByName("tag")[1];
const checkbox3 = document.getElementsByName("tag")[2];
const checkbox4 = document.getElementsByName("tag")[3];
const checkbox5 = document.getElementsByName("tag")[4];
const checkbox6 = document.getElementsByName("tag")[5];

    

/* 태그가 선택 되었을때 */
const tag = document.getElementsByClassName("tag");

for(let i = 0 ;  i < tag.length ; i++){
    
    if(tag[i].checked == true  && tag[i].value == 'N'){

        tag[i].value = 'Y';
    }else if(!tag[i].checked){
        tag[i].value == 'N';
    }
}


// form태그 제출 방지
function reviewVaildate(){
    if(inputF.value==""){
        alert("사진을 첨부해주세요.");
        return false;
    }

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