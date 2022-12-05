// content 목록 생성
// const contentInfoContainer = document.getElementsByClassName(
//     "content-list__info-container"
// )[0];
//
// let content = {
//     id: "1351",
//     title: "열이나고 근육통이 있어요.",
//     userNickname: "bugbug",
//     datePost: "2022.11.23",
//     userLike: "18",
//     userViews: "255",
//     detail: "상세보기",
// };
//
// const addcontent = function (content, i) {
//     console.log(content.datePost);
//     let newcontent = document.createElement("div");
//     newcontent.classList.add("content-list__info-unit");
//     let contentInfoTemplate = `
//   <div class="content-list__info-unit">
//     <input
//       type="checkbox"
//       class="content__checkbox"
//       id="content__${content.id + i}"
//       name="checkbox"
//     />
//     <label for="content__${content.id + i}" class="content__checkbox--label">
//       <ul class="content-list__info">
//         <li class="content__id">${content.id}</li>
//          <li class="content__title">${content.title}</li>
//          <li class="content__user-nickname">${content.userNickname}</li>
//          <li class="content__date-post">${content.datePost}</li>
//          <li class="content__user-like">${content.userLike}</li>
//          <li class="content__user-views">${content.userViews}</li>
//          <li class="content__detail">
//              <button type="button" class="detail-button" onclick="modal()">${content.detail}</button>
//          </li>
//       </ul>
//     </label>
//   </div>
//   `;
//     newcontent.innerHTML = contentInfoTemplate;
//     contentInfoContainer.appendChild(newcontent);
// };
//
// for (let i = 0; i < 10; i++) {
//     addcontent(content, i);
// }


let $pages = $("a.changePage");

$pages.on("click", function(e){
    e.preventDefault();
    $(document.pageForm.page).val($(this).attr("href"));
    document.pageForm.submit();
});

let adminBoardService = (function () {
    function remove(check, callback) {

        var boardNumber = check;
        $.ajax({
            url: "/adminAjax/" + boardNumber,
            type: "get",
            // data: userNumber,
            success: function () {
                location.reload();
            },
            error: function(){
                console.log(boardNumber);
                console.log("에러 발생");
            }
        })
    }

    function read(boardNumber, callback){
        $.ajax({
            url: "/adminAjax/boardDetailRead?boardNumber=" + boardNumber,
            type: "get",
            success: function(board){
                if(callback){
                    callback(board);
                }
            }
        })
    }

    return {remove: remove, read: read}
})();

$(".delete-button").on("click", function(){
    if (confirm(checkBoxArr + "번의 회원을 삭제하시겠습니까?") ) {
        checkBoxArr.forEach(check => adminBoardService.remove(check));
        // checkBoxArr.forEach(check => console.log(check));
        // adminUserService.remove(checkBoxArr);
        return false;
    }
});

var checkBoxArr;

function getUserNumber(){
    checkBoxArr = [];
    $("input:checkbox[name='checkbox']:checked").each(function() {
        checkBoxArr.push($(this).attr('id'));
        console.log(checkBoxArr);
    })
}


/*$(".detail-button").on("click", function(){
    let getBoardNumber = $(this).parent(".content__detail").siblings(".content__id").text();
    adminBoardService.read(getBoardNumber);
    console.log("getBoardNumber : " + getBoardNumber);
});*/

// $.ajax({
//     url:"",
//     type:"",
//     contentType:"",
//     data:"",
//     dataType:"",
//     success:"",
//     error:""
// })

// $('#contentDiv').on('click', '.image-inner a', function(e) {
//     e.preventDefault();
//
//     //글 번호 얻어오기
//     const bno = $(this).attr('href');
//
//     $.getJSON(
//         "<c:url value='/snsBoard/getDetail/' />" + bno,
//         function(data) {
//             console.log(data);
//
//             const img = 'display?fileLoca=' + data.fileloca + '&fileName=' + data.filename;
//             $('#snsImg').attr('src', img); //이미지 경로 처리
//             $('#snsWriter').html(data.writer); //작성자 처리
//             $('#snsRegdate').html(timeStamp(data.regdate)); //날짜 처리
//             $('#snsContent').html(data.content); //내용 처리
//             $('#snsModal').modal('show'); //모달 열기
//         }
//     );
//
// });

///////////////////////////////////////////////////////////////////////////////

// 전체 선택 체크박스
const checkBoxAll = document.getElementsByName("checkbox-all");
const checkBox = document.querySelectorAll('input[name = "checkbox"]');
const checkBoxChecked = document.querySelectorAll(
    'input[name = "checkbox"]:checked'
);

const selectAll = function () {
    if (checkBoxAll[0].checked) {
        checkBox.forEach((e) => (e.checked = true));
    }
    if (!checkBoxAll[0].checked) {
        checkBox.forEach((e) => (e.checked = false));
    }
};

const checkSelectAll = function () {
    if (checkBox.length === checkBoxChecked.length) {
        checkBoxAll[0].checked = true;
    } else if (checkBox.length != checkBoxChecked.length) {
        checkBoxAll[0].checked = false;
    }
    console.log(checkBox.length);
};

checkBoxAll[0].addEventListener("click", selectAll);
checkBox.forEach((e) => {
    e.addEventListener("click", checkSelectAll);
});

console.log(checkBoxChecked);

/*--------------*/
function changeButton() {
    $('#edit-button1').css('visibility', 'hidden');
    $('.input2').attr('readOnly', false);
}

function changeButton2() {
    $('#edit-button1').css('visibility', 'visible');
    $('.input2').attr('readOnly', true);
}

/*--------------*/

/*모달 창 띄우기*/
$(".detail-button").on("click", function(){
    let getBoardNumber = $(this).parent(".content__detail").siblings(".content__id").text();
    $('.modal').css('visibility', 'visible');
    $('#edit-button1').css('visibility', 'visible');
    $('.input2').attr('readOnly', true);
    console.log(getBoardNumber);
    adminBoardService.read(getBoardNumber, showDetail);
});

function closeModal() {
    $('.modal').css('visibility', 'hidden');
    $('#edit-button1').css('visibility', 'hidden');
}

function showDetail(board) {
    console.log(board);
    $("#board-number").val(board.boardNumber);
    $("#user-nickname").val(board.userNickname);
    $("#board-likes").val(board.likeCount);
    $("#board-views").val(board.boardView);
    $("#board-title").val(board.boardTitle);
    $("#board-content").val(board.boardContent);
}