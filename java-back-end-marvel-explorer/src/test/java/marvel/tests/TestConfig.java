package marvel.tests;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import marvel.controller.CharacterController;
import marvel.service.ExplorerService;

@Configuration
public class TestConfig {
	
	@Bean
    public CharacterController creditCardController() {
        return new CharacterController();
    }

	@Bean
    public ExplorerService creditCardService() {
        return new ExplorerService();
    }
	
}
