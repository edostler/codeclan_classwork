// const _ = require("lodash");

// NEW CODE FOR LAB
const handleSelectCountryChange = function(){
  const url = "https://restcountries.eu/rest/v2/all";
  makeRequest(url, findCountryRequestComplete);
}

const handleSelectRegionChange = function(){
  const url = "https://restcountries.eu/rest/v2/all";
  makeRequest(url, showRegionRequestComplete);
}

const save = function (country) {
  let savedCountry = [];
  savedCountry.push(country.name);
  savedCountry.push(country.population);
  savedCountry.push(country.capital);
  const jsonString = JSON.stringify(savedCountry);
  localStorage.setItem("savedCountry", jsonString);
}

const findCountryRequestComplete = function() {
  if (this.status !== 200) return;
  const jsonString = this.responseText;
  const countries = JSON.parse(jsonString);
  updateFields(countries);
}

const showRegionRequestComplete = function() {
  if (this.status !== 200) return;
  const jsonString = this.responseText;
  const countries = JSON.parse(jsonString);
  updateRegionList(countries);
}

const updateFields = function(countries) {
  const select = document.querySelector("#country-selector");
  const nameTag = document.querySelector("#name-display");
  const populationTag = document.querySelector("#population-display");
  const capitalTag = document.querySelector("#capital-display");
  countries.forEach(country => {
    if (country.name === select.value){
      nameTag.innerText = country.name;
      populationTag.innerText = country.population;
      capitalTag.innerText = country.capital;
      save(country);
    }
  });
}

const updateRegionList = function(countries) {
  const select = document.getElementById("region-selector");
  const ul = document.getElementById("region-list");
  while (ul.firstChild) {
    ul.removeChild(ul.firstChild);
  }
  countries.forEach(country => {
    if (country.region === select.value){
      const li = document.createElement("li");
      li.innerText = country.name;
      ul.appendChild(li);;
    }
  });
}


// NEW CODE FOR LAB END

const makeRequest = function(url, callback) {
  const request = new XMLHttpRequest();
  request.open("get", url);
  request.addEventListener("load", callback);
  request.send();
}

const requestComplete = function() {
  if (this.status !== 200) return;
    // IN REAL LIFE WE'D WANT TO THINK ABOUT WHAT TO DO IN THE NOT SUCCESSFUL RESPONSE
  const jsonString = this.responseText;
  const countries = JSON.parse(jsonString);
  populateList(countries);
}

const regionRequestComplete = function() {
  if (this.status !== 200) return;
    // IN REAL LIFE WE'D WANT TO THINK ABOUT WHAT TO DO IN THE NOT SUCCESSFUL RESPONSE
  const jsonString = this.responseText;
  const countries = JSON.parse(jsonString);
  populateRegionList(countries);
}

const populateList = function(countries) {
  // const ul = document.getElementById("country-list");

  // NEW CODE FOR LAB
  const select = document.getElementById("country-selector");
  // NEW CODE FOR LAB END

  // let count = 0;
  countries.forEach(country => {
    // const li = document.createElement("li");
    // li.innerText = country.name;
    // ul.appendChild(li);;
    // count += 1;

    // NEW CODE FOR LAB
    const option = document.createElement("option");
    option.innerText = country.name;
    select.appendChild(option);
    // NEW CODE FOR LAB END

  });
  // console.log(count);
}

const populateRegionList = function(countries) {
  const select = document.getElementById("region-selector");
  const regions = [];
  countries.forEach(country => {
    // debugger;
    let booleanTest = _.includes(regions, country.region);
    if (booleanTest === false) {
      regions.push(country.region)
    }
  });
  regions.forEach(region => {
    const option = document.createElement("option");
    option.innerText = region;
    select.appendChild(option);
  });
}

const app = function(){
  const url = "https://restcountries.eu/rest/v2/all";

  // NEW CODE FOR LAB
  makeRequest(url, requestComplete);
  makeRequest(url, regionRequestComplete);
  // NEW CODE FOR LAB END

  // const loadCountries = document.getElementById("load-countries");
  // loadCountries.addEventListener("click", function(){
    // makeRequest(url, requestComplete);
  // });

  // NEW CODE FOR LAB
  const selectCountry = document.querySelector("#country-selector");
  selectCountry.addEventListener("change", handleSelectCountryChange);

  const selectRegion = document.querySelector("#region-selector");
  selectRegion.addEventListener("change", handleSelectRegionChange);
  // NEW CODE FOR LAB END

}

window.addEventListener('load', app);
