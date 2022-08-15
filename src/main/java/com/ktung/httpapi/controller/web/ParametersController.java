package com.ktung.httpapi.controller.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParametersController {

  @GetMapping(path = "/path/{name}")
  public ResponseEntity<String> path(@PathVariable(value = "name") String name) {
    return new ResponseEntity<>(name, HttpStatus.OK);
  }

  @GetMapping(path = "/param")
  public ResponseEntity<String> param(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new ResponseEntity<>(String.format("Hello, %s!", name), HttpStatus.OK);
  }

  @GetMapping(path = "/header")
  public ResponseEntity<String> header(@RequestHeader(value = "x-transaction-id") String transactionId) {
    return new ResponseEntity<>(String.format("TransactionID : %s", transactionId), HttpStatus.OK);
  }
}
