package dev.vtreactiveperformance.reactive.s1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ReactiveExternalApiCallService {
    private final WebClient webClient;
    public Mono<String> callExternalApi() {
        return null;
    }
}
