package dev.vtreactiveperformance.reactive;

import dev.vtreactiveperformance.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        properties = {
                "spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration," +
                        "org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration"
        })
class ReactiveControllerTest extends AbstractIntegrationTest {

    @Autowired
    private WebTestClient webClient;

    @Test
    void reactiveEndpointShouldReturnExpectedResponse() {
        webClient.get()
                .uri("/reactive/s1/call")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .value(response -> assertEquals("OK", response));
    }

}