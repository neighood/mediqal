$("img.board-toggle").on("click", function(){
    // if($("div.board-menu-nav").css('display') === 'none'){
    //     $("div.board-menu-nav").show();
    // } else {
    //     $("div.board-menu-nav").hide();
    // }

    $("div.board-menu-nav").toggle();
});

$("img.comment-toggle").on("click", function(){
    // if($("div.comment-menu-nav").css('display') === 'none'){
    //     $("div.comment-menu-nav").show();
    // } else {
    //     $("div.comment-menu-nav").hide();
    // }

    $("div.comment-menu-nav").toggle();
});

$(".fa-heart").on("click", function(){
    // console.log($(this).attr('class'));
    if($(this).attr('class') == 'fa-regular fa-heart'){
        $(this).attr('class', 'fa-solid fa-heart');
    } else {
        $(this).attr('class', 'fa-regular fa-heart');
    }
});
