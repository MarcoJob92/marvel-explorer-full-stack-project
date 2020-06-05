package marvel.service;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import marvel.constants.Constants;
import marvel.model.MarvelCharacter;
import marvel.model.MarvelResponse;


@Service
public class ExplorerService {
	
	int charactersTotal;
	Client client = ClientBuilder.newClient();
	WebTarget webTarget = client.target(Constants.URI)
								.path(Constants.PATH)
								.queryParam("ts", Constants.TS)
								.queryParam("apikey", Constants.API_KEY)
								.queryParam("hash", Constants.HASH)
								.queryParam("limit", Constants.LIMIT);
	
	
	public MarvelResponse findAll(int page, boolean toFetch) {
		WebTarget target = webTarget.queryParam("offset", page * Constants.LIMIT);
	    Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
	    MarvelResponse response = invocationBuilder.get(MarvelResponse.class);
	    if (toFetch)
	    	charactersTotal = response.getData().getTotal();
	    return response;
	}

	public List<MarvelCharacter> findCharactersByName(String characterName) {
		WebTarget target = webTarget.queryParam("nameStartsWith", characterName);
	    Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON);
	    MarvelResponse response = invocationBuilder.get(MarvelResponse.class);
	    return response.getCharacters();
	}
	
	public int getCharactersTotal() {
        return charactersTotal;
    }

}
