package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

import java.util.Objects;

public class LigneDeCommande {

    private final ProduitId produitId;
    private final int quantite;

    public LigneDeCommande(ProduitId produitId, int quantite) {
        this.produitId = produitId;
        this.quantite = quantite;
    }

    public ProduitId getProduitId() {
        return produitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LigneDeCommande that = (LigneDeCommande) o;
        return quantite == that.quantite && Objects.equals(produitId, that.produitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(produitId, quantite);
    }
}
