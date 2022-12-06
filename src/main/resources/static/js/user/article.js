let $list = $(".list-unit-container");
let $bDelete = $(".detail-remove-btn");
let $bUpdate = $(".detail-edit-btn");

/*$list.on("click",function () {
    $(".list-unit--current").removeClass("list-unit--current");
    $(this).parent(".article-list-unit").addClass("list-unit--current");

    let number = $(this).children(".list-unit__number").text();
    let title= $(this).children(".list-unit__title").text();
    let content = $(this).children(".list-unit__content").text();

    $("#boardNumber").val(number);
    $(".article-detail__title-span").text("Q." + title);
    $(".article-detail__detail").text(content);

    $bDelete.css("display","inline-block");
    $bUpdate.css("display","inline-block");

});*/

$list.on("click",function () {
    $(".list-unit--current").removeClass("list-unit--current");
    $(this).parent(".article-list-unit").addClass("list-unit--current");

    let number = $(this).children(".list-unit__number").text();

    $.ajax({
        url: "/profileAjax/board",
        type: "post",
        data: {boardNumber: number},
        success: function(board){
            $("#boardNumber").val(board.boardNumber);
            $(".article-detail__title-span").text("Q." + board.boardTitle);
            $(".article-detail__detail").text(board.boardContent);
        }
    });

    $bDelete.css("display","inline-block");
    $bUpdate.css("display","inline-block");

});

$bDelete.on("click", function () {
    $("#deleteForm").submit();
});

$bUpdate.on("click", function () {
    let boardNumber = $("#boardNumber").val();
    location.href="/board/community/" + boardNumber;
});

let urlParams = new URL(location.href).searchParams;
let check = urlParams.get("profileCheck");
console.log(check);
if(check == 'yes'){
    alert("게시물 삭제");
}