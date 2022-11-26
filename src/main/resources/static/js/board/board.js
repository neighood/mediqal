const $container = $(".container");
const $buttonImg = $(".button-img");

$container.on("click", function(e){
    e.preventDefault();
    location.href = "/board/board_detail";
});

$buttonImg.on("click", function(e){
    e.preventDefault();
    location.href = "/board/write";
});