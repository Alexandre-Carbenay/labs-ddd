package com.zenika.ddd.domain.contratauto;

import java.util.UUID;

public class ContratAuto {
    private Montant cotisationAnnuelle;

    private CouvertureAssurantielle couvertureAssurantielle;
    private Vehicule vehicule;
    private ConducteurPrincipal conducteurPrincipal;
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

    public void miseAJour(CouvertureAssurantielle couvertureAssurantielle, Vehicule vehicule,
                ConducteurPrincipal conducteurPrincipal) {
        this.couvertureAssurantielle = couvertureAssurantielle;
        this.vehicule = vehicule;
        this.conducteurPrincipal = conducteurPrincipal;
        this.cotisationAnnuelle = calculerCotisationAnnuelle();
    }

    public Montant getCotisationAnnuelle() {
        return cotisationAnnuelle;
    }

    public String getId() {
        return id;
    }

    public CouvertureAssurantielle getCouvertureAssurantielle() {
        return couvertureAssurantielle;
    }

    public Vehicule getVehicule() {
        return vehicule;
    }

    public ConducteurPrincipal getConducteurPrincipal() {
        return conducteurPrincipal;
    }
}
