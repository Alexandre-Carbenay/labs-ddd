package com.zenika.ddd.domain.contratauto;

import java.util.UUID;

public class ContratAuto {
    private Montant cotisationAnnuelle;

    private final CouvertureAssurantielle couvertureAssurantielle;
    private final Vehicule vehicule;
    private final ConducteurPrincipal conducteurPrincipal;
    private final String id;

    public ContratAuto(CouvertureAssurantielle couvertureAssurantielle, Vehicule vehicule,
                       ConducteurPrincipal conducteurPrincipal) {
        this.id = "1";
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

    public String getId() {
        return id;
    }

}
