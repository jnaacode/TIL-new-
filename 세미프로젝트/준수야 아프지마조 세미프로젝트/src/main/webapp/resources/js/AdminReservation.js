

function selectReservationList(){

    $.ajax({
        url : contextPath + "/admin/selectbookList",
        type : "get",
        dataType : "JSON",
        success : function(rsvList){

            const kkkkk = document.getElementById("rsvListtable");
            const bookList = document.getElementById("adminRsvList");

            bookList.innerHTML= "";

                /* 큰 틀 */
                const bookRow = document.createElement("div");
                bookRow.setAttribute("id", "adminRsvList");

                /* 타이틀 부분 */
                const bookTitle = document.createElement("div");
                bookTitle.classList.add("C-rsvlist-container");
                bookTitle.setAttribute("id","Ctitle");

                const bookNo = document.createElement("div");
                bookNo.innerHTML = "예약번호";
                const bookHotel = document.createElement("div");
                bookHotel.innerHTML = "호텔지점";
                const bookRoom = document.createElement("div");
                bookRoom.innerHTML = "방이름";
                const bookPerson = document.createElement("div");
                bookPerson.innerHTML = "예약자";
                const bookCheckIn = document.createElement("div");
                bookCheckIn.innerHTML = "체크인날짜";
                const bookCheckOut = document.createElement("div");
                bookCheckOut.innerHTML = "체크아웃날짜";

                bookTitle.append(bookNo);
                bookTitle.append(bookHotel);
                bookTitle.append(bookRoom);
                bookTitle.append(bookPerson);
                bookTitle.append(bookCheckIn);
                bookTitle.append(bookCheckOut);

                bookRow.append(bookTitle);
                bookList.append(bookRow);

                for(let rsv of rsvList){
                    
                const container = document.createElement("div");
                container.classList.add("C-rsvlist-container");


                const rvbookNo = document.createElement("div");
                rvbookNo.innerHTML= rsv.bookNo;
                const rvhotelName = document.createElement("div");
                rvhotelName.innerHTML = rsv.hotelName;
                const rvRoomName = document.createElement("div");
                rvRoomName.innerHTML = rsv.roomName;
                const rvMemberName = document.createElement("div");
                rvMemberName.innerHTML = rsv.memberName;
                const rvCheckInTime = document.createElement("div");
                rvCheckInTime.innerHTML = rsv.checkInTime;
                const rvCheckOutTime = document.createElement("div");
                rvCheckOutTime.innerHTML = rsv.checkOutTime;
                const cancelBtnarea = document.createElement("div")

                
                const btn = document.createElement("button");
                btn.setAttribute("onclick","deleteReservation(" + rsv.bookNo + ")");
                btn.innerHTML = "취소";
                cancelBtnarea.append(btn);
                
                container.append(rvbookNo);
                container.append(rvhotelName);
                container.append(rvRoomName);
                container.append(rvMemberName);
                container.append(rvCheckInTime);
                container.append(rvCheckOutTime);
                container.append(cancelBtnarea);
                
                bookList.append(container);
            }
            kkkkk.append(bookList);

        },
        error : function(){
            console.log("에러발생!!!");    
        }
    })



}







function deleteReservation(bookNo){


        if (confirm("정말 취소하시겠습니까?")) {

            $.ajax({
                url: contextPath+"/admin/delete",
                data: {"bookNo" : bookNo},
                type: "GET",
                success: function(result) {

                    if(result > 0){
                        alert("해당 객실의 예약이 취소되었습니다.");
                        selectReservationList();
                    }else{
                        alert("해당 객실의 예약을 취소할 수 없습니다.");
                    }
                },
                error: function (req,status,error) {
                    console.log("예약 취소 실패");
                    console.log(req.responseText);
                }
            })
        }

}
