
(function(){
    const goToListBtn = document.getElementById("goToListBtn");

    if(goToListBtn != null){ 

        goToListBtn.addEventListener("click", function(){

           
            const pathname = location.pathname; 
         
     
            let url = pathname.substring(0, pathname.indexOf("/",1));
          

            url += "/board/list?"; 

           
            const params = new URL(location.href).searchParams; 

            const type = "type=" + params.get("type"); 
            let cp; 
            
            if(params.get("cp") != null){ 

                cp = "cp=" + params.get("cp");
            }else{
                cp = "cp=1";
            }

          
            url += type + "&" + cp;


            if(params.get("key") != null){
                const key = "&key=" + params.get("key");
                const query = "&query=" + params.get("query");

                url += key + query;
            }



            location.href = url;

        })
    }

})();


(function(){
    const deleteBtn = document.getElementById("deleteBtn");

    if(deleteBtn != null){
        deleteBtn.addEventListener("click", function(){

            let url = "delete"; 


            const params = new URL(location.href).searchParams;

            const no = "?no=" + params.get("no");

            const type = "& type=" + params.get("type");

            url += no + type; 

            if(confirm("정말로 삭제 하시겠습니까?")){
                location.href = url; 
            }

        });

    }



})();

// 검색창에 이전 검색기록 반영하기
(function(){
    const select = document.getElementById("search-key");

    const input = document.getElementById("search-query");

    const option = document.querySelectorAll("#search-key > option");

    if(select != null){ 
        const params = new URL(location.href).searchParams;

        const key = params.get("key");
        const query = params.get("query");

        input.value = query;

        for(let op of option){
            if(op.value == key){
                op.selected = true;
            }
        }


    }

})();

function searchValidate(){

    const query = document.getElementById("search-query");

    if(query.value.trim().length == 0){
        query.value = "";
        query.focus();

        return false;

    }

    return true;    

}