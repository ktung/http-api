package com.ktung.httpapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/basic")
public class BasicController {

  @GetMapping
  public ResponseEntity<String> hello() {
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
