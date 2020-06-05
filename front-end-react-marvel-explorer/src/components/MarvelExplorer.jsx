import React from "react";
import Pagination from '@material-ui/lab/Pagination';

const MarvelExplorer = props => {
  return (
    <section className={props.loading ? 'loadingClass' : ''}>
      <h1 className="app-title"> Marvel explorer </h1>
      <header className="input-group mb-3 col-md-4 offset-md-8">
        <input type="search" 
               className="form-control" 
               placeholder="Search..."
               onChange={props.search}
               value={props.searchingValue}
               disabled={props.loading} />
        <span className="glyphicon glyphicon-remove-circle"></span>
      </header>

      <Table characterList={props.characterList}
             showCharacter={props.showCharacter} />

      {!props.searching && 
        <footer>
          <label>Page: {props.page}</label>
          <Pagination count={props.nOfPages} page={props.page} onChange={props.handlePageChange} />
        </footer>
      }
    </section>
  )
}

const Table = props => {
  return (
    <table className="table table-hover">
      <thead className="thead-dark">
        <tr>
          <th scope="col">Name</th>
          <th scope="col">Last modified date</th> 
        </tr>
      </thead>
      <tbody>
        {
          props.characterList.map(character => 
            <tr key={character.id} onClick={() => props.showCharacter(character)}>
              <td> {character.name} </td>
              <td> {character.modified} </td>
            </tr>
        )}
      </tbody>
    </table>
  )
}

export default MarvelExplorer;