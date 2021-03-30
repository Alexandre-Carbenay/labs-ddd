package com.zenika.ddd.api.reception;

import com.zenika.ddd.application.reception.ReceptionLifecycleApplicationService;
import com.zenika.ddd.domain.reception.IdExpedition;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class ReceptionApiTest {

    @MockBean
    ReceptionLifecycleApplicationService service;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void creer_une_reception() throws Exception {
        mockMvc.perform(
                post("/reception")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"expedition\" : \"1234\"}"))
                .andExpect(status().isCreated());

        verify(service).creerReception(new IdExpedition("1234"));
    }
}