document.getElementsByClassName("J-game")[0].addEventListener("click", function(){

    const bingo =  document.getElementById("J-bingo");

    const btn1 = document.getElementById("J-btn");
    const sp = document.getElementById("J-span");
    const sp2 = document.getElementById("J-span1");
    const input1 = document.getElementById("J-input");
    const input2 = document.getElementById("J-count");
    const input3= document.getElementById("J-count2");
    const input4= document.getElementById("Jerror");
    
    this.style.display = "none";

    bingo.style.visibility = "visible"; 
    btn1.style.visibility = "visible"; 
    sp.style.visibility = "visible";
    sp2.style.visibility = "visible";
    input1.style.visibility = "visible";
    input2.style.visibility = "visible";
    input3.style.visibility = "visible";
    input4.style.visibility = "visible";


    
})

function JeventFL(){

    if(Jevent == 'Y'){
        alert("금일 게임 횟수가 소멸되었습니다. 내일 다시 시도해주세요.");

        return false;
    } 
}


/* --------------------------------------------------------------------------- */

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// 수정할 사항
// "25   "이런 식으로 뛰어쓰기 포함되어 입력되었을 때도 25라고 인식할 수 있게


// 변수 생성
/* 
const td1 = document.querySelector("#tr1>td:nth-child(1)");
const td2 = document.querySelector("#tr1>td:nth-child(2)");
const td3 = document.querySelector("#tr1>td:nth-child(3)");
const td4 = document.querySelector("#tr1>td:nth-child(4)");
const td5 = document.querySelector("#tr1>td:nth-child(5)");
const td6 = document.querySelector("#tr2>td:nth-child(1)");
const td7 = document.querySelector("#tr2>td:nth-child(2)");
const td8 = document.querySelector("#tr2>td:nth-child(3)");
const td9 = document.querySelector("#tr2>td:nth-child(4)");
const td10 = document.querySelector("#tr2>td:nth-child(5)");
const td11 = document.querySelector("#tr3>td:nth-child(1)");
const td12 = document.querySelector("#tr3>td:nth-child(2)");
const td13 = document.querySelector("#tr3>td:nth-child(3)");
const td14 = document.querySelector("#tr3>td:nth-child(4)");
const td15 = document.querySelector("#tr3>td:nth-child(5)");
const td16 = document.querySelector("#tr4>td:nth-child(1)");
const td17 = document.querySelector("#tr4>td:nth-child(2)");
const td18 = document.querySelector("#tr4>td:nth-child(3)");
const td19 = document.querySelector("#tr4>td:nth-child(4)");
const td20 = document.querySelector("#tr4>td:nth-child(5)");
const td21 = document.querySelector("#tr5>td:nth-child(1)");
const td22 = document.querySelector("#tr5>td:nth-child(2)");
const td23 = document.querySelector("#tr5>td:nth-child(3)");
const td24 = document.querySelector("#tr5>td:nth-child(4)");
const td25 = document.querySelector("#tr5>td:nth-child(5)"); 
*/
const tds = document.querySelectorAll("td");
const input = document.getElementById("J-input");
const btn = document.getElementById("J-btn");
const span = document.getElementById("J-span");
const span2 = document.getElementById("J-span2");
// 숫자를 맞췄을 때 이미지


// let index = 1; //  td뒤에 붙는 숫자들....?

// 중복제거한 난수 1~25 생성
const set = new Set(); 

while(true){

    let random = Math.floor(Math.random()*50+1);

    set.add(random);

    if(set.size == 25){
        break;
    }
}

let list = "";
list = Array.from(set); // 생성한 난수 배열에 담음

//console.log((new Function("return " + "td" + 3)()))

for(let t = 0; t<25; t++){ // 테이블 안에 배열 넣기
    //console.log(list[t]);
    //console.log(eval("td"+t));
    //console.log(td2);

    //(new Function("return " + "td" + t)()).innerHTML = list[t-1];
    tds[t].innerHTML = list[t];
    
    
    
    
}

