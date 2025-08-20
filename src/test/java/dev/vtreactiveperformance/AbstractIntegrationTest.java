package dev.vtreactiveperformance;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public abstract class AbstractIntegrationTest {
    static WireMockServer wireMockServer;

    @DynamicPropertySource
    static void overrideProperties(DynamicPropertyRegistry registry) {
        registry.add("external.api.base-url", wireMockServer::baseUrl);
    }

    @BeforeAll
    static void startWireMockServer() {
        wireMockServer = new WireMockServer(WireMockConfiguration.wireMockConfig().dynamicPort());
        wireMockServer.start();

        wireMockServer.stubFor(get(urlEqualTo("/dummy/resource"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("OK")
                        .withFixedDelay(200)));
    }

    @AfterAll
    static void stopWireMockServer() {
        wireMockServer.stop();
    }
}
