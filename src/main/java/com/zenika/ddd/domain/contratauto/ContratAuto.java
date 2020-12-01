package com.zenika.ddd.domain.contratauto;

public class ContratAuto {
    private Montant cotisationAnnuelle;

    private final CouvertureAssurantielle couvertureAssurantielle;
    private final Vehicule vehicule;
    private final ConducteurPrincipal conducteurPrincipal;

    public ContratAuto(CouvertureAssurantielle couvertureAssurantielle, Vehicule vehicule,
                       ConducteurPrincipal conducteurPrincipal) {
        this.couvertureAssurantielle = couvertureAssurantielle;
        this.vehicule = vehicule;
        this.conducteurPrincipal = conducteurPrincipal;
        this.cotisationAnnuelle = calculerCotisationAnnuelle();
    }

    public Montant calculerCotisationAnnuelle() {
        ClasseVehicule classeVehicule = this.vehicule.getClasse();

        return couvertureAssurantielle.getMontantForfaitaire()
                .appliqueCoefficient(classeVehicule)
                .appliqueCoefficient(conducteurPrincipal);
    }

    public Montant getCotisationAnnuelle() {
        return cotisationAnnuelle;
    }
}
