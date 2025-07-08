//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.arka.inventory_service.infraestructure.adapter.driver.reactive.catalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    public WebClientConfig() {
    }

    @Bean
    public WebClient catalogWebClient(WebClient.Builder builder) {
        return builder.baseUrl("http://localhost:8080").build();
    }
}
