// 버튼 클릭 시
function AgreePay(calculateNo){

    if(confirm("결제 승인 하시겠습니까?")){
        
        $.ajax({
    
            url : "pay",
            data : {"calculateNo" : calculateNo},
            type : "post",
    
            success : function(result){
    
                if(result > 0){
                    alert("결제 승인이 완료되었습니다.");

                    AdminPayList();
                }else{
                    alert("결제 승인중 오류 발생")
                }
    
    
            },
    
            error : function(req, status, error){
                console.log("결제 승인 실패");
                console.log(req.responseText);
            }
    
        });

    }

};


// 다시 화면에 띄워주기
function AdminPayList(){
    
    const calNo = document.getElementsByName("calNo")[0].value;


    $.ajax({

        url : "payList",
        type : "get",
        dataType : "JSON",

        success : function(LadpList){

            
            // 테이블 빈칸으로 만들기
            const table = document.getElementsByClassName("L-pay-table")[0];
            table.innerHTML = "";
            
            // 제목
            const tr1 = document.createElement("tr");
            tr1.classList.add("L-pay-title");

            const title = document.createElement("td");
            title.innerText = "결제관리";
            title.setAttribute("colspan", "6");

            tr1.append(title);

            // 리스트
            const tr2 = document.createElement("tr");
            tr2.classList.add("L-pay-tr1");

            const th1 = document.createElement("th");
            th1.innerText = "결제번호";

            const th2 = document.createElement("th");
            th2.innerText = "결제수단";

            const th3 = document.createElement("th");
            th3.innerText = "결제금액";

            const th4 = document.createElement("th");
            th4.innerText = "결제자";

            const th5 = document.createElement("th");
            th5.innerText = "결제여부";

            const th6 = document.createElement("th");
            th6.innerText = "체크인 날짜";

            const th7 = document.createElement("th");
            th7.innerText = "승인";

            tr2.append(th1, th2, th3, th4, th5, th6, th7);

            table.append(tr1, tr2);

            var count = 0;

            for (let al of LadpList) {


                if(count != 10){
                    
                    // 메인 내용 tr
                    const tr3 = document.createElement("tr");
                    tr3.classList.add("L-pay-tr");
                    
                    const td1 = document.createElement("td");
                    td1.innerText = al.calculateNo;
                    
                    const td2 = document.createElement("td");
                    td2.innerText = al.calculateWay;
                    
                    const td3 = document.createElement("td");
                    td3.innerText = al.calculatePrice;
                    
                    const td4 = document.createElement("td");
                    td4.innerText = al.memberId;
                    
                    const td5 = document.createElement("td");
                    td5.innerText = al.calculateSt;
                    
                    const td6 = document.createElement("td");
                    td6.innerText = al.checkInDt
                    
                    const td7 = document.createElement("td");
                    td7.classList.add("L-pay-btn");
                    const btn = document.createElement("button");
                    btn.innerText = "승인";
                    btn.setAttribute("onclick", "AgreePay(" + al.calculateNo + ")");
                    
                    td7.append(btn);
                    tr3.append(td1, td2, td3, td4, td5, td6, td7);
                    
                    table.append(tr3);

                    count++;
                }
            }




        },

        error : function(req, status, error){
            console.log("에러 발생");
            console.log(req.responseText);
        }


    });



}
