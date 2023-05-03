package com.eddielaio.shorturlsystem.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@SpringBootTest
@AutoConfigureMockMvc
class urlControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shortenUrl() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/shorten")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"url\":\"https://github.com/MaaAssistantArknights/MaaBackendCenter/blob/dev/src/main/java/plus/maa/backend/controller/CommentsAreaController.java\"\n" +
                        "}");
        mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(201));
    }
}