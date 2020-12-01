package com.zenika.ddd.domain.contratauto;

public class CouvertureAssurantielle {

    private String id;
    private Montant montantForfaitaire;

    public CouvertureAssurantielle(String id, Montant montantForfaitaire) {
        this.id = id;
        this.montantForfaitaire = montantForfaitaire;
    }

    public Montant getMontantForfaitaire() {
        return montantForfaitaire;
    }

    public String getId() {
        return id;
    }
}
