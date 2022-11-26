const $logo = $(".header-logo");
const $community = $(".header-community");
const $review = $(".header-review");
const $signin = $(".header-signin");
const $signup = $(".header-signup");
const $mypage = $(".header-mypage");
const $signout = $(".header-signout");

$logo.on("click", function(e){
    e.preventDefault();
    location.href = "/main/index";
});

$community.on("click", function(e){
    e.preventDefault();
    location.href = "/board/board";
});

$review.on("click", function(e){
    e.preventDefault();
    location.href = "/board/review";
});

$signin.on("click", function(e){
    e.preventDefault();
    location.href = "/user/signin";
});

$signup.on("click", function(e){
    e.preventDefault();
    location.href = "/user/signup";
});

$mypage.on("click", function(e){
    e.preventDefault();
    location.href = "/mypage";
});

$signout.on("click", function(e){
    e.preventDefault();
    location.href = "/signout";
});