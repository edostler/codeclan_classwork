const makeRequest = function(url, callback) {
  const request = new XMLHttpRequest();
  request.open("get", url);
  request.addEventListener("load", callback);
  request.send();
}

const requestComplete = function() {
  if (this.status !== 200) return;
  const jsonString = this.responseText;
  const beers = JSON.parse(jsonString);
  populateList(beers);
}

const populateList = function(beers) {
  const table = document.getElementById("beer-table");
  beers.forEach(beer => {
    const tr = document.createElement("tr");
    const tdImg = document.createElement("td");
    const img = document.createElement("img");
    const tdName = document.createElement("td");
    const tdTag = document.createElement("td");
    const tdDate = document.createElement("td");
    const tdDesc = document.createElement("td");
    img.width = 50;
    img.src = beer.image_url;
    tdName.innerText = beer.name;
    tdTag.innerText = beer.tagline;
    tdDate.innerText = beer.first_brewed;
    tdDesc.innerText = beer.description;
    tdImg.appendChild(img);;
    tr.appendChild(tdImg);;
    tr.appendChild(tdName);;
    tr.appendChild(tdTag);;
    tr.appendChild(tdDate);;
    tr.appendChild(tdDesc);;
    table.appendChild(tr);;
  });
}

var app = function(){
  const url = "https://api.punkapi.com/v2/beers";
  makeRequest(url, requestComplete);
}

window.addEventListener('load', app);
