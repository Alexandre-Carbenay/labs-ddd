package com.zenika.ddd.domain.commande;

import com.zenika.ddd.domain.article.Fournison;
import com.zenika.ddd.domain.article.Quantite;
import com.zenika.ddd.domain.article.StockGateway;
import com.zenika.ddd.domain.colis.Colis;
import com.zenika.ddd.domain.colis.ColisId;
import com.zenika.ddd.domain.colis.LigneDeColis;
import com.zenika.ddd.domain.colis.livraison.Livraison;
import com.zenika.ddd.domain.colis.livraison.LivraisonGateway;

import java.util.ArrayList;
import java.util.List;

public class PrevoirLivraisonDeLaCommande {

    private StockGateway stock;
    private LivraisonGateway livraisons;

    public void prevoirLivraisonDeLaCommande(Commande commande) {
        List<LigneDeColis> lignesDeColis = new ArrayList<>();
        for (LigneDeCommande ligneDeCommande : commande.getLignesDeCommande()) {
            List<Fournison> fournisons = stock.calculerFournisonsPour(ligneDeCommande);



            Quantite quantiteDisponible = stock.quantiteDisponiblePour(ligneDeCommande.getArticle());
            if (ligneDeCommande.aUneQuantiteSuffisante(quantiteDisponible)) {
                lignesDeColis.add(ligneDeCommande.prevoirLigneDeColis())
            }
        }
        Colis colis = new Colis(ColisId.generer(), lignesDeColis);
        Livraison livraison = livraisons.prevoirLivraisonPourUnColis(colis, commande.getGaragiste(), commande.getModeDeLivraison());
        colis.prevoirLivraisonDuColis(livraison);
    }

}
