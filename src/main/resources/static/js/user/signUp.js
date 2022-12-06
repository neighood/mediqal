/*flag*/
var flag1 = false;
var flag2 = false;
var flag3 = false;
var flag4 = false;
var flag5 = false;
var flag6 = false;
var flag7 = false;



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

function checkId() {
    var userEmail = $('#userEmail').val();
    $.ajax({
        url:"./idCheck",
        type:"post",
        data:{userEmail:userEmail},
        success: function(cnt){
            if (userEmail == undefined || userEmail == "undefined" || userEmail == null || userEmail == "" ){
                $("#result").html("아이디를 입력해주세요.");
                $("#result").css('color','red');
                $("#result").css('visibility','visible');
                flag3 = false;
            }else if (cnt == 0){
                $("#result").html("사용가능한 아이디 입니다.");
                $("#result").css('color','blue');
                $("#result").css('visibility','visible');
                flag3 = true;
            }else{
                $("#result").html("이미 사용중인 아이디 입니다.");
                $("#result").css('color','red');
                $("#result").css('visibility','visible');
                flag3 = false;
            }
        },
        error: function() {
            alert("에러입니다.");
        }
    })
}

function checkNickname() {
    var userNickname = $('#userNickname').val();
    $.ajax({
        url:"./nicknameCheck",
        type:"post",
        data:{userNickname:userNickname},
        success: function(cnt1){
            if (userNickname == undefined || userNickname == "undefined" || userNickname == null || userNickname == ""){
                $("#result2").css('visibility','hidden');
                flag5 = false;
            }else if (cnt1 == 0){
                $("#result2").html("사용가능한 닉네임 입니다.");
                $("#result2").css('color','blue');
                $("#result2").css('visibility','visible');
                flag5 = true;
            }else{
                $("#result2").html("이미 사용중인 닉네임 입니다.");
                $("#result2").css('color','red');
                $("#result2").css('visibility','visible');
                flag5 = false;
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
        flag4 = true;
    }else {
        $("#under-name").html("2~4자 이내의 한글로 입력해주세요.");
        $("#under-name").css('color', 'red');
        $("#under-name").css('visibility', 'visible');
        flag4 = false;
    }
}

/* checkbox 체크 여부 확인*/

var checkbox1 = $("#terms-check");
var checkbox2 = $("#email-check");



/*-----------------------
* */

function checkNull(event) {
    var input1 = $('#userEmail').val();
    var input2 = $('#password').val();
    var input3 = $('#passwordCheck').val();
    var input4 = $('#userName').val();
    var input5 = $('#userNickname').val();

    if(input1.replace(/\s /gi, "").length == 0){
        alert("빈칸을 입력해주세요.");
        $("#userEmail").focus();
        return false;
    } else if(input2.replace(/\s /gi, "").length == 0){
        alert("빈칸을 입력해주세요.");
        $("#password").focus();
        return false;
    } else if(input3.replace(/\s /gi, "").length == 0){
        alert("빈칸을 입력해주세요.");
        $("#passwordCheck").focus();
        return false;
    } else if(input4.replace(/\s /gi, "").length == 0){
        alert("빈칸을 입력해주세요.");
        $("#userName").focus();
        return false;
    } else if(input5.replace(/\s /gi, "").length == 0){
        alert("빈칸을 입력해주세요.");
        $("#userNickname").focus();
        return false;
    } else if(flag1 == false || flag2 == false || flag3 == false || flag4 == false || flag5 == false) {
        alert("형식에 맞지 않는 입력이 있는지 확인해주세요.")
        $("#userEmail").focus();
        return false;
    } else if($("#terms-check").is(':checked') == false || $("#email-check").is(":checked") == false){
        alert("체크박스를 확인해주세요.");
        checkbox1.focus();
    } else {
        alert("회원가입 완료");
        document.userForm.submit();
        // $("signup-button").prop("type","submit");
    }
}
function checkNull2(event) {
    var input1 = $('#userEmail').val();
    var input2 = $('#password').val();
    var input3 = $('#passwordCheck').val();
    var input4 = $('#userName').val();
    var input5 = $('#userNickname').val();

    if (flag5 == false){
        alert("형식에 맞지 않는 입력이 있는지 확인해주세요.");
        $("#userNickname").focus();
        return false;
    } else if($("#terms-check").is(':checked') == false || $("#email-check").is(":checked") == false){
        alert("체크박스를 확인해주세요.");
        checkbox1.focus();
    } else{
        alert("회원가입 완료");
        document.userForm.submit();
        // $("signup-button").prop("type","submit");
    }
}
var inputAuthType = $("#userAuthType");
window.onload = function(){
    console.log("inputAuthType = " + inputAuthType.val());
    if(inputAuthType.val()!="kakao"){
        console.log("inputAuthType.val()==\"");
        $("#userEmail").attr('readonly', false);
        $("#password").attr('readonly', false);
        $("#passwordCheck").attr('readonly', false);
        $("#userName").attr('readonly', false);
        // divPw.style.display = "none";
        // check1 = true;
        // check2 = true;
        // check5 = true;
    }
    else{
        // $("#userEmail").on("blur", function(){checkId($(this).val());});
        console.log(false);
        $("#userEmailInput").attr('readonly', true);
        $("#passwordInput").attr('readonly', true);
        $("#passwordCheckInput").attr('readonly', true);
        $("#userNameInput").attr('readonly', true);
        flag1 = true;
        flag2 = true;
        flag3 = true;
        flag4 = true;
    }
}

function showAlert(e) {
    alert("준비중인 서비스입니다. 카카오 로그인을 이용해주세요.");
    e.preventDefault();
}
