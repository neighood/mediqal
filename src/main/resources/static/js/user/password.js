let urlParams = new URL(location.href).searchParams;
let check = urlParams.get("profileCheck");
console.log(check);
if(check == 'yes'){
    alert("비밀번호 변경완료");
}
else if(check == 'no'){
    alert("기존 비밀번호가 일치하지 않습니다.");
}

/* ------------------------------------------------ */
flag1 = false;
flag2 = false;

// 비밀번호 정규식
function chkPW() {
    var pw = $("#password").val();
    // var underPw = $("#under-password");
    var num = pw.search(/[0-9]/g);
    var eng = pw.search(/[a-z]/ig);

    var spe = pw.search(/[`~!@@#$%^&*|₩₩₩'₩";:₩/?]/gi);

    if (pw.length == 0) {
        $('#under-password').html('비밀번호를 입력해주세요.');
        $('#under-password').css('color', 'red');
        $('#under-password').css('visibility', 'visible');
        flag1 = false;
    } else if (pw.length < 8 || pw.length > 20) {
        $('#under-password').html('8자리 ~ 20자리 이내로 입력해주세요.');
        $('#under-password').css('color', 'red');
        $('#under-password').css('visibility', 'visible');
        flag1 = false;
        // return false;
    } else if (pw.search(/\s/) != -1) {
        $('#under-password').html('비밀번호는 공백 없이 입력해주세요.');
        $('#under-password').css('color', 'red');
        $('#under-password').css('visibility', 'visible');
        flag1 = false;
        // return false;
    } else if (num < 0 || eng < 0 || spe < 0) {
        $('#under-password').html('영문,숫자, 특수문자를 혼합하여 입력해주세요.');
        $('#under-password').css('color', 'red');
        $('#under-password').css('visibility', 'visible');
        flag1 = false;
        // return false;
    } else {
        $('#under-password').html('사용 가능한 비밀번호 입니다.');
        $('#under-password').css('color', 'blue');
        $('#under-password').css('visibility', 'visible');
        flag1 = true;
        console.log("통과");
        // return true;
    }
}
function chkPW2() {
    var pw1 = $("#password").val();
    var pw2 = $("#passwordCheck").val();

    if (pw1 == pw2 && pw2.length >= 8 && pw2.length <= 20){
        $('#under-passwordCheck').html('비밀번호가 일치합니다.');
        $('#under-passwordCheck').css('color','blue');
        $('#under-passwordCheck').css('visibility','visible');
        flag2 = true;
    } else {
        $('#under-passwordCheck').html('다시 확인해주세요.');
        $('#under-passwordCheck').css('color','red');
        $('#under-passwordCheck').css('visibility','visible');
        flag2 = false;
    }
}

function chkPW3() {
    var pw3= $("#passwordCheck").val();
    if (pw3.length==0){
        $('#under-passwordCheck').css('visibility','hidden');
    }
}

function checkAll() {
    if(flag1 == false || flag2 == false) {
        alert("형식에 맞지 않는 입력이 있는지 확인해주세요.");
        $("#password").focus();
        return false;
        console.log($("#pw--current-input").val());
        console.log($("#passwordCheck").val());
    } else if ($("#pw--current-input").val() == $("#passwordCheck").val()){
        console.log("들어옴!!!");
        alert("현재 비밀번호와 동일합니다.");

    } else{
        document.passwordForm.submit();
    }

}