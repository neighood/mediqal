package com.mediqal.community.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
public class UserControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void signup() {
    }

    @Test
    void testSignup() {
    }

    @Test
    void signin() {
    }

    @Test
    void testSignin() {
    }

    @Test
    void article() {
    }

    @Test
    void email() {
    }

    @Test
    void info() {
    }

    @Test
    void leave() {
    }

    @Test
    void notification() {
    }

    @Test
    void password() {
    }

    @Test
    void reply() {
    }

    @Test
    void upcoming() {
    }
}