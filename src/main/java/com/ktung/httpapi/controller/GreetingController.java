package com.ktung.httpapi.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.ktung.httpapi.model.Greeting;
import com.ktung.httpapi.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

  @PostMapping("/greeting")
  public Greeting greetingUser(@RequestBody User user) {
    return new Greeting(counter.incrementAndGet(), String.format(template, user.getName()));
  }
}
