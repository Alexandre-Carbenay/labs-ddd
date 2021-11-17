package com.zenika.ddd.exemples.transfertbancaire;

public class TransfertService {

    private CompteExterneGateway compteExterneGateway;

    public void transfererDeLArgentAUnCompteInterne(CompteBancaire a, CompteBancaire b, float montantATransferer) {
        a.debiter(montantATransferer);
        b.crediter(montantATransferer);
    }

    public void transfererDeLArgentAUnCompteExterne(CompteBancaire a, CompteExterneId b, float montantATransferer) {
        a.debiter(montantATransferer);
        compteExterneGateway.crediter(b, montantATransferer);
    }

}
