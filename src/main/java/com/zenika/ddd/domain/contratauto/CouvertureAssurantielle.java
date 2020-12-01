package com.zenika.ddd.domain.contratauto;

public class CouvertureAssurantielle {

    private String id;
    private double montantForfaitaire;

    public CouvertureAssurantielle(String id, double montantForfaitaire) {
        this.id = id;
        this.montantForfaitaire = montantForfaitaire;
    }

    public double getMontantForfaitaire() {
        return montantForfaitaire;
    }

}
