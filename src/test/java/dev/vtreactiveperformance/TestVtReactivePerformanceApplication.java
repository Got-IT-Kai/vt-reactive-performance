package dev.vtreactiveperformance;

import org.springframework.boot.SpringApplication;

public class TestVtReactivePerformanceApplication {

    public static void main(String[] args) {
        SpringApplication.from(VtReactivePerformanceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
