package com.zenika.ddd.domain.reception;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.zenika.ddd.domain.reception.StatutReception.OUVERTE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CreerReceptionServiceTest {

    @Mock
    private AvisExpeditionGateway avisExpeditionGateway;
    @Mock
    private ReceptionRepository receptionRepository;
    @Captor
    private ArgumentCaptor<Reception> receptionCaptor;

    private CreerReceptionService service;

    @BeforeEach
    void setUp() {
        service = new CreerReceptionService(avisExpeditionGateway, receptionRepository);
    }

    @Test
    void creerAPartirDunAvisDexpedition() {
        var idExpedition = new IdExpedition("avisExpe1");
        var entete = new EnteteAvisExpedition(idExpedition);
        var sku = new Sku("1234");
        var lignes = List.of(new Marchandise(sku, 1));
        var avisExpedition = new AvisExpedition(entete, lignes);

        when(avisExpeditionGateway.recupererAvisExpedition(idExpedition)).thenReturn(avisExpedition);

        service.creerAPartirDe(idExpedition);

        verify(receptionRepository).save(receptionCaptor.capture());
        var actualReception = receptionCaptor.getValue();
        assertThat(actualReception.getAvisExpedition()).isEqualTo(avisExpedition);
        assertThat(actualReception.getStatut()).isEqualTo(OUVERTE);
        assertThat(actualReception.getLignesReception()).isEmpty();
    }

}
