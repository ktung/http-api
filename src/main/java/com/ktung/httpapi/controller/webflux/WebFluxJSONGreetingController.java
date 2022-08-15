package com.ktung.httpapi.controller.webflux;

import com.ktung.httpapi.model.Greeting;
import com.ktung.httpapi.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/webflux/greeting")
public class WebFluxJSONGreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping()
    public Mono<Greeting> greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return Mono.just(new Greeting(counter.incrementAndGet(), String.format(template, name)));
    }

    @PostMapping()
    public Mono<Greeting> greetingUser(@RequestBody User user) {
        return Mono.just(new Greeting(counter.incrementAndGet(), String.format(template, user.getName())));
    }
}
