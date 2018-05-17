import React, {Component} from "react";
import TerrierSelector from "../components/TerrierSelector";
import Terrier from "../components/Terrier";

class TerrierBox extends Component{

  constructor(props){
    super(props)
    this.handleTerrierSelected = this.handleTerrierSelected.bind(this);
    this.state = {
      terriers: [],
      currentTerrier: null,
      terrierImages: [],
      currentTerrierImage: null,
      randomNumber: null
    }
  }

  componentDidMount(){
    fetch("https://dog.ceo/api/breed/terrier/list")
      .then(response => response.json())
      .then(json => this.setState({terriers: json.message}));
  }

  handleTerrierSelected(index) {
    const selectedTerrier = this.state.terriers[index];
    this.setState({currentTerrier: selectedTerrier});
    fetch("https://dog.ceo/api/breed/terrier/"+selectedTerrier+"/images")
    .then(response => response.json())
    .then(json => this.setState({terrierImages: json.message}))
    .then(randomWords => this.setState({randomNumber: Math.floor(Math.random() * this.state.terrierImages.length)}))
    .then(thisWeirdThingMakesItWork => this.setState({currentTerrierImage: this.state.terrierImages[this.state.randomNumber]}))
  }

  render(){
    return(
      <React.Fragment>
        <h2>Terriers</h2>
      <TerrierSelector
        terriers={this.state.terriers}
        onTerrierSelected={this.handleTerrierSelected}
      />
      <Terrier
        terrier={this.state.currentTerrier}
        terrierImage={this.state.currentTerrierImage}
      />
    </React.Fragment>
    );
  }

}

export default TerrierBox;
