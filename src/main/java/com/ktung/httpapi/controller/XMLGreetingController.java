package com.ktung.httpapi.controller;

import com.ktung.httpapi.model.XMLGreeting;
import com.ktung.httpapi.model.XMLUser;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping(path = "/xml")
public class XMLGreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping(value = "/greeting", produces = MediaType.APPLICATION_XML_VALUE)
  public XMLGreeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new XMLGreeting(counter.incrementAndGet(), String.format(template, name));
  }

  @PostMapping(value = "/greeting", produces = MediaType.APPLICATION_XML_VALUE)
  public XMLGreeting greetingUser(@RequestBody XMLUser user) {
    return new XMLGreeting(counter.incrementAndGet(), String.format(template, user.getName()));
  }
}
