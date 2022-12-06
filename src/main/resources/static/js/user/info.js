let arrayFile = [];

let nickname = $("#userNickname").val();


$("input[type='file']").on('change', function(){
    let formData = new FormData();
    let files = this.files;

    Array.from(files).forEach(file => arrayFile.push(file));
    const dataTransfer = new DataTransfer();
    arrayFile.forEach(file => dataTransfer.items.add(file));
    $(this)[0].files = dataTransfer.files;

    $(files).each(function(i, file){
        formData.append("upload", file);
    });

    $.ajax({
        url: "/userImg/upload",
        type: "post",
        data: formData,
        contentType: false,
        processData: false,
        success: showUploadResult
    })
});

function showUploadResult(files){
    let $infoImg = $(".info__img-img");
    $(files).each(function(i, file){
        $('#userImgSize').val(file.userImgSize);
        $('#userImgName').val(file.userImgName);
        $('#userImgUploadPath').val(file.userImgUploadPath);
        $('#userImgUuid').val(file.userImgUuid);
        $('#userImgImageCheck').val(file.userImgImageCheck);

        flag3 = true;
        $infoImg.attr("src", "/userImg/display?fileName=" + file.userImgUploadPath + "/s_" + file.userImgUuid + "_" + file.userImgName);
    });
}

/*$(".uploadResult ul").on("click", "span", function(){
    const $li = $(".hidden").closest("li");
    let i = $(".uploadResult ul span").index($(this));

    $.ajax({
        url: "/userImg/delete",
        type: "post",
        data: {userImgUploadPath: fileUploadPath, userImgName: fileName, userImgImageCheck: fileImageCheck},
        success: function(){
            $li.remove();
            const dataTransfer = new DataTransfer();
            arrayFile.forEach(file => dataTransfer.items.add(file));
            $("input[name='upload']")[0].files = dataTransfer.files;
        }
    });
});*/


$(".info__img-btn").on("click", function (e) {
    $("#upload").click();
});

let urlParams = new URL(location.href).searchParams;
let check = urlParams.get("profileCheck");
console.log(check);
if(check == 'yes'){
    alert("회원 정보 수정");
}


var flag1 = true;
var flag2 = true;
var flag3 = false;
/* 닉네임 중복 검사 */

// $("#id-input").on("input", checkNickname());
//
function checkNickname() {
    var userNickname = $('#userNickname').val();
    console.log("d"+userNickname);
    $.ajax({
        url:"./nicknameCheck",
        type:"post",
        data:{userNickname:userNickname},
        success: function(cnt1){
            if(userNickname == undefined || userNickname == "undefined" || userNickname == null || userNickname == ""){
                $("#result2").html("닉네임을 입력해주세요.");
                $("#result2").css('color','red');
                $("#result2").css('visibility','visible');
                flag3 = false;
            }else if (cnt1 == 0){
                $("#result2").html("사용가능한 닉네임 입니다.");
                $("#result2").css('color','blue');
                $("#result2").css('visibility','visible');
                console.log(userNickname);
                flag1 = true;
                flag3 = true;
            }else if (userNickname == nickname){
                $("#result2").css('visibility','hidden');
                flag1 = true;
                flag3 = false;
                console.log(userNickname);
            }else{
                $("#result2").html("이미 사용중인 닉네임 입니다.");
                $("#result2").css('color','red');
                $("#result2").css('visibility','visible');
                flag2 = false;
                flag3 = true;
                console.log(userNickname);
            }
        },
        error: function() {
            alert("에러입니다.");
        }
    })
}

/*----------------------*/

function checkName(str) {
    var userName = $('#userName').val();
    str = userName;
    var reg = /^[가-힣]{2,4}$/;
    if (reg.test(str)){
        $("#under-name").html("사용가능한 이름 입니다.");
        $("#under-name").css('color','blue');
        $("#under-name").css('visibility','visible');
        flag2 = true;
        flag3 = true;
    }else {
        $("#under-name").html("2~4자 이내의 한글로 입력해주세요.");
        $("#under-name").css('color', 'red');
        $("#under-name").css('visibility', 'visible');
        flag2 = false;
        flag3 = true;
    }
}

function checkFlag() {
    if (flag1 == false){
        alert("닉네임을 확인해주세요.");
        $("#userNickname").focus();
        return false;
    } else if (flag2 == false){
        alert("이름을 형식에 맞게 작성해주세요.")
        $("#userName").focus();
        return false;
    } else if (flag1 == false || flag2 == false){
        alert("형식에 맞게 입력했는지 확인해주세요.");
        return false;
    } else if(flag3 == false){
        alert("변경된 내용이 없습니다.");
    } else {
        // alert("수정완료");
        document.userForm.submit();
    }

}