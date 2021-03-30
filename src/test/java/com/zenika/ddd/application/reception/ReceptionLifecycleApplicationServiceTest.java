package com.zenika.ddd.application.reception;

import com.zenika.ddd.domain.reception.CreerReceptionService;
import com.zenika.ddd.domain.reception.IdExpedition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ReceptionLifecycleApplicationServiceTest {

    @Mock
    private CreerReceptionService creerReception;
    private ReceptionLifecycleApplicationService service;

    @BeforeEach
    void setUp() {
        service = new ReceptionLifecycleApplicationService(creerReception);
    }

    @Test
    @DisplayName("creer une réception la sauvegarde dans le repository")
    void creerReception() {
        var idExpedition = new IdExpedition("1234");

        service.creerReception(idExpedition);

        verify(creerReception).creerAPartirDe(idExpedition);
    }

}
