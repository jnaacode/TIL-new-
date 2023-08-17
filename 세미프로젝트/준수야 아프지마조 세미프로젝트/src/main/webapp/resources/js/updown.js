const random = Math.floor(Math.random() * 50 + 1); // 1부터 50까지 난수 생성

const btn = document.getElementById("p-udg-btn");

const input = document.getElementById("p-udg-input2");

const ta = document.getElementById('emailMessage');

let count = 0; // 입력한 횟수 저장 변수

//ta.innerHTML=random;

/* btn.addEventListener("click", function () {
    inputcheck();
}) */

/* function key(event) {
    if (event.key == "Enter") {
        inputcheck();
    }
} */

console.log("정답 : " + random);


function inputcheck() {

    const alll = document.getElementsByClassName("P-udg")[0]

    $.ajax({

        url : contextPath + "/event/updown/fl",

        success : function(result){
            console.log(result);

            //alert("fdgaklfdakl;");
        },

        error : function(){
            console.log("ajax fl 오류발생");
        }


    });
    

    

    if (isNaN(input.value)) { // 숫자가 아닌 수를 입력할 경우
        ta.innerText = "";
        alert("숫자를 입력해주세요");
        input.value = "";
        input.focus();
        return false; // 함수 종료
    } else if(1>input.value || input.value > 50){
        alert("1~50 사이의 숫자를 입력해주세요");
        input.value = "";
        input.focus();
        return false; // 함수 종료
    } else{
        if (input.value.trim().length == 0) { // 공백 입력한 경우

            input.value = "";
            input.focus();

            ta.innerText = "값을 입력해주세요";

            return false;

        } else {

            const upDiv = document.createElement("div");
            upDiv.innerText = "---- UP ----"
            const downDiv = document.createElement("div");
            downDiv.innerText = "---- DOWN ----"
            const answerDiv = document.createElement("div");
            answerDiv.innerText = "---- 정답입니다. ----"
            const myDiv = document.createElement("div");
            myDiv.innerText = input.value;
            myDiv.style.fontWeight = "bold";

            alll.append(myDiv);

            if (input.value == random) {
                
                $.ajax({
                    
                    url : contextPath + "/event/updown/coupon",

                    
                    
                    success : function(result){
                        alert("정답입니다! 쿠폰함을 확인해주세요.");
                    },

                    error : function(){
                        console.log("오류발생");
                    }

                });
                

                return true;
            }

            if (input.value > random) {
                alll.append(downDiv);
            }

            if (input.value < random) {
                alll.append(upDiv);
            }

            input.value = "";
            input.focus();

            ta.innerText = "";
            count++;


            if (input.value != random &&count == 5) { // 5번 입력했을 경우
                // function 실행
                alert("기회 5번 모두 소진하였습니다. 게임 실패");
                return true;
            }


            return false;
        }


    }

}

document.getElementsByClassName("P-game")[0].addEventListener("click",function(){

    const udgbody = document.getElementById("P-udg-body");
    const udgtitle = document.getElementById("P-udg-title");
    const udg = document.getElementById("P-udg");
    const inputarea = document.getElementById("p-input-area");
    const udgbtn = document.getElementById("p-udg-btn");

    this.style.display = "none";

    udgbody.style.visibility = "visible"; 
    udgtitle.style.visibility = "visible"; 
    udg.style.visibility = "visible";
    inputarea.style.visibility = "visible";
    udgbtn.style.visibility = "visible";



})
