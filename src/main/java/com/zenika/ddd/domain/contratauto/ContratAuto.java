package com.zenika.ddd.domain.contratauto;

import java.util.Objects;

public class ContratAuto {

    private final ContratAutoId id;
    private Montant cotisationAnnuelle;
    private CouvertureAssurantielle couvertureAssurantielle;
    private Vehicule vehicule;
    private ConducteurPrincipal conducteurPrincipal;

    public ContratAuto(ContratAutoId id, CouvertureAssurantielle couvertureAssurantielle,
                       Vehicule vehicule, ConducteurPrincipal conducteurPrincipal) {
        this.id = id;
        this.couvertureAssurantielle = couvertureAssurantielle;
        this.vehicule = vehicule;
        this.conducteurPrincipal = conducteurPrincipal;
        this.cotisationAnnuelle = calculerCotisationAnnuelle();
    }

    private Montant calculerCotisationAnnuelle() {
        ClasseVehicule classeVehicule = this.vehicule.getClasse();

        return couvertureAssurantielle.getMontantForfaitaire()
                .appliqueCoefficient(classeVehicule)
                .appliqueCoefficient(conducteurPrincipal);
    }

    public CotisationContratAutoMiseAJour miseAJour(CouvertureAssurantielle couvertureAssurantielle, Vehicule vehicule,
                          ConducteurPrincipal conducteurPrincipal) {
        this.couvertureAssurantielle = couvertureAssurantielle;
        this.vehicule = vehicule;
        this.conducteurPrincipal = conducteurPrincipal;
        Montant ancienneCotisation = cotisationAnnuelle;
        this.cotisationAnnuelle = calculerCotisationAnnuelle();
        return new CotisationContratAutoMiseAJour(id, ancienneCotisation, cotisationAnnuelle);
    }

    public ContratAutoId getId() {
        return id;
    }

    public Montant getCotisationAnnuelle() {
        return cotisationAnnuelle;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContratAuto that = (ContratAuto) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
