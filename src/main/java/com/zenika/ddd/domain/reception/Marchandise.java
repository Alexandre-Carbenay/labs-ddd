package com.zenika.ddd.domain.reception;

import java.util.Objects;

public class Marchandise {
    private final Sku sku;
    private final int quantite;

    public Marchandise(Sku sku, int quantite) {
        this.sku = sku;
        this.quantite = quantite;
    }
    
    public Sku getSKU() {
    	return this.sku;
    }

	public boolean avecMemeSku(Sku sku2) {
		return sku.equals(sku2);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marchandise that = (Marchandise) o;
        return quantite == that.quantite && Objects.equals(sku, that.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku, quantite);
    }
}
