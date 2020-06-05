import React, { useState, useEffect } from "react";
import $ from 'jquery-ajax';
import MarvelExplorer from './components/MarvelExplorer.jsx';
import CharacterPage from './components/CharacterPage.jsx';
import 'bootstrap/dist/css/bootstrap.css';
import './App.css';

const urlGetCharacters = "http://127.0.0.1:8080/getCharacters";

function App() {
  const [characterList, setCharacterList] = useState([]);
  const [character, setCharacter] = useState(null);
  const [currentPage, setCurrentPage] = useState(1);
  const [nOfPages, setNOfPages] = useState(0);
  const [mainView, setMainView] = useState(true);
  const [loading, setLoading] = useState(true);
  const [searching, setSearching] = useState(false);
  const [searchingValue, setSearchingValue] = useState("");

  useEffect(() => {
    $.get(urlGetCharacters, response => {
      setCharacterList(response.results); 
      setLoading(false);
      setNOfPages( getPagesNum(response) );
    });
  }, []);

  const getPagesNum = obj => {
  	return Math.ceil(obj.total / obj.limit);
  }

  const showCharacter = character => {
    setCharacter(character);
    setMainView(false);
  }

  const handlePageChange = (event, pageNum) => {
    setLoading(true);
    $.get(`${urlGetCharacters}/${pageNum}`, response => {
      setCharacterList(response);
      setCurrentPage(pageNum);
      setLoading(false);
    });
  };

  const search = event => {
  	const value = event.target.value.trim();
  	setSearchingValue(value);
  	const isSearching = value !== "" ? true : false;
  	setSearching(isSearching);
    const url = isSearching ? `${urlGetCharacters}ByName/${value}` : `${urlGetCharacters}/${currentPage}`;
    setLoading(true);
    $.get(url, response => {
      setCharacterList(response);
      setLoading(false);
    });
  };

  return (
    <main className="App container">
    	{mainView ?
	    	<MarvelExplorer loading={loading}
	                        searching={searching}
	                        characterList={characterList}
	                        page={currentPage}
	                        nOfPages={nOfPages}
	                        search={search}
	                        showCharacter={showCharacter}
	                        handlePageChange={handlePageChange}
	                        searchingValue={searchingValue} />
	    :
	        <CharacterPage character={character}
	        			   characterOnClick={() => setMainView(true)} />
	    }
    </main>
  );
}

export default App;
