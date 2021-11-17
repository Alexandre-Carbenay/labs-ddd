package com.zenika.ddd.exemples.transfertbancaire;

public class CompteBancaire {

    private Id id;
    private Solde solde;

    public Id getId() {
        return id;
    }

    public Solde getSolde() {
        return solde;
    }

    public MontantDebite debiter(float montantADebiter) {
        if (solde.estSuperieur(montantADebiter)) {
            throw new MontantInsuffisant();
        }
        solde = solde.moins(montantADebiter);
        return new MontantDebite(id, montantADebiter, solde);
    }

    public void crediter(float montantACrediter) {
        solde = solde + montantACrediter;
    }

    public static class Id {
        private int id;
    }

}
