// 필요한 변수 선언

// 찜을 했는지 안했는지 확인할 수 있는 값
const room1 = document.getElementById("Llike1");
const room2 = document.getElementById("Llike2");
const room3 = document.getElementById("Llike3");

// 버튼 생성
const btn = document.createElement("button");
const btn2 = document.createElement("button");
const btn3 = document.createElement("button");

// 로그인한 memberNo
const memberNo = document.getElementsByName("memberNo")[0].value;

// 객실명
const roomNm1 = document.getElementsByName("roomNm1")[0].value;
const roomNm2 = document.getElementsByName("roomNm2")[0].value;
const roomNm3 = document.getElementsByName("roomNm3")[0].value;

// 호텔명
const hotelNm1 = document.getElementsByName("hotelNm3")[0].value;

// 찜 여부 확인, 첫 화면 출력
(function(){
    
    if(memberNo.trim().length != 0){

        $.ajax({

            url : "likeDisplay",
            data : {"memberNo" : memberNo,
                    "roomNm1" : roomNm1,
                    "roomNm2" : roomNm2,
                    "roomNm3" : roomNm3,
                    "hotelNm1" : hotelNm1},

            type : "get",

            dataType : "JSON",

            success : function(countList){

                // 1번 객실
                if(countList.count > 0){
                    btn.style.color = "red";
                    btn.style.border = "1px solid red";
                    btn.style.backgroundColor = "white";
                    room1.value = 1;
                }else{
                    btn.style.color = "white";
                    btn.style.backgroundColor = "rgb(207, 191, 167)";
                    btn.style.border = 0;
                    room1.value = 0;
                }

                // 2번 객실
                if(countList.count2 > 0){
                    btn2.style.color = "red";
                    btn2.style.border = "1px solid red";
                    btn2.style.backgroundColor = "white";
                    room2.value = 1;
                }else{
                    btn2.style.color = "white";
                    btn2.style.backgroundColor = "rgb(207, 191, 167)";
                    btn2.style.border = 0;
                    room2.value = 0;
                }

                // 3번 객실
                if(countList.count3 > 0){
                    btn3.style.color = "red";
                    btn3.style.border = "1px solid red";
                    btn3.style.backgroundColor = "white";
                    room3.value = 1;
                }else{
                    btn3.style.color = "white";
                    btn3.style.backgroundColor = "rgb(207, 191, 167)";
                    btn3.style.border = 0;
                    room3.value = 0;
                }
                
            },

            error : function(req, status, error){
                console.log("찜하기 실패!");
                console.log(req.responseText);
            }
            
        });
        
    }

        
        // *************버튼1*****************
        const LroomG1 = document.getElementById("LroomG1");

        btn.setAttribute("type", "button");
        btn.setAttribute("id", "L-hbtn");

        btn.innerText = "찜하기♡";

        LroomG1.append(btn);


        // **************버튼2*****************
        const LroomG2 = document.getElementById("LroomG2");

        btn2.setAttribute("type", "button");
        btn2.setAttribute("id", "L-hbtn");

        btn2.innerText = "찜하기♡";

        LroomG2.append(btn2);


        // **************버튼3******************
        const LroomG3 = document.getElementById("LroomG3");

        btn3.setAttribute("type", "button");
        btn3.setAttribute("id", "L-hbtn");

        btn3.innerText = "찜하기♡";

        LroomG3.append(btn3);

    })();



// ***********************객실1 버튼 클릭시 발생 이벤트**************************
btn.addEventListener("click", function(){

    if(memberNo.trim().length != 0){


        if(room1.value == 0){
        
            this.style.color = "red";
            this.style.border = "1px solid red";
            this.style.backgroundColor = "white";

            
            

            $.ajax({

                url : "likeplus1",
                data : {"memberNo" : memberNo,
                        "roomNm1" : roomNm1,
                        "hotelNm1" : hotelNm1},
                type : "get",

                success : function(result){

                    if(result > 0){
                        room1.value = 1;
                        alert(roomNm1 + " 객실을 찜목록에 추가하셨습니다.");
                    }else{
                        alert("찜하기 도중 오류 발생");
                        
                    }
                    
                },

                error : function(req, status, error){
                    console.log("찜하기 실패!");
                    console.log(req.responseText);
                }
                
            });


        }else{
            
            this.style.color = "white";
            this.style.backgroundColor = "rgb(207, 191, 167)";
            this.style.border = 0;
            
            
           
            $.ajax({

                url : "likeDel1",
                data : {"memberNo" : memberNo,
                        "roomNm1" : roomNm1,
                        "hotelNm1" : hotelNm1},
                type : "get",

                success : function(result){

                    if(result > 0){
                        room1.value = 0;
                        alert(roomNm1 + " 객실을 찜목록에서 삭제 하셨습니다.");
                    }else{
                        alert("찜삭제 도중 오류 발생");
                        
                    }

                },

                error : function(req, status, error){
                    console.log("찜삭제 실패!");
                    console.log(req.responseText);
                }
                
            });

        }

    }else{
        alert("로그인 후 이용해주세요.");
    }
});



