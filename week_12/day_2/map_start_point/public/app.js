const initialize = function(){

  const rampartAvenue = {
    lat: 55.898499,
    lng: -4.356209
  };
  const container = document.querySelector("#main-map");
  const zoom = 15;
  const map = new MapWrapper(container, rampartAvenue, zoom);

  const homeMarker = map.addMarker(rampartAvenue);

  const contentString =
    "<div>"+
      "<h2>Ed and Emma's House</h2>"+
      "<div>"+
        "<p><b>51 Rampart Avenue</b>, the residence of Ed and Emma</p>"+
      "</div>"+
    "</div>";

  map.addInfoWindow(homeMarker, contentString)

  map.addClickEvent();

  const howlingWolf = {
    lat: 55.864180,
    lng: -4.258068
  };
  map.addMarker(howlingWolf);

  const bounceButton = document.getElementById("button-bounce-markers");
  bounceButton.addEventListener("click", map.bounceMarkers.bind(map));

  const homeButton = document.getElementById("button-to-home");
  homeButton.addEventListener("click", function(){
    map.goToLocation(rampartAvenue);
  });

  const pubButton = document.getElementById("button-to-pub");
  pubButton.addEventListener("click", function(){
    map.goToLocation(howlingWolf);
  });

  const meButton = document.getElementById("button-to-me");
  meButton.addEventListener("click", function(){
    map.goToMe(map);
  });

  // const meButton = document.getElementById("button-to-me");
  // meButton.addEventListener("click", function(){
  //   navigator.geolocation.getCurrentPosition(success, error);
  //   const me = {
  //     lat: position.coords.latitude,
  //     lng: position.coords.longitude
  //   };
  //   map.goToLocation(me);
  // });

  // DISTANCE BETWEEN TWO COORDs
  // var R = 6371e3; // metres
  // var φ1 = lat1.toRadians();
  // var φ2 = lat2.toRadians();
  // var Δφ = (lat2-lat1).toRadians();
  // var Δλ = (lon2-lon1).toRadians();
  //
  // var a = Math.sin(Δφ/2) * Math.sin(Δφ/2) +
  //         Math.cos(φ1) * Math.cos(φ2) *
  //         Math.sin(Δλ/2) * Math.sin(Δλ/2);
  // var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
  //
  // var d = R * c;

}

window.addEventListener("DOMContentLoaded", initialize);
