package com.zenika.ddd.domain.reception;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ReceptionTest {

    @Test
    @DisplayName("doit être initialisée à partir de l'avis d'expédition")
    void intialiseAPartirDeLAvisDexpe() {
        var entete = new EnteteAvisExpedition("avisExpe1");
        var sku = new Sku("1234");
        var lignes = List.of(new Marchandise(sku, 1));
        var avisExpedition = new AvisExpedition(entete, lignes);

        var reception = new Reception(new ReceptionId(1), avisExpedition);

        assertThat(reception.getAvisExpedition()).isEqualTo(avisExpedition);
        assertThat(reception.getStatut()).isEqualTo(StatutReception.OUVERTE);
    }

    @Test
    @DisplayName("un avis d'expédition n'est pas valide sans entete")
    void avisExpeditionNonValideSansEntete() {
        var sku = new Sku("1234");
        var lignes = List.of(new Marchandise(sku, 1));
        assertThrows(IllegalArgumentException.class, () -> new AvisExpedition(null, lignes));
    }

    @Test
    @DisplayName("un avis d'expédition n'est pas valide sans ligne")
    void avisExpeditionNonValideSansLigne() {
        var entete = new EnteteAvisExpedition("avisExpe1");
        assertThrows(IllegalArgumentException.class, () -> new AvisExpedition(entete, Collections.emptyList()));
    }

}
