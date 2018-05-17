import React from 'react';
import SongRow from './SongRow';
import './SongTable.css';


const SongTable = (props) => {
  const songNodes = props.songs.map((song, index) => {
    return (
      <React.Fragment>
      <article>
        <li className="chart-position" key={index}>
          <SongRow song={index + 1} key={index}/>
        </li>
        <li className="chart-details" key={index}>
          <SongRow song={song.title.label} key={index}/>
        </li>
        <img src={song["im:image"][2].label} alt={song.title.label} key={index}/>
      </article>
    </React.Fragment>
    );
  });

  return(
    <div className='song-table'>
      <ul>
        {songNodes}
      </ul>
    </div>
  );
};

export default SongTable;
