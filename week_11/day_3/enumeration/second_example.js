const tweetGetter = {
  getTweets: function(callback){
    // tech stuff that takes some time
  callback();
  },

  renderHeader: function(){
    // creates h1
  },

  render: function(){
    this.getTweets(function(){
      console.log(this);
    // this.renderHeader();
  }.bind(this));
  }
};

tweetGetter.render();
