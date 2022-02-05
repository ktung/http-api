package com.ktung.httpapi.controller;

import com.ktung.httpapi.model.Country;
import com.ktung.httpapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CountryController {

  @Autowired
  private CountryRepository countryRepository;

  @GetMapping(value = "/country", produces = MediaType.APPLICATION_JSON_VALUE)
  public Iterable<Country> findAll() {
    return countryRepository.findAll();
  }

  @GetMapping(value = "/country/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Optional<Country> findById(@PathVariable("id") int id) {
    return countryRepository.findById(id);
  }

//  curl --location --request POST 'http://localhost:8080/country/create' \
//      --header 'Content-Type: application/json' \
//      --data-raw '{
//      "id": 1,
//      "name": "China"
//}'
  @PostMapping(value = "/country/create", produces = MediaType.APPLICATION_JSON_VALUE)
  public Country save(@RequestBody Country country) {
    return countryRepository.save(country);
  }

//  curl --location --request POST 'http://localhost:8080/country/1/delete'
  @PostMapping(value = "/country/{id}/delete", produces = MediaType.APPLICATION_JSON_VALUE)
  public void deleteById(@PathVariable("id") int id) {
    countryRepository.deleteById(id);
  }
}
