package com.zenika.ddd.domain.contratauto;

public class ContratAuto {

    private double cotisationAnnuelle;

    public ContratAuto(CouvertureAssurantielle couvertureAssurantielle) {
        this.cotisationAnnuelle = couvertureAssurantielle.getTarif();
    }

    public double getCotisationAnnuelle() {
        return cotisationAnnuelle;
    }

}
