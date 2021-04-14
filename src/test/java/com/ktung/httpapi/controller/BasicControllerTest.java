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
@WebMvcTest(BasicController.class)
public class BasicControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getBasicReturns200() throws Exception {
    mvc.perform(get("/basic"))
        .andExpect(status().isOk())
        .andExpect(content().string(""));
  }
}
