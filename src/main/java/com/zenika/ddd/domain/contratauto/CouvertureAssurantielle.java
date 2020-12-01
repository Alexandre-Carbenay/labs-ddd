package com.zenika.ddd.domain.contratauto;

public class CouvertureAssurantielle {

    private CouvertureAssurantielleId id;
    private Montant montantForfaitaire;

    public CouvertureAssurantielle(CouvertureAssurantielleId id, Montant montantForfaitaire) {
        this.id = id;
        this.montantForfaitaire = montantForfaitaire;
    }

    public Montant getMontantForfaitaire() {
        return montantForfaitaire;
    }

    public CouvertureAssurantielleId getId() {
        return id;
    }
}
