// $("img.board-toggle").on("click", function(){
//     // if($("div.board-menu-nav").css('display') === 'none'){
//     //     $("div.board-menu-nav").show();
//     // } else {
//     //     $("div.board-menu-nav").hide();
//     // }
//
//     $("div.board-menu-nav").toggle();
// });
//
// $("img.comment-toggle").on("click", function(){
//     /*if($("div.comment-menu-nav").css('display') === 'none'){
//         $("div.comment-menu-nav").show();
//     } else {
//         $("div.comment-menu-nav").hide();
//     }*/
//
//     $("div.comment-menu-nav").toggle();
// });
//
// $(".fa-heart").on("click", function(){
//     // console.log($(this).attr('class'));
//     if($(this).attr('class') == 'fa-regular fa-heart'){
//         $(this).attr('class', 'fa-solid fa-heart');
//     } else {
//         $(this).attr('class', 'fa-regular fa-heart');
//     }
// });

let replyService = (function(){
    function add(reply, callback, error){
        console.log("댓글 추가 실행함수")
        $.ajax({
            url: "/reply/write",
            type: "post",
            data: JSON.stringify(reply),
            contentType: "application/json; charset=utf-8", //data에 JSON 작성 시 반드시 contentType 작성
            success: function(result){
                if(callback){
                    window.location.reload();
                }
            },
            error: function(a, b, c){
                console.log("왜 안 됨?")
                if(error){
                    error(a, b, c);
                }
            }
        });
    }
    function getList(boardNumber, callback, error){
        $.ajax({
            url: "/reply/list/" + boardNumber,
            success: function(replies){
                if (callback){
                    callback(replies);
                }
            }
        })
    }
    function read(){}
    function remove(){}
    function modify(){}

    return {add: add, getList: getList, read: read, remove: remove, modify: modify}
})();

