let urlParams = new URL(location.href).searchParams;
let check = urlParams.get("profileCheck");
console.log(check);
if(check == 'yes'){
    alert("비밀번호 변경");
}
else if(check == 'no'){
    alert("비밀번호 확인하세요!");
}