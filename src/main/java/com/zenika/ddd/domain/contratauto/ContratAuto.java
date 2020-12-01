package com.zenika.ddd.domain.contratauto;

public class ContratAuto {

    private double cotisationAnnuelle;
    private final Vehicule vehicule;

    public ContratAuto(CouvertureAssurantielle couvertureAssurantielle, Vehicule vehicule) {
        this.vehicule = vehicule;
        this.cotisationAnnuelle = calculerCotisationAnnuelle(couvertureAssurantielle);
    }

    private double calculerCotisationAnnuelle(CouvertureAssurantielle couvertureAssurantielle) {
        double cotisationAnnuelle;

        ClasseVehicule classeVehicule = this.vehicule.getClasse();

        cotisationAnnuelle = couvertureAssurantielle.getMontantForfaitaire() * classeVehicule.getCoefficient();
        return cotisationAnnuelle;
    }

    public double getCotisationAnnuelle() {
        return cotisationAnnuelle;
    }

}
