package com.ktung.httpapi.controller.webflux;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping(path = "/webflux/basic")
public class WebFluxBasicController {

  @GetMapping
  public ResponseEntity<Mono<String>> hello() {
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
