const QuoteView = require('./views/quoteView');
const Request = require('./services/request.js');
const quoteView = new QuoteView();
const request = new Request('http://localhost:3000/api/quotes');

const getQuotesRequestComplete = function(allQuotes){
  allQuotes.forEach(function(quote){
    quoteView.addQuote(quote);
  });
}

const createButtonClicked = function(event){
  event.preventDefault();
  const nameInputValue = document.querySelector("#name").value;
  const quoteInputValue = document.querySelector("#quote").value;
  const quoteToSend = {
    name: nameInputValue,
    quote: quoteInputValue
  }
  request.post(createRequestComplete, quoteToSend);
}

const createRequestComplete = function(response){
  quoteView.addQuote(response);
}

const deleteButtonClicked = function(){
  request.delete(deleteRequestComplete);
}

const deleteRequestComplete = function(){
  quoteView.clear();
}

const appStart = function(){
  request.get(getQuotesRequestComplete);

  const createQuoteButton = document.querySelector("#submit-quote");
  createQuoteButton.addEventListener("click", createButtonClicked);

  const deleteButton = document.querySelector("#deleteButton");
  deleteButton.addEventListener("click", deleteButtonClicked);
}

document.addEventListener('DOMContentLoaded', appStart);
