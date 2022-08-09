// function noscroll(){
//     window.scrollTo(0,0)
// }

$(function(){
    $('.login-show').click(function(){
        $('#login-modal').fadeIn().css("display", "flex");
    });

    $('.close-modal').click(function(){
        $('#login-modal').fadeOut();
    });
});
