/* 메인 베너 */
const div = document.querySelector("div.main-banner");
const arrows = document.querySelectorAll("div.arrow");
const btns = document.querySelectorAll(".btn");
const firstDiv = document.createElement("div");
const lastDiv = document.createElement("div");
var count = 0;
var buttonCheck = true;
var numberButtonCheck = true;
var temp = btns[count];

firstDiv.innerHTML = `<img src="img/006.png">`;
div.insertBefore(firstDiv, document.querySelector("div.main-banner div"));

lastDiv.innerHTML = `<img src="/img/001.png">`;
div.appendChild(lastDiv);

div.style.transform = "translate(-90vw)";

btns[0].style.background = "white";

let inter = setInterval(autoSlide, 5000);

function autoSlide(){
    div.style.transition = "transform 0.5s";
    count ++;
    if(count == 6){ // 마지막 배너(6번)
        btns[count - 1].style.background = "transparent";
        div.style.transform = "translate(-" + 90 * (count + 1) +"vw)"
        count = 0;
        btns[count].style.background = "white";
        setTimeout(function(){
            div.style.transition = "transform 0s";
            div.style.transform = "translate(-90vw)";
        }, 500);
    }else{
        btns[count - 1].style.background = "transparent";
        btns[count].style.background = "white";
        div.style.transition = "transform 0.5s";
        div.style.transform = "translate(-" + 90 * (count + 1) +"vw)"
    }
    temp = btns[count];
}

// 이전버튼, 다음버튼
arrows.forEach(arrow => {
    arrow.addEventListener("click", function(){
        if(buttonCheck){
            buttonCheck = false;
            let arrowType = arrow.classList[1];
            clearInterval(inter);
            div.style.transition = "transform 0.5s";
            if(arrowType == "prev"){
                count --;
                if(count == -1){
                    div.style.transform = "translate(0vw)";
                    setTimeout(function(){
                        div.style.transition = "transform 0s";
                        div.style.transform = "translate(-540vw)";
                    }, 500);
                    count = 5;
                }else{
                    div.style.transform = "translate(-" + 90 * (count + 1) + "vw)";
                }

            }else{
                count ++;
                if(count == 6){
                    div.style.transform = "translate(-" + 90 * (count + 1) + "vw)";
                    setTimeout(function(){
                        div.style.transition = "transform 0s";
                        div.style.transform = "translate(-90vw)";
                    }, 500);
                    count = 0;
                }else{
                    div.style.transform = "translate(-" + 90 * (count + 1) + "vw)";
                }
            }
            temp.style.background = "transparent";
            temp = btns[count];
            btns[count].style.background = "white";
            inter = setInterval(autoSlide, 5000);

            setTimeout(()=>{buttonCheck = true}, 500);
        }
    });
});

// 원하는 번호의 배너로 이동

btns.forEach((btn, i) => {
    btn.addEventListener("click", function(){
        div.style.transition = "transform 0.5s";
        if(numberButtonCheck){
            numberButtonCheck = false;
            clearInterval(inter);
            count = i;
            div.style.transform = "translate(-" + 90 * (count + 1) +"vw)"
            temp.style.background = "transparent";
            temp = btns[count];
            btns[count].style.background = "white";
            inter = setInterval(autoSlide, 5000);
            setTimeout(() => {numberButtonCheck = true}, 500);
        }
    });
});

const $mainContainer = $(".main-container");
const $arrow = $(".arrow")

$mainContainer.hover(function(){
    $arrow.fadeToggle(250);
});

/* 보드 베너 */

const $comPrev = $(".com-prev");
const $comNext = $(".com-next");
const $revPrev = $(".rev-prev");
const $revNext = $(".rev-next");
var $comCount = 0;
var $revCount = 0;

$comNext.on("click",function(){
    if($comCount != 2){
        $comCount++;
        $(this).siblings(".board").children(".board-banner")
            .css({"transform":"translate(-"+ 566 * $comCount +"px)", "transition": "transform 0.5s"});
    }
});

$comPrev.on("click",function(){
    if($comCount != 0){
        $comCount--;
        $(this).siblings(".board").children(".board-banner")
            .css({"transform":"translate(-"+ 566 * $comCount +"px)", "transition": "transform 0.5s"});
    }
});

$revNext.on("click",function(){
    if($revCount != 2){
        $revCount++;
        $(this).siblings(".board").children(".board-banner")
            .css({"transform":"translate(-"+ 566 * $revCount +"px)", "transition": "transform 0.5s"});
    }
});

$revPrev.on("click",function(){
    if($revCount != 0){
        $revCount--;
        $(this).siblings(".board").children(".board-banner")
            .css({"transform":"translate(-"+ 566 * $revCount +"px)", "transition": "transform 0.5s"});
    }
});