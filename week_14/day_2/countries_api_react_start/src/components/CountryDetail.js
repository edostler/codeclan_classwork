import React from 'react';

const CountryDetail = (props) => {
  if(!props.country) {
    return null;
  }
  return (
    <article>
      <img src={props.country.flag} alt={props.country.name} width="200px"></img>
      <h3>Country: {props.country.name}</h3>
      <h4>Capital: {props.country.capital}</h4>
      <h4>Population: {props.country.population}</h4>
    </article>
  )
}

export default CountryDetail;
