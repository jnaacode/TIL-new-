// 게시글 삭제
(function(){

    const LdeleteBtn = document.getElementById("LdeleteBtn");

    if(LdeleteBtn != null){

        LdeleteBtn.addEventListener("click", function(){

            let url = "boardDelete";

            // 쿼리스트링만 얻어오기
            const params = new URL(location.href).searchParams;

            const type = "?type=" + params.get("type");

            const no = "&no=" + params.get("no");

            url += type + no;

            if(confirm("정말로 삭제 하시겠습니까?")){
                location.href = url; // get방식
            }

        });


    }


})();

