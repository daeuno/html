// --슬라이드--
var slides = document.querySelector('.slides'),
    slide = document.querySelectorAll('.slides li'),
    currentIdx = 0,
    slideCount = slide.length,
    prevBtn = document.querySelector('.prev'),
    slideWidth = 200,
    slideMargin = 30,
    nextBtn = document.querySelector('.next');

slides.style.width = (slideWidth + slideMargin)*slideCount - slideMargin +'px';

function moveSlide(num){
    slides.style.left = -num * 230 + 'px';
    currentIdx = num;
}
nextBtn.addEventListener('click', function(){
    if(currentIdx <slideCount - 3 ){
        moveSlide(currentIdx + 1);
        console.log(currentIdx)
    } else {
        moveSlide(0);
    }    
});

prevBtn.addEventListener('click', function(){
    if(currentIdx > 0 ){
        moveSlide(currentIdx - 1);
    } else {
        moveSlide(slideCount - 3);
    }    
});

// --
var slides2 = document.querySelector('.slides2'),
    slide2 = document.querySelectorAll('.slides2 li'),
    currentIdx = 0,
    slideCount = slide2.length,
    prevBtn = document.querySelector('.prev2'),
    slideWidth = 200,
    slideMargin = 30,
    nextBtn = document.querySelector('.next2');

slides2.style.width = (slideWidth + slideMargin)*slideCount - slideMargin +'px';

function moveSlide2(num){
    slides2.style.left = -num * 230 + 'px';
    currentIdx = num;
}
nextBtn.addEventListener('click', function(){
    if(currentIdx <slideCount - 3 ){
        moveSlide2(currentIdx + 1);
        console.log(currentIdx)
    } else {
        moveSlide2(0);
    }    
});

prevBtn.addEventListener('click', function(){
    if(currentIdx > 0 ){
        moveSlide2(currentIdx - 1);
    } else {
        moveSlide2(slideCount - 3);
    }    
});

// ---

var slides3 = document.querySelector('.slides3'),
    slide3 = document.querySelectorAll('.slides3 li'),
    currentIdx = 0,
    slideCount = slide3.length,
    prevBtn = document.querySelector('.prev3'),
    slideWidth = 200,
    slideMargin = 30,
    nextBtn = document.querySelector('.next3');

slides3.style.width = (slideWidth + slideMargin)*slideCount - slideMargin +'px';

function moveSlide3(num){
    slides3.style.left = -num * 230 + 'px';
    currentIdx = num;
}
nextBtn.addEventListener('click', function(){
    if(currentIdx <slideCount - 3 ){
        moveSlide3(currentIdx + 1);
        console.log(currentIdx)
    } else {
        moveSlide3(0);
    }    
});

prevBtn.addEventListener('click', function(){
    if(currentIdx > 0 ){
        moveSlide3(currentIdx - 1);
    } else {
        moveSlide3(slideCount - 3);
    }    
});

// --

// -- 모달팝업--

const openButton = document.getElementById("open");
const modal = document.querySelector('.modal');
const overlay = modal.querySelector(".modal_overlay");
const closeBtn = modal.querySelector("button");
// const body = $('body');
const openModal = () => {
    modal.classList.remove("hidden")
    document.querySelector('body').style.overflow = 'hidden';
}
const closeModal = () => {
    modal.classList.add("hidden");
    document.querySelector("body").style.overflow = 'visible';
}
overlay.addEventListener('click', closeModal);
closeBtn.addEventListener('click', closeModal);
openButton.addEventListener('click', openModal);


// 개인정보수정 모달
$(function(){
    $('#pi-show').click(function(){
        $('#pi-modal').fadeIn().css("display", "flex");
         $("body").css("overflow", "hidden");
    });

    $('.pi-close-modal').click(function(){
        $('#pi-modal').fadeOut();
        $("body").css("overflow", "visible");
    });
});

