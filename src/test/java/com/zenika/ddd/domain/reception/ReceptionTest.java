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
        var entete = new EnteteAvisExpedition(new IdExpedition("avisExpe1"));
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
    @DisplayName("un avis d'expedition n'est pas valide sans ligne")
    void avisExpeditionNonValideSansLigne() {
        var entete = new EnteteAvisExpedition(new IdExpedition("avisExpe1"));
        assertThrows(IllegalArgumentException.class, () -> new AvisExpedition(entete, Collections.emptyList()));
    }

    @Test
    @DisplayName("Le SKU saisi ne correspond pas � la ligne")
    void skuLigneNonCorrespondant() {

        var entete = new EnteteAvisExpedition(new IdExpedition("avisExpe1"));
        var sku = new Sku("1234");
        var lignes = List.of(new Marchandise(sku, 1));
        var avisExpedition = new AvisExpedition(entete, lignes);

        var sku2 = new Sku("2163");
        var marchandise = new Marchandise(sku2, 1);

        var reception = new Reception(new ReceptionId(1), avisExpedition);

        assertThrows(MarchandiseInconnue.class, () -> reception.ajouterLigne(marchandise));

    }


    @Test
    @DisplayName("l'avis d'exp�dition ne contient pas de ligne pour un Sku donn�")
    void avisExpeditionSkuNonValide() {

        var entete = new EnteteAvisExpedition(new IdExpedition("avisExpe1"));
        var sku = new Sku("12345");
        var lignes = List.of(new Marchandise(sku, 1));
        var avisExpedition = new AvisExpedition(entete, lignes);

        var sku2 = new Sku("123456");
        var marchandise = new Marchandise(sku2, 1);

        assertThat(avisExpedition.contientLigne(marchandise)).isFalse();

    }

    @Test
    @DisplayName("Le SKU saisi  correspond  à la ligne")
    void skuLigneCorrespondant() {
        String sku_value = "1234";
        var entete = new EnteteAvisExpedition(new IdExpedition("avisExpe1"));
        var sku = new Sku(sku_value);
        var lignes = List.of(new Marchandise(sku, 1));
        var avisExpedition = new AvisExpedition(entete, lignes);

        var sku2 = new Sku(sku_value);
        var reception = new Reception(new ReceptionId(1), avisExpedition);
        var marchendiseAjouter = new Marchandise(sku2, 1);

        reception.ajouterLigne(marchendiseAjouter);

        assertThat(reception.getLignesReception()).contains(marchendiseAjouter);

    }

    @Test
    @DisplayName("cloturer Une Ligne avec une marchendise manquant")
    void cloturerUneLigne() {
        var entete = new EnteteAvisExpedition(new IdExpedition("avisExpe1"));
        var sku = new Sku("1234");
        var lignes = List.of(new Marchandise(sku, 1));
        var avisExpedition = new AvisExpedition(entete, lignes);

        var reception = new Reception(new ReceptionId(1), avisExpedition);

        assertThrows(EcartEnReception.class, () -> reception.cloture());
    }

    @Test
    @DisplayName("cloturer Une Ligne ")
    void cloturerUneLigneAvecSucces() {
        var entete = new EnteteAvisExpedition(new IdExpedition("avisExpe1"));
        var sku = new Sku("1234");
        var lignes = List.of(new Marchandise(sku, 1));
        var avisExpedition = new AvisExpedition(entete, lignes);

        var reception = new Reception(new ReceptionId(1), avisExpedition);

        var sku2 = new Sku("1234");
        var marchendiseAjouter = new Marchandise(sku2, 1);

        reception.ajouterLigne(marchendiseAjouter);

        reception.cloture();
        assertThat(reception.getStatut()).isEqualTo(StatutReception.CLOTURER);
    }
}
