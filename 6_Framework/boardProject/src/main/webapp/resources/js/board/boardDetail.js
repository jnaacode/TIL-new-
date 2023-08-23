// 좋아요 버튼이 클릭 되었을 때
const boardLike = document.getElementById("boardLike");

boardLike.addEventListener("click", e => {

    // 로그인 여부 검사 
    if (loginMemberNo == "") {
        alert("로그인 후 이용해주세요.");
        return;

    }

    let check; // 기존에 좋아요 체크 x(빈하트) : 0
    // 기존에 좋아요 체크 o(꽉찬하트) : 1

    // contains("클래스명") : 클래스가 있으면 true, 없으면 false
    if (e.target.classList.contains("fa-regular")) { // 좋아요가 x(빈하트)
        check = 0;
    } else { // 좋아요가 x (꽉찬하트)
        check = 1;
    }

    // 로그인한 회원번호, 게시글 번호, 체크 필요 (ajax로 서버로 제출할 파라미터를 모아둔 JS 객체)
    const data = {
        "boardNo": boardNo,
        "memberNo": loginMemberNo,
        "check": check
    };

    // ajax 코드 작성 
    fetch("/board/like", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(data)
    })
        .then(response => response.text()) // 응답 객체를 필요한 형태로 파싱하여 리턴
        .then(count => {

            if(count == -1){ // insert/delect 실패
                console.log("좋아요처리실패");
                return;
            }

            console.log("count:"+count);
            //toggle(): 클래스가 있으면 없애고, 없으면 추가한다.
            e.target.classList.toggle("fa-regular");
            e.target.classList.toggle("fa-solid");

            // 현재 게시글의 좋아수를 화면에 출력 <span>${board.likeCount}</span> 이부분
            e.target.nextElementSibling.innerText=count; 

        }) // 파싱된 데이터를 받아서 처리하는 코드 작성
        .catch(err=>{
            console.log("예외발생")
            console.log("err");
        }) // 예외 발생 시 처리하는 부분

});





