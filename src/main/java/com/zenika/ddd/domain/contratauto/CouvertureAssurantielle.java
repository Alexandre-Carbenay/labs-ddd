package com.zenika.ddd.domain.contratauto;

public class CouvertureAssurantielle {

    private String id;
    private double tarif;

    public CouvertureAssurantielle(String id, double tarif) {
        this.id = id;
        this.tarif = tarif;
    }

    public double getTarif() {
        return tarif;
    }

}
