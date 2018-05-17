const MapWrapper = function(container, coords, zoom){
  this.googleMap = new google.maps.Map(container, {
    center: coords,
    // ZOOM GOES FROM 0-20
    zoom: zoom,
  });
  this.markers = [];
}

MapWrapper.prototype.addMarker = function (coords) {
  const marker = new google.maps.Marker({
    position: coords,
    map: this.googleMap
  });
  this.markers.push(marker);
  return marker;
};

MapWrapper.prototype.addInfoWindow = function (marker, text) {
  const infowindow = new google.maps.InfoWindow({
    content: text
  });
  marker.addListener('click', function() {
    infowindow.open(this.googleMap, marker);
  });
};

MapWrapper.prototype.addClickEvent = function () {
  google.maps.event.addListener(this.googleMap, "click", function(event){
    const markerLat = event.latLng.lat();
    const marketLng = event.latLng.lng();
    const coords = {
      lat: markerLat,
      lng: marketLng
    };
    this.addMarker(coords);
  }.bind(this));
};

MapWrapper.prototype.bounceMarkers = function () {
  this.markers.forEach(function(marker){
    marker.setAnimation(google.maps.Animation.BOUNCE);
  })
};

MapWrapper.prototype.goToLocation = function (coords) {
  this.googleMap.setCenter(coords);
};

MapWrapper.prototype.goToMe = function (map) {
  var output = document.getElementById("out");
  if (!navigator.geolocation){
    output.innerHTML = "<p>Geolocation is not supported by your browser</p>";
    return;
  }
  function success(position) {
    var latitude  = position.coords.latitude;
    var longitude = position.coords.longitude;
    const me = {
      lat: latitude,
      lng: longitude
    };
    map.goToLocation(me);
    output.innerHTML = "";
  }
  function error() {
    output.innerHTML = "<p>Unable to retrieve your location</p>";
  }
  output.innerHTML = "<p>Locating…</p>";
  navigator.geolocation.getCurrentPosition(success, error);
};
