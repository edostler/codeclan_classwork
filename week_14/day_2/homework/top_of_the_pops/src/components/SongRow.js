import React from 'react';

const SongRow = (props) => {
  return (
    <div className='song-row'>
      <p>{props.song}</p>
    </div>
  );
};

export default SongRow;
