package dev.vtreactiveperformance.vt;

import dev.vtreactiveperformance.vt.s1.VirtualThreadExternalApiCallService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vt")
@RequiredArgsConstructor
public class VirtualThreadController {

    private final VirtualThreadExternalApiCallService vtExternalApiCallService;

    @GetMapping("/s1/call")
    public String callExternalApi() {
        return vtExternalApiCallService.callExternalApi();
    }

}
