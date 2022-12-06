// user 목록 생성
// const UserInfoContainer = document.getElementsByClassName(
//     "user-list__info-container"
// )[0];
//
// let user = {
//     signNumber: "11",
//     id: "254",
//     name: "홍길동",
//     email: "hgd1212@naver.com",
//     phone: "010-4213-7658",
//     grade: "일반회원",
//     detail: "상세보기"
// };
//
// const addUser = function (user, i) {
//     let newUser = document.createElement("div");
//     newUser.classList.add("user-list__info-unit");
//     let userInfoTemplate = `
//   <div class="user-list__info-unit">
//     <input
//       type="checkbox"
//       class="user__checkbox"
//       id="user__${user.id + i}"
//       name="checkbox"
//     />
//     <label for="user__${user.id + i}" class="user__checkbox--label">
//       <ul class="user-list__info">
//         <li class="user__sign-number">${user.signNumber}</li>
//         <li class="user__id">${user.id}</li>
//         <li class="user__name">${user.name}</li>
//         <li class="user__email">${user.email}</li>
//         <li class="user__phone">${user.phone}</li>
//         <li class="user__grade">${user.grade}</li>
//         <li class="user__detail"><button type="button" class="detail-button" onclick="modal()">${user.detail}</button></li>
//       </ul>
//     </label>
//   </div>
//   `;
//     newUser.innerHTML = userInfoTemplate;
//     UserInfoContainer.appendChild(newUser);
// };
//
// for (let i = 0; i < 10; i++) {
//     addUser(user, i);
// }

window.addEventListener('DOMContentLoaded', function(e) {
    alert("페이지 준비중입니다.");
    history.back();
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

/*유저 정보 모달 창 띄우기*/
function modal() {
    $('.modal').css('visibility', 'visible');
}
function closeModal() {
    $('.modal').css('visibility', 'hidden');
}