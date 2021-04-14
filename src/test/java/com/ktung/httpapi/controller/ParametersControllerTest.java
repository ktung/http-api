package com.ktung.httpapi.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ParametersController.class)
public class ParametersControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getPathReturns404() throws Exception {
    mvc.perform(get("/path"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(""));
  }

  @Test
  public void getPathReturns200() throws Exception {
    mvc.perform(get("/path/marie"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string("marie"));
  }

  @Test
  public void getParamReturnsDefault() throws Exception {
    mvc.perform(get("/param"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello, World!"));
  }

  @Test
  public void getParamReturns200() throws Exception {
    mvc.perform(get("/param")
        .param("name", "Julie"))
        .andExpect(status().isOk())
        .andExpect(content().string("Hello, Julie!"));
  }

  @Test
  public void getHeaderReturns400() throws Exception {
    mvc.perform(get("/header"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(""));
  }

  @Test
  public void getHeaderReturns200() throws Exception {
    mvc.perform(get("/header")
        .header("x-transaction-id", "MTIxMgo="))
        .andExpect(status().is2xxSuccessful())
        .andExpect(content().string("TransactionID : MTIxMgo="));
  }
}
