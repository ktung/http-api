package com.ktung.httpapi.controller.webflux;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@WebFluxTest(WebFluxJSONGreetingController.class)
public class WebFluxJSONGreetingControllerTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void getJSONDefault() throws Exception {
        webTestClient.get()
                .uri("/webflux/greeting")
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .expectBody()
                .json("{\"content\":\"Hello, World!\"}");
    }

    @Test
    public void getJSONParam() throws Exception {
        webTestClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/webflux/greeting")
                        .queryParam("name", "Marie")
                        .build())
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .expectBody()
                .json("{\"content\":\"Hello, Marie!\"}");
    }

    @Test
    public void postJSONNoBody() throws Exception {
        webTestClient.post()
                .uri("/webflux/greeting")
                .exchange()
                .expectStatus()
                .is4xxClientError();
    }

    @Test
    public void postJSONReturns200() throws Exception {
        webTestClient.post()
                .uri("/webflux/greeting")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue("{\"name\": \"Marie\"}"))
                .exchange()
                .expectStatus()
                .isOk()
                .expectHeader()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .expectBody()
                .jsonPath("$.content", is("Hello, Marie!"));
    }
}
