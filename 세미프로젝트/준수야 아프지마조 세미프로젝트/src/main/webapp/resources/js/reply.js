
// 댓글 목록 조회
function selectReplyList(){

    $.ajax({

        url : contextPath + "/reply/selectReplyList",
        data : {"boardNo" : boardNo},
        type : "GET",
        dataType : "JSON",
        success : function(rList){
            
            const replyUl = document.getElementById("L-reply-list");
            replyUl.innerHTML = "";
            
            for(let rp of rList){

                var replyName = rp.memberId
                var length = replyName.length
                var replyMN = replyName.substring(3, length);
                var star = "***"

                
                // 댓글영역
                const replyRow = document.createElement("li");
                replyRow.classList.add("L-reply-row");
                
                // 댓글 작성자
                const replyPerson = document.createElement("span");
                replyPerson.classList.add("L-reply-person");
                replyPerson.innerText = star + replyMN;

                // 댓글 작성일
                const replyDate = document.createElement("span");
                replyDate.classList.add("L-reply-date");
                replyDate.innerText = rp.createDt;

                // 댓글 내용
                const replyContent = document.createElement("p");
                replyContent.classList.add("L-reply-content");
                replyContent.innerHTML = rp.replyContent;

                // 댓글내용을 li에 넣어줌
                replyRow.append(replyPerson, replyDate, replyContent);

                
                // 버튼

                // 버튼 전체 div
                const replyBtn = document.createElement("div");
                replyBtn.classList.add("L-reply-btn");

                if(loginMemberNo == rp.memberNo){

                    // 수정버튼
                    const updateBtn = document.createElement("button");
                    updateBtn.innerText = "수정";
                    updateBtn.setAttribute("onclick", "showUpdateReply(" + rp.replyNo + ", this)")
                    
                    // 버튼 추가
                    replyBtn.append(updateBtn);
                }


                if(loginMemberNo == rp.memberNo || loginAdmin == 'Y'){

                    // 삭제버튼
                    const deleteBtn = document.createElement("button");
                    deleteBtn.innerText = "삭제";
                    deleteBtn.setAttribute("onclick", "deleteReply(" + rp.replyNo + ")");
                    
                    // 버튼 추가
                    replyBtn.append(deleteBtn);
                }

    
                // 행에 버튼추가
                replyRow.append(replyBtn);


                // ul에 li 추가
                replyUl.append(replyRow);

            }
        },

        error : function(){
            console.log("에러 발생");
        }

    });

}


// 댓글 작성
const replyContent = document.getElementById("L-reply-content2");
const replyAdd = document.getElementById("L-reply-add");

replyAdd.addEventListener("click", function(){

    // 로그인이 안되어있을 때
    if(loginMemberNo == ""){
        alert("로그인 후 작성 가능합니다.");
        return;
    }

    // 댓글 작성이 안되어있을 때
    if(replyContent.value.trim().length == 0){
        alert("댓글 내용을 입력해주세요.");
        replyContent.focus();
        replyContent.value = "";

        return;
    }




    $.ajax({

        url : contextPath + "/reply/insert",

        data : {"replyContent" : replyContent.value,
                "boardNo" : boardNo,
                "memberNo" : loginMemberNo},
        
        type : "POST",

        success : function(result){

            if(result > 0){
                alert("댓글이 등록되었습니다.");

                replyContent.value="";

                selectReplyList();

            }else{ // 실패
                alert("댓글 등록에 실패했습니다")
            }


        },

        error : function(req, status, error){
            console.log("댓글 등록 실패");
            console.log(req.responseText);
        }

    });


})


// 댓글 삭제
function deleteReply(replyNo){

    // 바로 삭제 안되도록 추가
    if(confirm("정말 댓글을 삭제하시겠습니까?")){

        $.ajax({
    
            url : contextPath + "/reply/delete",
            data : {"replyNo" : replyNo},
            type : "GET",
    
            success : function(result){
    
                if(result > 0){
                    alert("댓글 삭제에 성공했습니다.")
    
                    selectReplyList();
    
                }else{
                    alert("댓글 삭제에 실패했습니다.")
                }
    
            },
    
            error : function(req, status, error){
                console.log("댓글 삭제 실패");
                console.log(req.responseText);
            }
    
        });
    }

}



// 댓글 수정 화면 전환

let beforeRow; // 이전 행 내용 저장용 변수

function showUpdateReply(replyNo, btn){

    // 댓글 수정 한개만 할 수 있도록 만들기
    const content = document.getElementsByClassName("LUpdateReplyContent");

    if(content.length > 0){

        if(confirm("다른 댓글 수정 중입니다. 현재 댓글을 수정 하시겠습니까?")){

            content[0].parentElement.innerHTML = beforeRow;
        }else{
            return;
        }

    }

    // 댓글 수정이 클릭된 행을 선택
    const replyRow = btn.parentElement.parentElement;

    beforeRow = replyRow.innerHTML;

    // 수정 이전 내용 가져오기
    let beforeContent = replyRow.children[2].innerHTML;

    // 댓글 행 내부 내용 삭제
    replyRow.innerHTML = "";

    // textarea 요소 , 클래스, 내용추가
    const textarea = document.createElement("textarea");
    textarea.classList.add("LUpdateReplyContent");

    // *****************************************************************
    // XSS 방지 처리 해제
    beforeContent = beforeContent.replaceAll("&amp;", "&");
    beforeContent = beforeContent.replaceAll("&lt;", "<");
    beforeContent = beforeContent.replaceAll("&gt;", ">");
    beforeContent = beforeContent.replaceAll("&quot;", "\"");
    // *****************************************************************
    
    // 개행문자 처리 해제
    beforeContent = beforeContent.replaceAll("<br>", "\n");

    textarea.value = beforeContent; // 내용 추가

    replyRow.append(textarea); // 행에 추가


    // 버튼 영역, 버튼 생성
    const replyBtn = document.createElement("div");
    replyBtn.classList.add("LUpdateBtn");

    const updateBtn = document.createElement("button");
    updateBtn.innerText = "수정";
    updateBtn.setAttribute("onclick", "updateBtn(" + replyNo + ", this)");

    const cancelBtn = document.createElement("button");
    cancelBtn.innerText = "취소";
    cancelBtn.setAttribute("onclick", "updateCancel(this)");

    // 버튼 행에 추가
    replyBtn.append(updateBtn, cancelBtn);
    replyRow.append(replyBtn);

}


// 댓글 수정에서 취소!
function updateCancel(btn){

    if(confirm("댓글 수정을 취소하시겠습니까?")){
        btn.parentElement.parentElement.innerHTML = beforeRow;
    }

}



// 댓글 수정에서 수정!
function updateBtn(replyNo, btn){

    const replyContent = btn.parentElement.previousElementSibling.value;

    $.ajax({

        url : contextPath + "/reply/update",
        data : {"replyNo": replyNo,
                "replyContent" : replyContent},
        type : "POST",
        success : function(result){
            if(result > 0){
                alert("댓글이 수정 되었습니다.")

                selectReplyList();
            }else{
                alert("댓글 수정에 실패했습니다.")
            }


        },

        error : function(req, status, error){
            console.log("댓글 삭제 실패");
            console.log(req.responseText);
        }


    });


}



