package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

import java.util.Objects;

public class ProduitId {
    private final int id;

    public ProduitId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduitId produitId = (ProduitId) o;
        return id == produitId.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
