package com.zenika.ddd.exemples.transfertbancaire;

public class Solde {

    private final float valeur;

    public Solde(float valeur) {
        if (valeur < 0) {
            throw new IllegalStateException();
        }
        this.valeur = valeur;
    }

    public boolean estSuperieur(float montantADebiter) {
    }

    public Solde moins(float montantADebiter) {
        return new Solde(valeur - montantADebiter);
    }

}
