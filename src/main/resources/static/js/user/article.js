// content 목록 생성
const articleContainer = document.getElementsByClassName(
  "article-list-container"
)[0];

let article = {
  title: "배가 아픈데 장염인가요?",
  date: "2022.11.22",
  useful: "3",
  reply: "6",
};

const addcontent = function (article, i) {
  console.log(article.post);
  let newArticle = document.createElement("form");
  newArticle.classList.add("article-list-unit");
  let listInfoTemplate = `
  <input
    type="checkbox"
    class="list-unit__checkbox"
    id="unit__checkbox__${i}"
  />
  <ul class="list-unit-container">
    <li class="list-unit__title">${article.title}</li>
    <li class="list-unit__date">${article.date}</li>
    <li class="list-unit__useful">${article.useful}</li>
    <li class="list-unit__reply">${article.reply}</li>
  </ul>
  `;
  newArticle.innerHTML = listInfoTemplate;
  articleContainer.appendChild(newArticle);
};

for (let i = 0; i < 12; i++) {
  addcontent(article, i);
}
