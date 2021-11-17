package com.zenika.ddd.domain.article;

public class Quantite {

    private final int value;

    public Quantite(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException("Une quantite ne peut pas être négative");
        }
        this.value = value;
    }

    public boolean estSuffisante(Quantite quantite) {
        return value >= quantite.value;
    }

    public boolean nestPasSuffisante(Quantite quantite) {
        return value < quantite.value;
    }

    public boolean nonNulle() {
        return value > 0;
    }
}
