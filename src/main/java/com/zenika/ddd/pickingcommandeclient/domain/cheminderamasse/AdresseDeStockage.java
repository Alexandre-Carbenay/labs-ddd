package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

import java.util.Objects;

public class AdresseDeStockage {

    private final String allee;
    private final int numero;
    private final ProduitId produitId;

    public AdresseDeStockage(String allee, int numero, ProduitId produitId) {
        this.allee = allee;
        this.numero = numero;
        this.produitId = produitId;
    }

    public ProduitId getProduitId() {
        return produitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AdresseDeStockage that = (AdresseDeStockage) o;
        return numero == that.numero && Objects.equals(allee, that.allee) && Objects.equals(produitId, that.produitId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allee, numero, produitId);
    }
}
