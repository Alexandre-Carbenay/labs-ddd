package com.zenika.ddd.exemples.transfertbancaire;

public class MontantDebite {

    private final int compteBancaireId;
    private final float montantDebite;
    private final Solde nouveauSolde;

    public MontantDebite(int compteBancaireId, float montantDebite, Solde nouveauSolde) {
        this.compteBancaireId = compteBancaireId;
        this.montantDebite = montantDebite;
        this.nouveauSolde = nouveauSolde;
    }
}
