// 검색창에 검색 기록 남기기
(function(){

    const kSearch = document.getElementById("k-search");
    const option = kSearch.children;
    const kContent = document.getElementById("k-search-c");

    //              현재 페이지주소 + 쿼리스트링
    const params = new URL(location.href).searchParams;
    //                                      쿼리스트링만 반환

    const select = params.get("select");
    const content = params.get("sContent");

    kContent.value = content;

    for(let op of option){
        if(op.value == select) {
            op.selected = true;
        }
    }
})();

function searchValidate(){

    const kContent = document.getElementById("k-search-c");

    if(kContent.value.trim().length == 0){
        alert("검색어를 입력해주세요");
        kContent.value = "";
        kContent.focus();
        return false;
    }

    return true;
}