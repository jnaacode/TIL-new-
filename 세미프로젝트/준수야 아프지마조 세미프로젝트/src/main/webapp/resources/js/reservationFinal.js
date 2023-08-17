const agree = document.getElementById("C-revAgreeYes");
const coupon = document.getElementById("C-rsv-coupon");
const discount = document.getElementById("C-couponPay");
const displaychanger = document.getElementById("C-display-change");
const displaychanger2 = document.getElementById("C-display-change2");
const payplan = document.getElementById("C-payplan");
const Cbank = document.getElementById("C-bank");
const account = document.getElementById("C-account");


const hotelpay = document.getElementById("C-hotelPay");
const finalpay = document.getElementById("C-finalpay");

$(function () {
            $("#C-kakaopay").click(function () {
                $.ajax({
                    url: '/cls/jp/kakaopay.cls',
                    dataType: 'json',
                    success: function (data) {
                       var box =data.next_redirect_pc_url;
                       window.open(box);
                       
                        return true;
                    },
                    error: function (error) {
                        alert(error);
                        return false;
                    }
                })
            })
        })

coupon.addEventListener("change", function () {

    if (coupon.value == "30000") {
        discount.value = couponMoney;

        finalpay.value = roomMoney - couponMoney;

        
    }else{
        discount.value = 0;

        finalpay.value = roomMoney;
    }
});

payplan.addEventListener("change", function () {

    if (payplan.value == "무통장입금") {
        displaychanger.style.display = "contents";
    }
});

account.addEventListener("change", function () {

    if (account.value != "none") {
        displaychanger2.style.display = "revert";
    }
});

function reservationFinalValidate() {

    if (payplan.value == "none") {
        alert("결제 수단을 선택해주시길 바랍니다.");
        return false;
    }else if(account.value == "none"){
        alert("결제 은행을 선택해주시길 바랍니다.");
        return false;
    }else if (!agree.checked) {
        alert("약관 동의 후 예약을 진행해주시기 바랍니다.");
        return false;
        
    }else if(couponList != 0 && coupon.value != "30000"){

        return confirm("보유하신 쿠폰이 있습니다. 쿠폰 사용을 안하시고 결제를 진행하시겠습니까?");

    }else{
            
        return confirm("결제를 진행하시겠습니까?"); 
    }


}





