// var app = function() {
//   const tag = document.getElementById("tagline");
//   const quotes1 = document.getElementsByClassName("quote");
//   const quotes2 = document.getElementsByTagName("article");
//   const citations = document.getElementsByTagName("cite");
//   const quoteOfTheDay = document.getElementById("quote-of-the-day");
//   const quotes3 = document.querySelector(".quote");
//   // NOTICE - that querySelector only provides you with one thing back
//   const quotes4 = document.querySelectorAll(".quote");
//   const element = document.getElementById("sign-up");
//   let children = element.children;
//   for (let i = 0; i < children.length; i++){
//     console.log(children[i]);
//   }
//   const tagline = document.getElementById("tagline");
//   // tagline.innerText = "New tagline";
//   // innerText is for when it is only text being injected, which isn't always useful
//   tagline.innerHTML = "<span>Hey</span>";
//   const quotes5 = document.getElementsByTagName("article");
//   quotes5[0].className = "red-quote";
//   // NOTICE - the below is not recommended, CSS should be done in CSS, but it is possible
//   quotes5[0].style.backgroundColor = "tomato";
//   // NOTICE - remember that when you hide something the user can still see the contents by inspecting the page
//   // quotes5[0].style.display = "none";
//   debugger;
// };

// const app = function(){
//   // STEP 1 - CREATE PARENT CONTAINER, ARTICLE, AND IT'S CLASS, .QUOTE
//   let quoteArticle = document.createElement("article");
//   quoteArticle.classList.add("quote");
//   // STEP 2 - CREATE FIRST CHILD ELEMENT, BLOCKQUOTE, AND IT'S TEXT
//   let blockquote = document.createElement("blockquote");
//   blockquote.innerText = "It's a dangerous business, Frodo, going out your door.";
//   // STEP 3 = CREATE THE CITE ELEMENT AND IT'S TEXT
//   let cite = document.createElement("cite");
//   cite.innerText = " Bilbo Baggins";
//   // STEP 4 - APPEND CITE ELEMENT TO BLOCKQUOTE
//   blockquote.appendChild(cite);
//   // STEP 5 - APPEND BLOCKQUOTE ELEMENT TO ARTICLE
//   quoteArticle.appendChild(blockquote);
//   // STEP 6 - ADD ARTICLE TO THE LIST OF QUOTES
//   // const section = document.getElementById("quotes");
//   let quotes = document.querySelector("#quotes");
//   quotes.appendChild(quoteArticle);
//   debugger;
// }

const createQuoteArticle = function(){
 const quoteArticle = document.createElement("article");
 quoteArticle.classList.add("quote");
 return quoteArticle;
}

const createBlockQuote = function(quoteText){
 const blockquote = document.createElement("blockquote");
 blockquote.innerText = quoteText + " ";
 return blockquote;
}

const createCite = function(author){
 const cite = document.createElement("cite");
 cite.innerText = author;
 return cite;
}

const appendElements = function(quoteArticle, blockquote, cite){
 blockquote.appendChild(cite);
 quoteArticle.appendChild(blockquote);
 const quotes = document.querySelector("#quotes");
 quotes.appendChild(quoteArticle);
}

const addQuote = function(author, quoteText) {
 const quoteArticle = createQuoteArticle();
 const blockquote = createBlockQuote(quoteText);
 const cite = createCite(author);
 appendElements(quoteArticle, blockquote, cite);
}

window.onload = function(){
  addQuote("Ed Ostler", "Here goes nothing!");
};