// *******************객실2 버튼 클릭시 발생 이벤트*******************************
btn2.addEventListener("click", function(){

    if(memberNo.trim().length != 0){


        if(room2.value == 0){
        
            this.style.color = "red";
            this.style.border = "1px solid red";
            this.style.backgroundColor = "white";

            
            

            $.ajax({

                url : "likeplus2",
                data : {"memberNo" : memberNo,
                        "roomNm2" : roomNm2,
                        "hotelNm1" : hotelNm1},
                type : "get",

                success : function(result){

                    if(result > 0){
                        room2.value = 1;
                        alert(roomNm2 + " 객실을 찜목록에 추가하셨습니다.");
                    }else{
                        alert("찜하기 도중 오류 발생");
                        
                    }
                    
                },

                error : function(req, status, error){
                    console.log("찜하기 실패!");
                    console.log(req.responseText);
                }
                
            });


        }else{
            
            this.style.color = "white";
            this.style.backgroundColor = "rgb(207, 191, 167)";
            this.style.border = 0;
            
            
           
            $.ajax({

                url : "likeDel2",
                data : {"memberNo" : memberNo,
                        "roomNm2" : roomNm2,
                        "hotelNm1" : hotelNm1},
                type : "get",

                success : function(result){

                    if(result > 0){
                        room2.value = 0;
                        alert(roomNm2 + " 객실을 찜목록에서 삭제 하셨습니다.");
                    }else{
                        alert("찜삭제 도중 오류 발생");
                        
                    }

                },

                error : function(req, status, error){
                    console.log("찜삭제 실패!");
                    console.log(req.responseText);
                }
                
            });

        }

    }else{
        alert("로그인 후 이용해주세요.");
    }
});



//***************************객실3 버튼 클릭시 발생 이벤트******************************
btn3.addEventListener("click", function(){

    if(memberNo.trim().length != 0){


        if(room3.value == 0){
        
            this.style.color = "red";
            this.style.border = "1px solid red";
            this.style.backgroundColor = "white";


            $.ajax({

                url : "likeplus3",
                data : {"memberNo" : memberNo,
                        "roomNm3" : roomNm3,
                        "hotelNm1" : hotelNm1},
                type : "get",

                success : function(result){

                    if(result > 0){
                        room3.value = 1;
                        alert(roomNm3 + " 객실을 찜목록에 추가하셨습니다.");
                    }else{
                        alert("찜하기 도중 오류 발생");
                        
                    }
                    
                },

                error : function(req, status, error){
                    console.log("찜하기 실패!");
                    console.log(req.responseText);
                }
                
            });


        }else{
            
            this.style.color = "white";
            this.style.backgroundColor = "rgb(207, 191, 167)";
            this.style.border = 0;
            
            
           
            $.ajax({

                url : "likeDel3",
                data : {"memberNo" : memberNo,
                        "roomNm3" : roomNm3,
                        "hotelNm1" : hotelNm1},
                type : "get",

                success : function(result){

                    if(result > 0){
                        room3.value = 0;
                        alert(roomNm3 + " 객실을 찜목록에서 삭제 하셨습니다.");
                    }else{
                        alert("찜삭제 도중 오류 발생");
                        
                    }

                },

                error : function(req, status, error){
                    console.log("찜삭제 실패!");
                    console.log(req.responseText);
                }
                
            });

        }

    }else{
        alert("로그인 후 이용해주세요.");
    }
});




