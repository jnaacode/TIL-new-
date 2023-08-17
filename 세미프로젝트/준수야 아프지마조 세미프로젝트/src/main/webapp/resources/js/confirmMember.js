let popup = $(".K-popup");
let pop = $(".K-pop");
let pop1 = $(".K-pop1");
$(".K-agree-btn").on("click", function(){

    popup.fadeIn();

    pop.show();
})

$(".K-pop-btn").on("click", function(){

    popup.fadeOut();

    pop.hide();
    pop1.hide();
})
$(".K-agree-btn1").on("click", function(){

    popup.fadeIn();

    pop1.show();
})

