package com.example.controller;

import com.example.config.CustomApplicationContext;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;


@WebAppConfiguration
@ContextConfiguration(classes = {CustomApplicationContext.class})
public class WelcomeControllerIT extends AbstractJUnit4SpringContextTests {

    @Autowired
    private WebApplicationContext ctx;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = webAppContextSetup(ctx).build();
    }


    @Test
    public void requestAuthenticateTokenIdEmpty() throws Exception {

       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/home/welcome")
                .contentType(MediaType.APPLICATION_JSON)).andReturn();
        String content = result.getResponse().getContentAsString();

    }
}
