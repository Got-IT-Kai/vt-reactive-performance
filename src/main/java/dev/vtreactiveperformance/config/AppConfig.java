package dev.vtreactiveperformance.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public WebClient webClient(WebClient.Builder builder, ExternalApiProp externalApiProp) {
        return builder.baseUrl(externalApiProp.baseUrl()).build();
    }
}
