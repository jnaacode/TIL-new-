const postbtn = document.getElementById("C-postWritebtn-clear");
const posttext = document.getElementById("C-postWritearea");
const posttitle = document.getElementById("C-postWrite-title");
var addPicture = document.getElementById("C-plus-picture");
var picture = document.getElementById("C-picture");
var imageCount = 1;


addPicture.addEventListener("click", function() {
    var fileInput = document.createElement("input");
    fileInput.type = "file";
    fileInput.accept = "image/*";
    fileInput.style.display = "flex";

    fileInput.addEventListener("change", function(e) {
        var selectedFile = e.target.files[0];
        if (selectedFile) {
            var newImageContainer = document.createElement("div");
            newImageContainer.className = "C-plus-img";
            newImageContainer.style.margin = "10px";
            var newImage = document.createElement("img");
            newImage.className = "C-postWrite-img";
            newImage.setAttribute("value","img");
            newImage.src = URL.createObjectURL(selectedFile);
            newImage.style.display="flex";
            newImage.alt = "사진 " + imageCount;

            newImageContainer.appendChild(newImage);
            picture.appendChild(newImageContainer);

            imageCount++;
        }
    });

    fileInput.click();
});

function inputcheck() {


    if (posttitle.value.trim().length == 0) {
        alert("제목을 입력해주세요");
        return false;
    }

    if (posttext.value.trim().length == 0) {
        alert("내용을 입력해주세요");
        return false;
    }


    return true;
}

// 게시글 작성 취소 버튼

(function(){
    const cancelBtn = document.getElementById("C-postWritebtn-cancel");

    if(cancelBtn != null){

        cancelBtn.addEventListener("click", function(){
            const pathname = location.pathname;

            let url = pathname.substring(0,pathname.indexOf("/",1));
            //  /community

            url += "/board/list?" // /community/board/list?

            // URL 내장 객체 : 주소 관련 정보를 나타내는 객체
            // location.href : 현재 페이지 주소 + 쿼리스트링
            // URL.searchParams : 쿼리스트링만 별도 객체로 반환

            //http://localhost:8080/community/board/detail?no=2000&cp=1&type=1
            const params = new URL(location.href).searchParams;

            const type = "type=" + params.get("type"); // type=1
            const cp = "cp=" + params.get("cp"); // cp=1

            // 조립
            url += type + "&" + cp;

            // location.href = "주소"; 해당 주소로 이동한다. 
            location.href = url;
        });

    }
})();