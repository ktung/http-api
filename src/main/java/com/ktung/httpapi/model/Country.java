package com.ktung.httpapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "countries")
@Entity
public class Country {
  @Id
  @GeneratedValue
  public int id;

  public String name;
}
