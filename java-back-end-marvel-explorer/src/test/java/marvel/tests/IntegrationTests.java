package marvel.tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import marvel.constants.Constants;
import marvel.controller.CharacterController;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})

public class IntegrationTests {
	
	@Autowired
	CharacterController controller;

    MockMvc mockMvc;

    @Before
    public void init() {
        mockMvc = standaloneSetup(controller).build();
    }
    
    
    @Test
    public void testGetCharacters() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getCharacters"))
		        .andExpect(status().isOk())
		        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		        .andExpect(MockMvcResultMatchers.jsonPath("$.limit").value(Constants.LIMIT))
		        .andExpect(MockMvcResultMatchers.jsonPath("$.count").value(Constants.LIMIT))
		        .andExpect(MockMvcResultMatchers.jsonPath("$.results").isNotEmpty());
    }
    
    @Test
    public void getCharactersByName() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/getCharactersByName/iron man"))
		        .andExpect(status().isOk())
		        .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
		        .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Iron Man"));
    }
	
}
