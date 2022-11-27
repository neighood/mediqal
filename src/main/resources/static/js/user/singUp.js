// $.ajax({
//     url:"",
//     type:"",
//     contentType:"",
//     data:"",
//     dataType:"",
//     success:"",
//     error:""
// })

$("#userEmail").on("blur", function () {
    checkId($(this).val());
})

function checkId(userEmail){

    if(!userEmail){
        $("#result").text("아이디를 입력해주세요.");
        return;
    }

    $.ajax({
        url:"",
        type:"",
        contentType:"",
        data:"",
        dataType:"",
        success: function(result){
            $("#result").text("사용가능한 아이디 입니다.");
            $("#result").color("blue");
        },
        error: function(a, b, c) {
            console.log(a, b, c);
        }
    })

}