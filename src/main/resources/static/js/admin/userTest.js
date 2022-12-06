////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

let $pages = $("a.changePage");

$pages.on("click", function(e){
    e.preventDefault();
    $(document.pageForm.page).val($(this).attr("href"));
    document.pageForm.submit();
});

let adminUserService = (function () {

    function remove(check, callback) {

        var userNumber = check;
        $.ajax({
            url: "/adminAjax/" + userNumber,
            type: "delete",
            // data: userNumber,
            success: function () {
                location.reload();
            },
            error: function(){
                console.log(userNumber);
                console.log("에러 발생");
            }
        })
    }

    function read(userNumber, callback){
        $.ajax({
            url: "/adminAjax/userDetailRead?userNumber=" + userNumber,
            type: "get",
            success: function(user){
                if(callback){
                    callback(user);
                }
            }
        })
    }

    function get(userNumber, callback){
        $.ajax({
            url: "/adminAjax/getUserImg?userNumber=" + userNumber,
            type: "get",
            success: function(userImg){
                if(callback){
                    callback(userImg);
                }
            }
        })
    }

    return {remove: remove, read: read, get: get}
})();

$(".delete-button").on("click", function(){
    if (confirm(checkBoxArr + "번의 회원을 삭제하시겠습니까?") ) {
        checkBoxArr.forEach(check => adminUserService.remove(check));
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

$(".detail-button").on("click", function(){
    var getUserNumber = $(this).parent(".user__detail").siblings(".user__id").text();
    console.log("getUserNumber : " + getUserNumber);
});


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

/*----------------------------------------*/
function changeButton() {
    $('#edit-button1').css('visibility', 'hidden');
    $('.user-input2').attr('readOnly', false);
}

function changeButton2() {
    // $('#edit-button1').css('visibility', 'visible');
    // $('.user-input2').attr('readOnly', true);
    $("#hds").submit();
}

/*----------------------------------------*/

/*유저 정보 모달 창 띄우기*/
$(".detail-button").on("click", function(){
    let getUserNumber = $(this).parent(".user__detail").siblings(".user__id").text();
    $('.modal').css('visibility', 'visible');
    $('#edit-button1').css('visibility', 'visible');
    $('.input2').attr('readOnly', true);
    console.log(getUserNumber);
    adminUserService.read(getUserNumber, showDetail);
    adminUserService.get(getUserNumber, showImg);
});

function closeModal() {
    $('.modal').css('visibility', 'hidden');
    $('#edit-button1').css('visibility', 'hidden');
}

function showDetail(user) {
    console.log(user);
    $("#user-number").val(user.userNumber);
    $("#user-name").val(user.userName);
    $("#user-email").val(user.userEmail);
    $("#userPassword").val(user.userPassword);
    $("#userNickname").val(user.userNickname);
    $("#user-grade").val(user.userType);
}

function showImg(userImg){
    console.log(userImg);
    if(userImg.userImgImageCheck) {
        var url = "/userImg/display?fileName=" + userImg.userImgUploadPath + '/s_' + userImg.userImgUuid + '_' + userImg.userImgName;
    }else {
        var url = "https://avatars.dicebear.com/api/identicon/medirqlasdf" + userImg.userNumber + ".svg";
    }
    $(".profile-image img").attr("src", url);
}