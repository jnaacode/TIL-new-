(function(){
    const updateBtn = document.getElementById("K-updateBtn");

    if(updateBtn != null){
        updateBtn.addEventListener("click", function(){
            const pathname = location.pathname;

            let url = pathname.substring(0, pathname.indexOf("/",1));

            url += "/admin/eventWrite?mode=update";

            const params = new URL(location.href).searchParams;

            const no = "&no=" + params.get("no");

            url += no;

            if(confirm("수정하시겠습니까?")){
                location.href = url // get방식
            }
        })
    }
})();

(function(){
    const deleteBtn = document.getElementById("K-deleteBtn");

    if(deleteBtn != null){
        deleteBtn.addEventListener("click", function(){
            const pathname = location.pathname;

            let url = pathname.substring(0, pathname.indexOf("/",1));

            url += "/admin/event/delete";

            const params = new URL(location.href).searchParams;

            const no = "?no=" + params.get("no");

            url += no;

            if(confirm("삭제하시겠습니까?")){
                location.href = url // get방식
            }
        })
    }



})();