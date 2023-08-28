const insertBtn = document.getElementById("insertBtn");



if (insertBtn != null) {

    // 글쓰기 버튼 클릭 시 
    insertBtn.addEventListener("click", () => {

        // JS BOM 갹채 즁 location
        //location.href='/member/login'
        //해당 주소 요청(GET방식)

        // location.href = "/board2/" + location.pathname.split("/")[2];
        location.href = `/board2/${location.pathname.split("/")[2]}/insert`
        // /board2/1/insert


    })
}
