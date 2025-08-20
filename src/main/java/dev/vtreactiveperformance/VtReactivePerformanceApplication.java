package dev.vtreactiveperformance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class VtReactivePerformanceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VtReactivePerformanceApplication.class, args);
    }

}
