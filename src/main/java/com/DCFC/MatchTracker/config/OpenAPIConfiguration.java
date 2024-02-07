package com.DCFC.MatchTracker.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {

    @Bean
    public OpenAPI defineOpenApi() {
        Server server1 = new Server();
        server1.setUrl("http://localhost:8080");
        server1.setDescription("Development");

        Server server2 = new Server();
        server2.setUrl("https://derby-api.azurewebsites.net/");
        server2.setDescription("Production");

        Contact myContact = new Contact();
        myContact.setName("Harry Redman");
        myContact.setEmail("harryredman.dev@gmail.com");

        Info information = new Info()
                .title("Derby County API")
                .version("1.0")
                .description("This API exposes endpoints to retrieve all past and present Derby County match data and upcoming fixtures")
                .contact(myContact);
        return new OpenAPI().info(information).servers(List.of(server2));
    }
}