document.getElementById("J-btn").addEventListener("click", function () {

    if (isNaN(input.value)) { // 숫자가 아닌 수를 입력할 경우

        alert("숫자를 입력해주세요");
        input.value = "";
        input.focus();

    }else if (1 > input.value || input.value > 50) {
        alert("1~50 사이의 숫자를 입력해주세요");
        input.value = "";
        input.focus();

    }else if (input.value.trim().length == 0) { // 공백 입력한 경우


        alert("값을 입력해주세요");
        input.value = "";
        input.focus();


    }



})

let Jcount = document.getElementById("J-count2");
let bCount = 0;
let ACount = 0;
btn.addEventListener("click", function(){
    if(input.value.trim().length != 0){
        ++bCount;
        --Jcount.innerHTML;

    }
})





function bingo(){ // 제출되면 빋고판 새로고침 되어버림.. form태그 제출 막기
                  // 입력했을 때 일치하는 칸 있을 경우 뒷배경 색깔 변경

                 
    
            
                  

    for(let f = 0; f<25; f++){
        if(input.value === tds[f].innerHTML){
            //console.log(input.value)
            tds[f].innerHTML = "";
            tds[f].classList.add("pink"); // 배경 색상 변경
        }
    }
    input.value=""
    input.focus();

    let bing = 0;
    
    
    for(let q=0; q<25; q=q+5){ // 가로 빙고
        let count = 0;
        for(let c = 0+q; c<5+q; c++){
            if(getComputedStyle(tds[c]).backgroundColor == "rgb(255, 192, 203)"){
                count++;
                //console.log("count: "+count)
                if(count == 5){
                    bing++;
                }
                //console.log("bing : "+bing);
                span.innerHTML = bing;
                
            }
        }
        

    }

    for(let q= 0; q<5; q++){ // 세로 빙고
        
        let count = 0
        for(let c=0+q; c<21+q; c=c+5){
            if(getComputedStyle(tds[c]).backgroundColor == "rgb(255, 192, 203)"){
                count++;
                if(count == 5){
                    bing++
                }
                span.innerHTML = bing;
               
            }
        }
       
    }

    // 대각선
    // 0 6 12 18 24
    let count1 = 0;
    for(let c = 0; c<25; c=c+6){
        if(getComputedStyle(tds[c]).backgroundColor == "rgb(255, 192, 203)"){
            count1++
            if(count1 == 5){
                bing++
            }
            span.innerHTML = bing;
            
        }
        
    }

    // 4 8 12 16 20
    let count2 = 0;
    for(let c = 4; c<21; c=c+4){
        if(getComputedStyle(tds[c]).backgroundColor == "rgb(255, 192, 203)"){
            count2++
            if(count2 == 5){
                bing++
            }
            span.innerHTML = bing;
            
        }
        
    }
    
    span2.value = bing;

    if(bing == 3){
        alert("축하드립니다! 쿠폰이 지급 되었습니다. 쿠폰함에서 확인 가능합니다.");
        // ajax 사용해서 쿠폰 insert해주고
        return true;
    }

    if(bCount == 18){
        alert("실패")
        return true;
    }

   /*  if (isNaN(input.value)) { // 숫자가 아닌 수를 입력할 경우
        ta.innerText = "";
        alert("숫자를 입력해주세요");
        input.value = "";
        input.focus();
        
        return false; // 함수 종료
    }  */

    

  


    return false;
}























// console.log(list[0]);

// console.log(set);


/* // 이차원 배열

const row = 5;
const column = 5;
const arr = new Array(row);

// 이차원 배열의 열을 2로 지정
for (var i = 0; i < row; i++) {
    arr[i] = new Array(column);
}

for(let i = 0; i<arr.length; i++){
    for(let k = 0; k<arr[i].length; k++){
        let random = Math.floor(Math.random()*25+1);
        arr[i][k] = random;
    }
}

// console.log(arr); */
