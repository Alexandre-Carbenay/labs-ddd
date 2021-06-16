package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

import java.util.List;

public class Commande {

    private List<LigneDeCommande> lignesDeCommande;

    public Commande(List<LigneDeCommande> lignesDeCommande) {

        this.lignesDeCommande = List.copyOf(lignesDeCommande);
    }

    public LigneDeCommande getLigneDeCommandePourLadresse(AdresseDeStockage adresse) {
        return lignesDeCommande.stream()
                .filter(ligneDeCommande -> ligneDeCommande.getProduitId().equals(adresse.getProduitId())).findFirst().get();
    }

    public List<LigneDeCommande> getLignesDeCommande() {
        return lignesDeCommande;
    }

}
