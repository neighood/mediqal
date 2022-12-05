let arrayFile = [];


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
})