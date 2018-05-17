let requestType = "all";
let region = ""

const makeRequest = function(url, callback) {
  const request = new XMLHttpRequest();
  request.open("get", url);
  request.addEventListener("load", callback);
  request.send();
}

const requestComplete = function() {
  if (this.status !== 200) return;
  const jsonString = this.responseText;
  const rawCountries = JSON.parse(jsonString);
  filteredCountries = filterList(requestType, rawCountries);
  populateList(filteredCountries);
}

const filterList = function(requestType, rawCountries) {
  filteredCountries = [];
  if (requestType === "all") {
    rawCountries.forEach(country => {
      filteredCountries.push(country);
    });
  }
  else if (requestType === "region") {
    rawCountries.forEach(country => {
      if (country.region === region){
        filteredCountries.push(country);
      }
    });
  }
  else if (requestType === "subregion") {
    rawCountries.forEach(country => {
      if (country.subregion === region){
        filteredCountries.push(country);
      }
    });
  }
  return filteredCountries;
}

const clearTable = function(table) {
  while (table.getElementsByTagName("tr")[2]) {
    table.removeChild(table.getElementsByTagName("tr")[2]);
  }
}

const populateList = function(filteredCountries) {
  const table = document.getElementById("countries-table");
  clearTable(table);
  filteredCountries.forEach(country => {
    const tr = document.createElement("tr");
    const tdFlag = document.createElement("td");
    const img = document.createElement("img");
    const tdName = document.createElement("td");
    const tdRegion = document.createElement("td");
    const regionButton = document.createElement("button");
    const tdSubregion = document.createElement("td");
    const subregionButton = document.createElement("button");
    const tdCapital = document.createElement("td");
    const tdPopulation = document.createElement("td");
    const tdArea = document.createElement("td");
    const tdLatLng = document.createElement("td");
    img.width = 50;
    img.src = country.flag;
    regionButton.type = "button";
    regionButton.className = "region";
    regionButton.id = country.name + "-region";
    regionButton.innerText = country.region;
    subregionButton.type = "button";
    subregionButton.className = "subregion";
    subregionButton.id = country.name + "-subregion";
    subregionButton.innerText = country.subregion;
    tdName.innerText = country.name;
    tdCapital.innerText = country.capital;
    tdPopulation.innerText = country.population;
    tdArea.innerText = country.area;
    tdLatLng.innerText = country.latlng;
    tdFlag.appendChild(img);
    if (country.region) {
      tdRegion.appendChild(regionButton);
    }
    if (country.subregion) {
      tdSubregion.appendChild(subregionButton);
    }
    tr.appendChild(tdFlag);
    tr.appendChild(tdName);
    tr.appendChild(tdRegion);
    tr.appendChild(tdSubregion);
    tr.appendChild(tdCapital);
    tr.appendChild(tdPopulation);
    tr.appendChild(tdArea);
    tr.appendChild(tdLatLng);
    table.appendChild(tr);
  });
}

var app = function(){
  const url = "https://restcountries.eu/rest/v2/all";
  makeRequest(url, requestComplete);

  const table = document.getElementById("countries-table");
  table.addEventListener("click", function(event){
    if (event.target.type === "button") {
      requestType = event.target.className;
      region = event.target.textContent;
      makeRequest(url, requestComplete);
    }
  });
}

window.addEventListener('load', app);
