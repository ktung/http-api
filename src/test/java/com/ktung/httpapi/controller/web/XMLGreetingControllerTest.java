package com.ktung.httpapi.controller.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(XMLGreetingController.class)
public class XMLGreetingControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void getXMLDefault() throws Exception {
    mvc.perform(get("/xml/greeting"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(header().string("Content-Type", MediaType.APPLICATION_XML_VALUE))
        .andExpect(xpath("/XMLGreeting/content").string("Hello, World!"));
  }

  @Test
  public void getXMLParam() throws Exception {
    mvc.perform(get("/xml/greeting")
        .param("name", "Marie"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(header().string("Content-Type", MediaType.APPLICATION_XML_VALUE))
        .andExpect(xpath("/XMLGreeting/content").string("Hello, Marie!"));
  }

  @Test
  public void postXMLNoBody() throws Exception {
    mvc.perform(post("/xml/greeting"))
        .andExpect(status().is4xxClientError())
        .andExpect(content().string(""));
  }

  @Test
  public void postXMLReturns200() throws Exception {
    mvc.perform(post("/xml/greeting")
        .contentType(MediaType.APPLICATION_XML_VALUE)
        .content("<User><name>Marie</name></User>"))
        .andExpect(status().is2xxSuccessful())
        .andExpect(header().string("Content-Type", MediaType.APPLICATION_XML_VALUE))
        .andExpect(xpath("/XMLGreeting/content").string("Hello, Marie!"));
  }
}
