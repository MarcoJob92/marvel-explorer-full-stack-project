package marvel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import marvel.model.MarvelCharacter;
import marvel.model.MarvelData;
import marvel.model.MarvelResponse;
import marvel.service.ExplorerService;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
public class CharacterController {
	
	@Autowired
	private ExplorerService explorerService;
	
	@GetMapping("/getCharacters")
	public MarvelData getAllCourses() {
		MarvelResponse response = explorerService.findAll(0, true);
		return response.getData();
	}
	
	@GetMapping("/getCharacters/{page}")
	public List<MarvelCharacter> getAllCourses(@PathVariable int page) {
		MarvelResponse response = explorerService.findAll(page - 1, false);
		return response.getCharacters();
	}
	
	@GetMapping("/getCharactersByName/{characterName}")
	public List<MarvelCharacter> getAllCourses(@PathVariable String characterName) {
		return explorerService.findCharactersByName(characterName);
	}
}