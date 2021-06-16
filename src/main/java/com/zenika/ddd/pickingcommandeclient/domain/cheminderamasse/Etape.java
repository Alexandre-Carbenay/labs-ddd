package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

public class Etape {

    private int numeroDetape;
    private LigneDeCommande ligneDeCommande;
    private AdresseDeStockage adresse;

    public Etape(int numeroDetape, Commande commande, AdresseDeStockage adresse) {
        this.numeroDetape = numeroDetape;
        this.ligneDeCommande = commande.getLigneDeCommandePourLadresse(adresse);
        this.adresse = adresse;
    }

    public int getNumeroDetape() {
        return numeroDetape;
    }

    public LigneDeCommande getLigneDeCommande() {
        return ligneDeCommande;
    }

    public AdresseDeStockage getAdresse() {
        return adresse;
    }
}
