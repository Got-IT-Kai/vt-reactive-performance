package dev.vtreactiveperformance.vt.s1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@RequiredArgsConstructor
public class VirtualThreadExternalApiCallService {
    private final RestClient restClient;

    public String callExternalApi() {
        return restClient.get()
                .uri("/dummy/resource")
                .retrieve()
                .body(String.class);
    }
}
