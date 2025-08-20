package dev.vtreactiveperformance.reactive;

import dev.vtreactiveperformance.reactive.s1.ReactiveExternalApiCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reactive")
@RequiredArgsConstructor
public class ReactiveController {
    private final ReactiveExternalApiCallService reactiveExternalApiCallService;

    @GetMapping("/s1/call")
    public Mono<String> callExternalApi() {
        return reactiveExternalApiCallService.callExternalApi();
    }

}
