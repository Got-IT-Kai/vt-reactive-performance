package dev.vtreactiveperformance.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "external.api")
public record ExternalApiProp(String baseUrl) {
}
