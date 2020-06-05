import React from "react";

const CharacterPage = props => {
  const character = props.character;
  const image = character.thumbnail;
  return(
    <section>
      <button type="button" 
              class="btn btn-outline-secondary go-back-btn"
              onClick={props.characterOnClick}>
        Go Back
      </button>
      <h1 className="character-name">{character.name}</h1>
      <div className="">
        <p>{character.description}</p>
      </div>
      <div className="row">
        <img className="col-sm" 
             src={`${image.path}/portrait_uncanny.${image.extension}`} />
        <div className="col-sm">
           <CharacterSection list={character.stories.items}
                             text={"Stories"} />
           <CharacterSection list={character.events.items}
                             text={"Events"} />
           <CharacterSection list={character.series.items}
                             text={"Series"} />
        </div>
      </div>
    </section>
  )
}

const CharacterSection = props => {
  return (
     <div className="section">
       <h6>{props.text}:</h6>
       {
        props.list.length > 0 ?
          props.list.map( s => <p>{s.name}</p> ) 
        :
          <div> Trere're no {props.text} for this character </div>
       }
     </div>
  )
}

export default CharacterPage;