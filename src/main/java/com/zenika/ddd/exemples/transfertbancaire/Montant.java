package com.zenika.ddd.exemples.transfertbancaire;

public class Montant {

    private float valeur;

    public Montant(float valeur) {
        this.valeur = valeur;
    }

    public Montant additionne(Montant aAdditionner) {
        return new Montant(valeur + aAdditionner.valeur);
    }

}
