package com.usermanagement.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support
        .SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SampleWebJspApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SampleWebJspApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder
                                                         application) {
        return application.sources(SampleWebJspApplication.class);
    }
}
