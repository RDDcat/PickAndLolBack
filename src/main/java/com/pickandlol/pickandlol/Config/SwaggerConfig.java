package com.pickandlol.pickandlol.Config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig{

    private static final String SERVICE_NAME = "Pick And LOL Project";
    private static final String version = "v1.0.0";
    private static final String API_DESCRIPTION = "Pick And LOL Backend API";
    private static final String server = "Pick And LOL Backend Server health check";
    private static final String github = "GitHub Reposiotry Link";
    private static final String githubUrl = "https://github.com/ShowNF/PickAndLolBack";
    private static final String API_URL = "https://pickandlolback.iwiwantit.com/health";

    @Bean
    public OpenAPI openAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title(SERVICE_NAME)
                        .description(API_DESCRIPTION)
                        .version(version)
                        .license(new License().name(server).url(API_URL)))
                .externalDocs(new ExternalDocumentation()
                        .description(github)
                        .url(githubUrl));
    }
}
