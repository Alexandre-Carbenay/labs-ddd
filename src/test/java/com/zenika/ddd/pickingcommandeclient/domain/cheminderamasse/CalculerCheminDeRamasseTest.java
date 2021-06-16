package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculerCheminDeRamasseTest {

    private static final ProduitId PRODUIT_ID = new ProduitId(1234);

    @Mock
    AdresseDeStockageGateway adresseDeStockageGateway;

    @Test
    void calculerCheminDeRamasseCommande1Produit() {
        Commande commande = new Commande(List.of(new LigneDeCommande(PRODUIT_ID, 1)));

        when(adresseDeStockageGateway.getAdresseDuProduit(PRODUIT_ID))
                .thenReturn(new AdresseDeStockage("A", 1, PRODUIT_ID));

        CalculerCheminDeRamasse calculerCheminDeRamasse = new CalculerCheminDeRamasse(adresseDeStockageGateway);
        List<CheminDeRamasse> cheminsDeRamasse = calculerCheminDeRamasse.invoquer(commande);

        assertThat(cheminsDeRamasse).hasSize(1);

        CheminDeRamasse cheminDeRamasse = cheminsDeRamasse.get(0);

        assertThat(cheminDeRamasse.getEtapes()).hasSize(1);

        Etape etape = cheminDeRamasse.getEtapes().get(0);
        assertThat(etape.getNumeroDetape()).isEqualTo(1);
        assertThat(etape.getLigneDeCommande()).isEqualTo(new LigneDeCommande(PRODUIT_ID, 1));
        assertThat(etape.getAdresse()).isEqualTo(new AdresseDeStockage("A", 1, PRODUIT_ID));
    }

}
