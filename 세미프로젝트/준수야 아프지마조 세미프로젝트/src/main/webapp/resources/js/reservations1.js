/* document.getElementById("J-btn").addEventListener("click", function(){

    $a.jax({

    })

    confirm("예약을 취소 하시겠습니까?");
}) */

/* c
 

    const bookNo = document.getElementsByName("bookNo")[0];
   /*  const bookNo = document.getElementsByName("bookNo")[0]; */

/*     $.ajax({
        url :  "reviewCancel",
        data: {"bookNo" : bookNo.value},
        type : "GET",
        
        success : function(result){
          
            if(result > 0) {
    
            }
        },
        error: function(req, status, error){
        
            console.log(req.responseText);
        }

        
    });
}) */

function reservationcheck(){

    return confirm("예약을 취소하시겠습니까?");
}
    


