// content 목록 생성
const contentInfoContainer = document.getElementsByClassName(
    "content-list__info-container"
)[0];

let content = {
    id: "1351",
    title: "열이나고 근육통이 있어요.",
    userNickname: "bugbug",
    datePost: "2022.11.23",
    userLike: "18",
    userViews: "255",
    detail: "상세보기",
};

const addcontent = function (content, i) {
    console.log(content.datePost);
    let newcontent = document.createElement("div");
    newcontent.classList.add("content-list__info-unit");
    let contentInfoTemplate = `
  <div class="content-list__info-unit">
    <input
      type="checkbox"
      class="content__checkbox"
      id="content__${content.id + i}"
      name="checkbox"
    />
    <label for="content__${content.id + i}" class="content__checkbox--label">
      <ul class="content-list__info">
        <li class="content__id">${content.id}</li>
         <li class="content__title">${content.title}</li>
         <li class="content__user-nickname">${content.userNickname}</li>
         <li class="content__date-post">${content.datePost}</li>
         <li class="content__user-like">${content.userLike}</li>
         <li class="content__user-views">${content.userViews}</li>
         <li class="content__detail">
             <button type="button" class="detail-button" onclick="modal()">${content.detail}</button>
         </li>
      </ul>
    </label>
  </div>
  `;
    newcontent.innerHTML = contentInfoTemplate;
    contentInfoContainer.appendChild(newcontent);
};

for (let i = 0; i < 10; i++) {
    addcontent(content, i);
}

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

/*--------------*/
function changeButton() {
    $('#edit-button1').css('visibility', 'hidden');
    $('.input2').attr('readOnly', false);
}

function changeButton2() {
    $('#edit-button1').css('visibility', 'visible');
    $('.input2').attr('readOnly', true);
}

/*--------------*/

/*모달 창 띄우기*/
function modal() {
    $('.modal').css('visibility', 'visible');
    $('#edit-button1').css('visibility', 'visible');
    $('.input2').attr('readOnly', true);
}

function closeModal() {
    $('.modal').css('visibility', 'hidden');
    $('#edit-button1').css('visibility', 'hidden');
}
