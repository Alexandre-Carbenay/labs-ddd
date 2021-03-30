package com.zenika.ddd.domain.reception;

public class Marchandise {
    private final Sku sku;
    private final int quantite;

    public Marchandise(Sku sku, int quantite) {
        this.sku = sku;
        this.quantite = quantite;
    }
}
