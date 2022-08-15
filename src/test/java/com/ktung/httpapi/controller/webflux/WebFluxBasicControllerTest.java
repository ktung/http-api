package com.ktung.httpapi.controller.webflux;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@ExtendWith(SpringExtension.class)
@WebFluxTest(WebFluxBasicController.class)
public class WebFluxBasicControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getBasicReturns200() throws Exception {
        webTestClient.get()
                .uri("/webflux/basic")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBody()
                .isEmpty();
    }
}
