const $container = $(".container");
const $buttonImg = $(".button-img");

$container.on("click", function(e){
    e.preventDefault();
    location.href = "/board/review_detail";
});

$buttonImg.on("click", function(e){
    e.preventDefault();
    location.href = "/board/write";
});