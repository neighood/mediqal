var textInput = $("#leave--current-input");

function checkLeave() {
    if (textInput.val() == "회원탈퇴"){
        console.log("회원탈퇴 들어옴");
        console.log(textInput.val());
        alert("회원탈퇴가 완료되었습니다.")
        document.leaveForm.submit();
    } else {
        console.log("회원탈퇴 실패");
        console.log(textInput.val());
        alert("잘못 입력하셨습니다.");
    }
}