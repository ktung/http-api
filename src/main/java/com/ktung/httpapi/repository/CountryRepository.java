package com.ktung.httpapi.repository;

import com.ktung.httpapi.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
}
