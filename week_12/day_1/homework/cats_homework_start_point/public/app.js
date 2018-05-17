// const app = function(){
//   const ul = document.createElement("ul");
//   ul.classList.add("cat");
//
//   const liName = document.createElement("li");
//   liName.innerText = "Name: Twizzle";
//   const liFood = document.createElement("li");
//   liFood.innerText = "Favourite food: Cat-nip";
//   const liPic = document.createElement("li");
//   liPic.innerHTML = "<img width='500' src='https://a1-images.myspacecdn.com/images02/122/216632b506e448d4adc76afbdfdf6a75/full.jpg'>";
//
//   ul.appendChild(liName);
//   ul.appendChild(liFood);
//   ul.appendChild(liPic);
//   const section = document.getElementById("cats");
//   section.appendChild(ul);
//
//   debugger;
// }
//
// window.onload = app;


const createUl = function(){
  const ul = document.createElement("ul");
  ul.classList.add("cat");
  return ul;
}

// const createLiName = function(name){
//   const liName = document.createElement("li");
//   liName.innerText = "Name: " + name;
//   return liName;
// }
//
// const createLiFood = function(food){
//   const liFood = document.createElement("li");
//   liFood.innerText = "Favourite food: " + food;
//   return liFood;
// }

const createLi = function(label, text){
  const li = document.createElement("li");
  li.innerText = label + text;
  return li;
}

const createLiPic = function(imgLink){
  const liPic = document.createElement("li");
  const img = document.createElement("img");
  img.width = 500;
  img.src = imgLink;
  liPic.appendChild(img);
  return liPic;
}

const appendElements = function(ul, liName, liFood, liPic){
  ul.appendChild(liName);
  ul.appendChild(liFood);
  ul.appendChild(liPic);
  const section = document.getElementById("cats");
  section.appendChild(ul);
}

const addCat = function(name, food, imgLink) {
  const ul = createUl();
  const liName = createLi("Name: ", name);
  const liFood = createLi("Favourite food: ", food);
  const liPic = createLiPic(imgLink);
  appendElements(ul, liName, liFood, liPic);
}

window.onload = function(){
  addCat("Boba", "Sock fluff", "http://66.media.tumblr.com/d1f01bbe0150fda0c40d2151c5eaeac8/tumblr_odlqqskjj61v9cejwo1_400.jpg");
  addCat("Barnaby", "Tuna", "https://68.media.tumblr.com/88d0fcf2b84a7b098dda839130597569/tumblr_okuo4teiql1uhevdso1_1280.jpg");
  addCat("Max", "Whiskas Temptations", "http://66.media.tumblr.com/7c5784ea89369c780e782bf10c60315a/tumblr_npb0hlYwhV1u63jaco1_1280.jpg");
  addCat("Twizzle", "Cat-nip", "https://a1-images.myspacecdn.com/images02/122/216632b506e448d4adc76afbdfdf6a75/full.jpg");
};

// SEE HOMEWORK NOTES AND REFACTOR THE BELOW USING THE LOOP ARRAY METHOD
// cats = {
//   "Boba",
//   "Sock fluff",
//   "http://66.media.tumblr.com/d1f01bbe0150fda0c40d2151c5eaeac8/tumblr_odlqqskjj61v9cejwo1_400.jpg",
//   "Barnaby",
//   "Tuna",
//   "https://68.media.tumblr.com/88d0fcf2b84a7b098dda839130597569/tumblr_okuo4teiql1uhevdso1_1280.jpg",
//   "Max",
//   "Whiskas Temptations",
//   "http://66.media.tumblr.com/7c5784ea89369c780e782bf10c60315a/tumblr_npb0hlYwhV1u63jaco1_1280.jpg",
//   "Twizzle",
//   "Cat-nip",
//   "https://a1-images.myspacecdn.com/images02/122/216632b506e448d4adc76afbdfdf6a75/full.jpg"
// }
// window.onload = function(){
//   addCat();
//   addCat();
//   addCat();
//   addCat();
// };
