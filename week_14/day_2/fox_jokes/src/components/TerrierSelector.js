import React from "react"

const TerrierSelector = (props) => {
  const options = props.terriers.map((terrier, index) => {
    return <option value={index} key={index} >{terrier}</option>
  })
  const handleChange = (event) => {
    let index = event.target.value;
    props.onTerrierSelected(index);
  }
  return (
    <select
      onChange={handleChange}
      defaultValue="default"
      >
        <option value="default" disabled>Choose A Terrier</option>
        {options}
      </select>
  )

}

export default TerrierSelector;
