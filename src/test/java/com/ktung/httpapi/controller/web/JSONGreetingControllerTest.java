package com.ktung.httpapi.controller.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(JSONGreetingController.class)
public class JSONGreetingControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getJSONDefault() throws Exception {
    mvc.perform(get("/greeting"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
        .andExpect(content().json("{\"content\":\"Hello, World!\"}"));
  }

  @Test
  public void getJSONParam() throws Exception {
    mvc.perform(get("/greeting")
        .param("name", "Marie"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
        .andExpect(content().json("{\"content\":\"Hello, Marie!\"}"));
  }

  @Test
  public void postJSONNoBody() throws Exception {
    mvc.perform(post("/greeting"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(""));
  }

  @Test
  public void postJSONReturns200() throws Exception {
    mvc.perform(post("/greeting")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"name\": \"Marie\"}"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(header().string("Content-Type", MediaType.APPLICATION_JSON_VALUE))
        .andExpect(jsonPath("$.content", is("Hello, Marie!")));
  }
}
