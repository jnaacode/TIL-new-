function selectFaqList(){

    $.ajax({

        url : contextPath + "/admin/selectFaqList",

        data : { "type" : type },

        dataType : "JSON",

        success : function(fList){

            const kFaq = document.getElementsByClassName("k-faq")[0]; 

            kFaq.innerHTML="";

            if(fList.length != 0){
                for(let f of fList){

                //const firstDiv = document.createElement("div");
                //const secondDiv = document.createElement("div");

                //firstDiv.classList.add("k-faq-slide");
                //secondDiv.classList.add("k-faq-content");

                // slide div *큰 거
                const sDiv = document.createElement("div");
                sDiv.classList.add("k-faq-slide");

                // 제목, 작성자, 화살표
                const tSpan = document.createElement("span");
                const dSpan = document.createElement("span");
                const aDiv  = document.createElement("div");
                aDiv.classList.add("k-arrow-img");

                tSpan.innerText=f.boardTitle;
                dSpan.innerText=f.boardDate;

                sDiv.append(tSpan, dSpan, aDiv);




                //---------------------------

                // content div *큰 거
                const fcDiv = document.createElement("div");
                fcDiv.classList.add("k-faq-content");

                // 내용
                const cDiv = document.createElement("div");
                cDiv.innerHTML=f.boardContent;

                // form 태그
                const form = document.createElement("form");
                form.setAttribute("action" , "#");
                form.setAttribute("method", "post");

                // input 태그
                const nhInpue = document.createElement("input");

                nhInpue.setAttribute("type", "hidden");
                nhInpue.setAttribute("name", "boardNo");

                // 버튼들
                const bDiv = document.createElement("div");
                bDiv.classList.add("k-btns")

                const sButton = document.createElement("button");
                const bButton = document.createElement("button");

                sButton.setAttribute("type", "submit");
                sButton.classList.add("k-mod-btn");
                sButton.innerText="수정";
                
                bButton.setAttribute("onclick", "deleteFaq("+ f.boardNo + ", this)");
                bButton.setAttribute("type", "button");
                bButton.classList.add("k-del-btn");
                bButton.innerText="삭제";


                bDiv.append(sButton, bButton);
                form.append(nhInpue, bDiv);

                fcDiv.append(cDiv, form);

                kFaq.prepend(sDiv, fcDiv);

                }
            } else {
                const nDiv = document.createElement("div");
                nDiv.innerHTML="게시글이 존재하지 않습니다."
                nDiv.classList.add("K-none");
                kFaq.append(nDiv);
            }

            

        },

        error : function(req, status, error){
            console.log("faq 삭제 실패");
            console.log(req.responseText);
        }



    });



}


$(document).on("click", ".k-faq-slide", function(){


    /* element.style.transform = "rotate(180deg)"; */

   /*  if($(".k-arrow-img").css("transform")=="rotate(180deg)"){
        $(".k-arrow-img").css("transform", "rotate(360deg)");
        console.log("하.....")
    } else{
        console.log("sfd")
        $(".k-arrow-img").css("transform", "rotate(180deg)");
    } */
    /* $(".k-arrow-img").css("transform", "rotate(180deg)"); */

    if ($(this).next().css("display") == "none") {
        // 모든 k-faq-content 닫기
        $(".k-faq-content").slideUp();
        // 다른 화살표 이미지들 회전 안된 상태로 초기화
        $(".k-arrow-img").css("transform", "rotate(0deg)").data("rotation", 0);
        // 현재 아코디언의 content 열기
        $(this).next().slideDown();
        // 현재 아코디언의 arrow 이미지 회전
        var arrowImg = $(this).find(".k-arrow-img");
        arrowImg.css("transform", "rotate(180deg)").data("rotation", 180);
    } else {
        // 현재 아코디언의 content 닫기
        $(this).next().slideUp();
        // 현재 아코디언의 arrow 이미지 회전
        var arrowImg = $(this).find(".k-arrow-img");
        arrowImg.css("transform", "rotate(0deg)").data("rotation", 0);
    }

    
    //$(this).next().slideToggle(); 
})

function deleteFaq(boardNo , btn){

    var p1 = btn.parentNode.parentNode.parentNode;

    if(confirm("정말 삭제하시겠습니까?")){
        $.ajax({

            url : contextPath + "/admin/faqDelete",

            data : {"boardNo" : boardNo},

            success : function(result){

                if(result>0){
                    alert("삭제되었습니다.");
                    selectFaqList();
                } else {
                    alert("삭제 실패")
                }

            } , 

            error : function(req, status, error){
                console.log("faq 삭제 실패");
                console.log(req.responseText);
            }

        })
    } 

}



/* $(".k-del-btn").on("click", function(){


}) */


